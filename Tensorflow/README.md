# Tensorflow Fundamentals

### Basic Info
* Open source
* Used for large scale ML/DL applications
* Created by Google, part of Google Brain
* TF is used in Google Maps, Gmail, and more
* TF is considered difficult to adopt compared to PyTorch, Theano, OpenCV, etc
* TF 2 tries to be simpler than TF 1
* TF 2 was released in September 2019

### Tensorflow's main components
Tensorflow is basically a combination of two components:
1. Computational graph library
2. A runetime for executing computational graphs

### What is a Tensor?
A tensor is simply a multidementional array.
* Scalar is a zero-dimentional tensor (rank 0 tensor)
* Vector is a one-dimentional tensor (rank 1 tensor)
* Matrix is a two-dimentional tensor (rank 1 tensor)

A tensor has a shape inducating the number of values in each dimension:
* The shape of scalar “42” is []
* The shape of vector “[5,6,7]” is 3
* The shape of matrix “[[6,7,5,6,7],[4,6,7,9,8]]” is [5, 2]

### Flow - Graph
“Flow” in Tensorflow refers to the underlying graph computation framework that uses tensors for its execution. TensorFlow uses directed acyclic graphs internally to represent computations, which is called **computational graphs** or **data flow graphs**.
* Computations are hierarchical
* The computational graph in Tensorflow is directed acyclic
* Nodes represent operations or variables
* Edges correspond to tensors
* Leaf nodes represent transformed tensors
* Nodes in the same level can be computed in prallel

The bennefits of struturing our program with a directed acyclic graphs are:
* Easier for parallelisation
* Dependency based scheduling
* Abstracting complex expressions and computations without actually evaluating the values
* Better portability (since a graph is language agnostic)
    * We can store the model using Probuff and restore it in another language, for example C++

Here is an example of a tensorflow program with a diagram:
```python
import tensorflow as tf

with tf.Session() as session:
    # Step 1: Creating the computational graph
    a = tf.constant(15)
    b = tf.constant(5)
    prod = tf.multiply(a, b)
    sum = tf.multiply(a, b)
    res = tf.divide(mul, sum, b)

# Step 2: Running the session
out = session.run(res)
print(out)
```
![](./TF-graph.png)

### Tensorflow Graph Basics
A computational graph in Tensorflow can be build using several components:
* **Variables**: Variables in Tensorflow represent shared, perisstent states that can be manipulated by *Operations*. Variables can be modified. But, Variables have to be initialized before running the graph session.
* **Operations**: Represent nodes in the Graph. Operations (Ops) perform computations on tensors according to spesific rules.
* **Placeholders**: Placeholders is defined with a shape and a datatype and work as "empty nodes". The value for placeholders are provided at a later stage. They are typically used for feeding in inputs and labels.
* **Constants**: Parameters that cannot be changed.
* **Graph**: The other components are part of a spesific graph.
* **Session**: Creates the runtime. It allocates memory and store values for intermediate results and variables.

Tensorflow provides a **default graph** when creating a sesion, so we don't actually have to initializw a Graph object since we can the default graph. But for advanced users, it is possible to create multiple graphs.

To analyse Tensorflow graphs, we can use **Tensorboard**.

### Lazy evaluation in Graphs
Tensorflow 1 is lazily evaluated, see exmaple below:
```python
# Out of memory error!
a = np.zeros(int(1000000000000), int(1000000000000))

# Ok! Since allocation is delayed until the graph is executed.
a = tf.zeros(int(1000000000000), int(1000000000000))
```

The distinction between declaration and allocation allows Tensorflow to distributde the workload on different machines.

### Keras and Estimator
**tf.keras** was originally meant for small-scale models in TF v1.0. **Estimator** was also introduced by Tensorflow, and designed for scaling ML training. Estimator was segined for TF 1.0 and required sessions. Tensorflow 2.0 combines the power of simple Keras syntax and the power of estimators in **tf.keras**.

## New in 2.0
* InteractiveSession is not needed
* graph definition is not needed
* Variable initialization is not needed
* Variable sharing via scopes is not needed
* Lifetime of state objects is determined by the lifetime of their corresponding Python object, not the session object

### Comparing Tensorflow 1.0 to 2.0 syntax
TF 1.0
```python
graph = tf.Graph()
with graph.as_default():
    a = tf.constant([[10,10],[11.,1.]])
    x = tf.constant([[1.,0.],[0.,1.]])
    b = tf.Variable(12.)
    y = tf.matmul(a, x) + b
    init_op = tf.global_variables_initializer()
with tf.Session() as sess:
    sess.run(init_op)
    print(sess.run(y))
```
TF 2.0
```python
a = tf.constant([[10,10],[11.,1.]])
x = tf.constant([[1.,0.],[0.,1.]])
b = tf.Variable(12.)
y = tf.matmul(a, x) + b
print(y.numpy())
```

## tf.function
**tf.function** converts normal Python code into Tensorflow graph code using the **@tf.function** decorator. Example:
```python
@tf.function
def my_tf_function(x):
  a = tf.constant([[2.0], [3.0]])
  b = tf.constant(4.0)
  return a+b
```
Side effects of using tf.function:
* print() works only once. Use tf.print() instead.


### Eager evaliation with Tensorflow 2.0
Tensorflow 2.0 introduced "eager evaluation" making debugging easier.
