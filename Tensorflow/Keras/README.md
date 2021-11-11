# Keras - The high-level API in Tensorflow
**Keras** is the official high-level API for Tensorflow 2.0.

Keras in an API standard and an independent project [Keras.io](https://www.keras.io), and is included in Tensorflow through the **tf.keras** module.

The Keras API has implementations for TensorFlow, MXNet, TypeScript, JavaScript, CNTK, Theano, PlaidML, Scala, CoreML, and more...

Key points about Keras in general:
* High-level API
* User friendly
* Modular and composable
* For beginners and experts!

The version of Keras in Tensorflow adds additional functionallity:
* Support for tf.data, which is good for scaling your project (but it also supports numpy and Pandas)
* Supports distributed training
* Exporting models (serialized in Tensorflow SavedModel format)
* Allow models in Tenorflow Lite for mobile devices
* Supports *tf.feature_columns*


## Estimator (TF 1) and Keras (TF 2)
**Estimator** was the go-to high-level API of Tensorflow 1. In Tensorflow 2, **Keras** is the preferred high-level API. **tf.keras** was originally meant for small-scale models in Tensorflow 1, while **Estimator** was designed for scaling ML training in Tensorflow. Estimator was designed spesifcally for Tensorflow 1 and required sessions. Tensorflow 2.0 combines the power of the simple Keras syntax and the power of estimators in **tf.keras**.


## Keras Syntax

### Keras Sequential Model
```python
import tensorflow as tf

# Get data
train_X, train_y, test_X, test_y = ...

# Create model
model = tf.keras.Sequential()
model.add(tf.keras.layers.Dense(256, activation=tf.nn.relu, input_shape=(128,)))
model.add(tf.keras.layers.Dense(10, activation=tf.nn.softmax))
model.compile(loss="categorical_crossentropy", optimizer="adam")

# Train
model.fit(train_X, train_y, epochs=5)

# Evaluate
loss, accuracy = model.evaluate(test_X, test_y)

# Predict
pred = model.predict(test_X)
```

### Keras Multi Input Model
```python
import tensorflow as tf

# Vision model
vision_model = tf.keras.Sequential()
image_input = Input(shape=(224, 224, 3))
vision_model.add(tf.keras.layers.Conv2D(64, (3,3), activation="relu", input_shape=(224, 224, 3)))
vision_model.add(tf.keras.layers.MaxPooling2D())
vision_model.add(tf.keras.layers.Flatten())
encoded_image = vision_model(image_input)

# Language Model
question_input = tf.keras.Input(shape=(100,), dtype="int32", name="Question")
embedding_layer = tf.keras.layers.Embedding(input_dim=10000, output_dim=256, input_length=100)(question_input)
encoded_question = td.keras.layers.LSTM(256)(embedding_layer)

# Merge models
merged_model = tf.keras.layers.concatinate([encoded_image, encoded_question])
output_layer = tf.keras.layers.Dense(1000, activation="softmax")(merged_model)

# Final model
model = tf.keras.Model(
    inputs=[image_input, question_input], 
    outputs=output_layer
)
```

### Metrics with Keras model
Keras allow the user to provide metrics when compiling a model. We can use the built in metrics functions or use our own.

See: https://www.tensorflow.org/api_docs/python/tf/keras/metrics

Example:
```python
from tf.keras import metrics

def my_custom_f1_score(y_true, y_pred):
    precision = precision_m(y_true, y_pred)
    recall = recall_m(y_true, y_pred)
    return 2*((precision*recall)/(precision+recall+K.epsilon()))

model.compile(
    loss='mean_squared_error',
    optimizer='sgd',
    metrics=[metrics.mae, metrics.categorical_accuracy, my_custom_f1_score])
```
