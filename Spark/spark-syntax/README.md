# Link
https://spark.apache.org/docs/2.4.0/index.html



# Creating spark Session

### Scala
```
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().appName("MyAppName").getOrCreate()
```

* **.appName()** Sets a name for the application which will be shown in the spark Web UI. If no application name is set, a randomly generated name will be used.

* **.getOrCreate()** Gets the existing SparkSession or create a new SparkSession if it does not exist. 

# Closing a Spark Session
You should always close your SparkSession when you are done with its use since it will free up resources for the cluster. 
```
spark.stop() 
```
**NB**: When a Spark session is closed, it cannot be opened in the same instance. If Jupyter Notebook is used, it needs to be shut down and restart it again before the spark job can be execute in the Notebook. 



# Submit Spark Job
Before submitting a Scala program, it must be compiled to *.jar* file (for example by using Gradle). 
```
spark-submit --class "HelloWorld" myPySparkJob.jar [arg1, arg2, ...]
```

### Create DataFrame
DataFrames can be created with the *implicits* function *toDF()*. To be able to use this function, *spark.implicits._* must be imported. 
```
import spark.implicits._
```

Create a DataFrame using **toDF()**:
```
val df = Seq(
  "this is cell one",
  "cell2",
  "and cell 3"
).toDF("myColumnName")
```
```
val df = Seq(
  ("this is a cell in column one", "cell in column two"),
  ("another cell", "another cell"),
  ("acb", "hello"),
).toDF("columnOneName", "columnTwoName")
```

Create a DataFrame and specify schema using **createDataFrame()**:
```
val myData = Seq(
  (9, "Stephanie"),
  (6, "Camilla"),
  (-2, "Kristine")
)

val mySchema = List(
  StructField("number", IntegerType, true),
  StructField("word", StringType, true)
)

val df = spark.createDataFrame(
  spark.sparkContext.parallelize(myData),
  StructType(mySchema)
)
```

Create a DataFrame and specify schema using **createDF()** from *spark-daria*. 
```
val someDF = spark.createDF(
  List(
    (9, "Stephanie"),
    (6, "Camilla"),
    (-2, "Kristine")
  ), List(
    ("number", IntegerType, true),
    ("word", StringType, true)
  )
)
```

### Print Schema of DataFrame
If schema is not infered or set by the user, Spark reads everything as the datatype "String". 
```
df.printSchema()
```

# Read file in Spark
There are several "option"s that can be overwritten. 

### Scala
```
val df = spark.read.format("csv")
  .option("header", "false")
  .option("delimiter", ";")
  .load("hdfs://namenode/myfile.csv")
```

### Infer Schema
If the inferScema option is not specified and no schema is provided, Spark reads every column as String.
Infering schema is generally **bad practice** for production code since it introduces uncertanty. 

Add the following option:
```
.option('inferSchema', 'true')
```

Example:
```
df = spark.read.format('csv').option('inferSchema', 'true').....
```

### Specifying Schema
Specify the schema is **good practice**. 

Example of specifying schema:
```
from pyspark.sql.types import *

mySchema = StructType([
    StructField('myColumnName', StringType(), True),
    StructField("myColumnName2", IntegerType(), True)]
])
```
* The Boolean at the end specifies if the column can be NULL. 

Add the following line to specifying the schema when reading:
```
.schema(mySchema)
```

Example: 
```
val df = spark.read.format('csv')
    .option('header', 'false')
    .option('delimiter', ';')
    .schema(mySchema)
    .load(file_location)
```

### Read multiple paths
```
spark.read.parquet(paths:_*)
```

### Read multiple paths with function call
```
paths.map(path => myFunc(spark.read.parquet(path))).reduce((df1, df2) => df1.union(df2))
```

### Read multiple paths with bracket notation
```
spark.read.parquet("this/my/folder/path/myfolder/hour=[0-23]")
```


# Write file in Spark

### Write Example
```
df.write.format("csv")
    .mode('overwrite')
    .option('header', 'false')
    .option('delimiter', ';')
    .partitionBy(...)
    .bucketBy(...)
    .sortBy(...)
    .save('hdfs://namenode/path_to_output_file')
```

### Write CSV
```
df.write.format("csv")...
```

### Write Parquet
```
df.write.format("parquet")...
```

### Write spesific number of partition
```
df.repartition(NUM_PARTITIONS).write.format("parquet")...
```

### Write spesific number of rows per pertition
```
df.write.option("maxRecordsPerFile", NUM_ROWS_PER_PARTITION).format("parquet")...
```

# Working with DataFrame Columns
Columns are specified as either *Strings* or as in instance of the *Column class*. The column class are used to do mathematical operations, logical comparisons, or string pattern matching. 

### Importing Column function
```
import org.apache.spark.sql.functions.col
```

### Specify column as String
```
df.select('age')
```

### Specify column as Column Class
```
df.select(col('age'))
```

We can also use the syntactic sugar way of getting the Column class with **$** or **'**:
```
df.select($"age")
```
```
df.select('age)
```

### Column Expression
When using column expression, we must include an instance of a column class. This will create another column with boolean values indicating whether the expression is true or false. 
```
df.select(col("age"), col("age") >= 18)
```

### Print first element
```
println(df.head())
```

### Alias - Rename Column 
```
df.select(col("age"), (col("age") >= 18).alias("adult"))
```

# DataFrame Transformation
There are several DataFrame transformations. See: https://spark.apache.org/docs/2.3.0/rdd-programming-guide.html

Note that the acutal transformation is not applied (lazy evaluated) untill an action is triggered. 

### map
The *map* transformation maps a function for each row in the dataset. 
```

```

### flatMap
The *flatMap* transformation is similar to the *map* transformation, but each input item can be mapped to 0 or more output items. flatMap therefore returns a Seq sintead of a single item. 
```

```

### select
The *select* transformation selects one or more columns from a DataFrame. 
```
df2 = df.select('age')
```
```
df2 = df.select('name', 'age')
```

### selectExpr
The *selectExpr* transformation is the same as *select*, but it supports SQL expressions. *selectExpr* uses the following template:
```
df2 = df.selectExpr("*", "age" >= 18 AS "adult")
```

### filter / where
The *filter* and *where* transformations are identical and removes rows that does not meet a certain condition. These transformations must be applied on a column class. 
```
val dfNew = df.where(col("age") === 18)
```
```
val dfNew = df.where(col("age") >= 18)
```
```
val dfNew = df.filter(col("age") >= 18)
```
```
val dfNew = df.filter(col("age").isNotNull)
```

### Union / UnionAll
```
val df1 = df.select(...)
val df2 = df.select(...)

val dfMerged = df1.unionAll(df2)
```

#### Table of operator differences between Python and Scala
| Operator | Python | Scala |
|---:|---:|---:|
| equal | == | === |
| not equal | != | =!= |
| more than or equal to | >= | >= |
| less than or equal to | <= | <= |
| and | & | && |
| or | \| | \|\| |
| needs parentheses for multiline expression | yes | no |

#### More filtering examples (Python): 
```
df2 = df.filter(col("age") == 18)
```
```
df2 = df.filter(col("age") != 18)
```
```
df2 = df.filter((col('age') != 18) & (col('age') != 20)).show(10)
```

### distinct / dropDuplicates
The *distinct* and *dropDuplicates* transformations are identical and removes duplicated rows. 
```
df2 = df.distinct
```
```
df2 = df.distinct("myColumn")
```
```
df2 = df.dropDuplicates("myColumn")
```

### sort / orderBy
The *sort* and *orderBy* transformations are identical and reorders the rows. These transformations must be applied on a column class. By default, the sorting is in ascending order. Specify *asc* or *desc* at the end when needed. 
```
df2 = df.sort(col("myColumn"))
```
```
df2 = df.orderBy(col("myColumn"))
```
```
df2 = df.orderBy(col("myColumn").desc)
```
```
df2 = df.orderBy(col("myColumn").asc, col("myColumn2").asc)
```

### How to add row number as column
```
df.withColumn("rowNum", monotonicallyIncreasingId)
```

### limit
The *limit* transformation returns a new DataFrame by taking the first n rows. Limit is commonly used after sorting to return the top *n* or bottom *n* rows. 
```
df2 = df.limit(5)
```

### union
The *union* transformation combines two DataFrames (with the same schema). 
```
df3 = df.union(df2)
```

### withColumn (add column)
The *union* transformation is similar to the *selectExpr* transformation and is used to add another column to the DataFrame. 
```
df2 = df.withColumn("myNewColumnName", "age" >= 18 AS "adult")
```

### withColumnRenamed
The *withColumnRenamed* transformation renamed an existing column name in a DataFrame. 
```
df2 = df.withColumnRenamed("myExistingColName", "myNewColName")
```

### cache
We can cache a DataFrame to persist it in memory. 
```
val df2 = df.cache()
```

### drop
The *drop* transformation removes the specified columns from the DataFrame. It is similar to *select*, but instead of selecting spesific columns to keep, *drop* can be used to remove columns you want to remove. *drop* is normally when we wish to remove only a few columns from a DataFrame with several columns. 
```
df2 = df.drop("myColumn")
```
```
df2 = df.drop("myColumn", "myOtherColumn")
```

### sample
The *sample* transformation returns randomly selected rows from the DataFrame given a percentage (number between 0 and 1) and might sample with or without replacement. This is an example of sampling 10% of the DataFrame without replacement. 
```
df2 = df.sample(False, 0.1)
```

# DataFrame Actions / Usefull functions
Actions are eagerly evaluated and therefore triggers all stored transformations within DataFrames. 

### show
The *show* function displays the first *n* rows in a DataFrame. 
```
df.show(5) 
```

### count
Counts the number of rows in a DataFrame. 
```
df_small.count()
```

### describe
The *decribe* function displays basic statistics of the data. 
```
df.describe("myColumn")
```

### na.drop
the na.drop functionality allows us to drop rows with null values, either if any column contains null or if all columns contain null within each row. It is also possible to specify this on certain columns. 
```
df.na.drop("any")
```
```
df.na.drop("all")
```
```
df.na.drop(Array("myColumn"))
```



# Datasets
https://spark.apache.org/docs/2.3.0/api/java/index.html?org/apache/spark/sql/Dataset.html

The Dataset APIs are available in only strongly typed languages such as **Scala** and **Java**. Dataset is newer than the DataFrame. Dataset is mapped to a defined schema. Datasets are strongly typed and object-oriented. The Dataset APIs are good for production jobs that need to run on a regular basis and are written and maintained by data engineers. For most interactive and explorative analysis use cases, using the DataFrame APIs would be sufficient.

DataSet might want to be chosen instead of DataFrame when it is desired to have a higher degree of type safety at compile time.

To convert a DataFrame to a Dataset, we first need to define a case class and then to the convertion. 
```
case class Person(firstname:String, lastname:String, age:Long)
val moviesDS = df_persons.as[Person]
```






<br><br><br><br><br>






### Parsing error
By default, when Spark encounters a corrupted record or runs into a parsing error, it will set the value of all the columns in that row to null. 

However, we can tell spark to fail when there is a parsing error by using the failFast mode:
```
.option("mode","failFast")
```





### Escape chracter when reading
Specify a the character used to escape the next character in the column value. 
```
.option('escape', '\')
```

### Spark SQL
```
spark.sql("SELECT * from myTable")
```

### Create View from DataFrame
This view can only be accessed from the current spark session. 
```
df.createOrReplaceTempView("myTable")
df_query = spark.sql('\
    SELECT name, age \
    FROM myTable \
    WHERE age <= 18 \
')
```

### Create Global View from DataFrame
This global view can be accessed from other spark sessions. 
Global views must be prefixed with the key word 'global_temp'. 
```
df.createOrReplaceGlobalTempView("myGlobalTable")
df_query = spark.sql('\
    SELECT name, age \
    FROM global_temp.myTable \
    WHERE age <= 18 \
')
```

### Multiline SQL statement with """
```
df.createOrReplaceTempView("myTable")
df_query = spark.sql("""
    SELECT name, age
    FROM myTable
    WHERE age <= 18
""")
```

### Mixing SQL statements and DataFrame transformations
```
df_query = spark.sql('\
    SELECT name, age \
    FROM myTable \
').where('age <= 18')
```

### Query SQL from file
```
spark.sql('select * from parquet.<path>/myfile.tablename.parquet')
```

### Show tables in spark catalog
```
spark.catalog.listTables.show
```

### Where / Filter and Not
```
df.where(col("foo") > 0)
df.where((col("foo") > 0) & (col("bar") < 0))
```
```
df
 .where($"myCol".contains("www.mydomain."))
 .where(!$"myCol".contains("google"))
```
```
df.where($"myCol".contains("www.mydomain.") && not($"myCol".contains("google")))
```

### Map / WithColumn When and Not
```
df.withColumn("myCol", when($"myCol".contains("\""), lit("INVALID_FORMAT")).otherwise($"myCol")) 
```
```
import org.apache.spark.sql.functions.not
df.withColumn("myCol", when(not($"myCol".contains("\"")), lit("INVALID_FORMAT")).otherwise($"myCol")) 
```

### groupby + Agg + fraction calculation
```
import org.apache.spark.sql.functions.{col, count, avg, round, lit, concat}

val df2 = df
  .groupBy("myCol1", "myCol2")
  .agg(count("myCol3") as "myCustomName1", round(avg("myCol4"), 1) as "myCustomName2")
  .orderBy(col("myCol1").asc)
  .withColumn("fraction", concat(lit(round(col("myCustomName1") * 100 / df2.count, 1)), lit("%")))
```

### TODO
* .toPandas()
* .limit()

### Create DataFrame
```
spark.createDataFrame(my_list, col_name).show()
```

### Filtering
Same as in Pandas. 
```
ds[(ds.Newspaper < 20) & (ds.TV > 100)].show(4)
```

## Connection to JDBC
Filterings in a JDBC connection are pushed down to the actual database, which reduces the amount of data Spark needs to read. 
```
jdbcDF = spark.read \
    .format("jdbc") \
    .option("url", "jdbc:postgresql:dbserver") \
    .option("dbtable", "schema.tablename") \
    .option("user", "username") \
    .option("password", "password") \
    .load()
```

### Join
```
df.join(df2, Seq(Keys.myColumnName1, Keys.myColumnName2), "outer").na.fill("0")
```

```
val resultDf = df1
  .join(df2, df1("idCol") === df2("otherIdCol"))
```

### Example of using Delta Storage
https://docs.delta.io/latest/quick-start.html

```
from pyspark.sql import SparkSession

spark = SparkSession.builder\
    .config('spark.jars.packages', 'io.delta:delta-core_2.11:0.4.0')\
    .appName('MyAppName').getOrCreate()

df = spark.read.format('csv')\
    .option('header', 'true')\
    .option('inferSchema', 'true')\
    .option('delimiter', ';')\
    .load('hdfs://namenode/path_to_file.csv')

df2 = df[['asset_owner_id', 'asset_id']]

df2.write.format("delta").mode('overwrite').save('hdfs://namenode/path_to_output_file')
```

Run spark-submit and specify the package: 
```
spark-submit --packages io.delta:delta-core_2.11:0.4.0 mytestlars.py
```

### Pivot Table
```
val df3 = df2.groupBy($"myCol1", $"myCol2")
  .pivot("myCol3")
  .agg(count($"myCol4"))
```

### CountDistinct
```
df.groupBy(...).agg(countDistinct(...)
```

### User Defined Functions (UDF) / Map function on column
NB: Try to avoid putting an UDF inside a class, put the UDF instead in an object outside of the class. 
Or else we will get an error saying that the class is not serializable. This is because a pointer to the class will be sent into the UDF. 
```
import org.apache.spark.sql.functions.udf

val udfFunction = udf(myUdfTransformation _)
def myUdfTransformation(mycol: String): String = {
  ...
}

val df2 = df.withColumn("exampleColumn", myUdfFunction($"exampleColumn2WithStringValue"))

```

We can also manippulate the actual DataFrame column *exampleColumn*:
```
val df2 = df.withColumn("exampleColumn", myUdfFunction($"exampleColumn"))
```

Example of using UDF in class:
```
object myUdfObject {
  def myUdfTransformation(mycol: String): String = {
    ...
  }
  val myUdfFunction = udf[String, String](myUdfTransformation)
}

class {
  def myClassFunction(df: DataFrame): DataFrame = {
    df.withColumn("exampleColumn", myUdfObject.myUdfFunction($"exampleColumn"))
  }
}
```




### TODO
spark.conf.set("spark.sql.sources.partitionOverwriteMode","dynamic")

df.repartition(1)

df.write.partitionBy("asset_owner_id").mode('overwrite').csv('hdfs://namenode/losore/2/losore.csv')

#df.write.mode('overwrite').parquet('hdfs://namenode/losore/2/losore.parquet')

df.createOrReplaceTempView("asset_owner_ids_view")
asset_owner_ids = list(df_small.toPandas()['asset_owner_id'])

cache vs persist?

toDF()

# Filter column based on type (Int)
```
val df2 = df.withColumn("myCol", col("myCol").cast(IntegerType)).filter(col("myCol").isNotNull)
```

# Scala Examples


### Create DataFrame
```
val movies = Seq(("Brad Pit", "Ad Astra", "2019"), ("Brad Pit", "Fight CLub", "1999"))
val moviesDF = movies.toDF("actor", "title", "year")
```

# Partition optimization
All partitions become tasks within stages of execution. Because each partition can be operated on in parallel, that means that your processing jobs can be distributed evenly across all of your available Spark Executors. (Spark Executors are the JVM processes running on your Spark Workers)

### Cache
Using cache appropriately within Apache Spark allows you to be a master over your available resources. 

Memory is not free, although it can be cheap, but in many cases the cost to store a DataFrame in memory is actually more expensive in the long run than going back to the source of truth dataset. If you have taken a look at the Spark UI (runs on port 4040 when spark.ui.enabled is set to true) and have determined that you can’t squeeze performance out of the system, then you are a candidate for applying caching.

Mainly if the most time taken during your computations is loading data from System A or B or C (say HDFS or MySQL or Redis) and you can’t speed up anymore by scaling out. Scaling out with spark means adding more CPU cores across more RAM across more Machines. Then you can start to look at selectively caching portions of your most expensive computations.



Dataset's persist and cache operators are lazy (contrary to SQL's CACHE TABLE queries) and hence after the following it won't be really cached. That leads to a pattern where people execute head or count actions to trigger caching.



Shuffle. 

With wide shuffle partition, then the partition count=200. 


### Spark UI
Shuffle read, suffle write, detect data skew. 


Data serialization vs deserialization. MEMORY_DISK_ONLY_SER and so on. Write about this. 



### Example
```
val partitionKeys = list("myCol1", "myCol2")
df
  .repartition(partitionKeys.map(col): _*)
  .write
  .mode(SaveMode.Overwrite)
  .option("compression", "gzip")
  .option("maxRecordsPerFile", numRowsPerPartition)
  .partitionBy(partitionKeys: _*)
  .parquet(path)
```
