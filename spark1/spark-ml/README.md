
# Spark ML



# Example Project

```python
import os
from pyspark.sql import SparkSession
from pyspark.ml.feature import VectorAssembler
from pyspark.sql.functions import isnan, when, count, col, lit
from pyspark.ml.regression import RandomForestRegressor
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml import Pipeline
from pyspark.ml.tuning import CrossValidator
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml.tuning import ParamGridBuilder
```

#### Create Spark session and read the data
```python
spark = SparkSession.builder.master("local[*]").getOrCreate()
df = spark.read.csv("data.csv", inferSchema=True, header=True)
```

#### Schema investigation
```python
df.printSchema()

root
 |-- Make: string (nullable = true)
 |-- Model: string (nullable = true)
 |-- Year: integer (nullable = true)
 |-- Engine Fuel Type: string (nullable = true)
 |-- Engine HP: integer (nullable = true)
 |-- Engine Cylinders: integer (nullable = true)
 |-- Transmission Type: string (nullable = true)
 |-- Driven_Wheels: string (nullable = true)
 |-- Number of Doors: integer (nullable = true)
 |-- Market Category: string (nullable = true)
 |-- Vehicle Size: string (nullable = true)
 |-- Vehicle Style: string (nullable = true)
 |-- highway MPG: integer (nullable = true)
 |-- city mpg: integer (nullable = true)
 |-- Popularity: integer (nullable = true)
 |-- MSRP: integer (nullable = true)
```

#### Data cleanup
```python
def replace(column, value):
    return when(column != value, column).otherwise(lit(None))

df2 = df.withColumn("Market Category", replace(col("Market Category"), "N/A"))

df3 = df.na.drop()
```

#### Creating the ML pipeline
```python
assember = VectorAssembler(
    inputCols=["Year", "Engine HP", "Engine Cylinders", "Number of Doors", "highway MPG", "city mpg", "Popularity"], 
    outputCol="Attributes"
)

regressor = RandomForestRegressor(featuresCol="Attributes", labelCol="MSRP")

pipeline = Pipeline(stages=[assember, regressor])

# Overwrite the previous "pipeline" with the current pipeline. It is stored in a filder called "pipeline"
pipeline.write().overwrite().save("pipeline")
```

#### Hyperparameter tuning with Cross Validation
```python
pipeline_loaded = Pipeline.load("pipeline")

# Add parameters to grid search with.
param_grid = ParamGridBuilder().addGrid(
    regressor.numTrees, 
    [100, 500]
).build()

# Using cross validation to get the best parameters.
crossval = CrossValidator(
    estimator=pipeline, 
    estimatorParamMaps = param_grid,
    evaluator=RegressionEvaluator(labelCol="MSRP"),
    numFolds=3
)

train_data, test_data = df3.randomSplit([0.8, 0.2], seed=123)

cv_model = crossval.fit(train_data)

# Get the best model from the grid search.
best_model = cv_model.bestModel
```

#### Make predictions
```python
# Transform the test data. 
# "cv_model.transform"  is the same as  "cv_model.bestModel.transform"
# pred is a DataFrame similar to the test_data, but with an additional column "prediction"
pred = cv_model.transform(test_data)

# Compare the MSRP target with the prediction.
pred.select("MSRP", "prediction").show()

+-----+------------------+
| MSRP|        prediction|
+-----+------------------+
|28030|32671.344717868586|
|30550| 37884.24115260902|
|29350|28037.933413566556|
|27900|  27372.1546882574|
|34890|  27372.1546882574|
|32990|  27372.1546882574|
| 2827|  4563.61421253068|
| 3000|  4563.61421253068|
| 3086| 4660.176319562199|
| 3130| 4660.176319562199|
| 3012| 4584.669006925934|
| 3622| 4867.463520818037|
|22300|24505.427933277984|
|19400|22749.467103870742|
| 2042| 4889.334944832975|
| 2144| 4956.660562123625|
|49440|  39707.5953287789|
|52640|  39707.5953287789|
|47440| 39835.78526468445|
|58400| 39844.08062051626|
+-----+------------------+
```

#### Evaluate Model Performance
```python
evaluator = RegressionEvaluator(labelCol="MSRP")
mse = evaluator.evaluate(pred, {evaluator.metricName: "mse"})

print(f"MSE: {mse}")
MSE: 1334170073.7557561
```
