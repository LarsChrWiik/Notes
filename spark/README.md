# Apache Spark Fundamentals
See official Apache Spark documentation: https://spark.apache.org/docs/2.3.0/sql-programming-guide.html

## What is Apache Spark?
* Apache spark is an open-source general-purpose cluster-computing framework for large-scale data processing. 
* Spark offers high performance for both batch processing and interactive / real-time processing. 
* Spark provides a simple way to parallelize tasks across clusters, and hides the complexity of distributed systems programming, network communication, and fault tolerance
* Its API is primarily implemented in **Scala** and supports **Java**, **Python** and **R**
* Spark needs to be integrated with a file system; if not HDFS, another cloud-based data platform could be used. For this reason, many Big Data projects involve installing Spark on top of Hadoop, where Spark’s advanced analytics applications can make use of data stored using the **Hadoop Distributed File System (HDFS)**. 
* Spark can be used as a high-level language to process distributed data without using difficult Hadoop batch processing tools such as Hive and Pig
* Spark uses lazy loading. 
* A huge missconception with Spark is that it requires all data to be in memory, which is false. It is true that Spark utilizes in-memory processing, which makes Spark lightning fast, but Spark does not require all data to be in memory. 

## Spark Components
* **Spark Core**: Spark Core contains the basic functionality of Spark, including components for task scheduling, memory management, fault recovery, interacting with storage systems, and more
* **Spark SQL**: is Spark’s module for working with structured data using the SQL syntax 
* **Spark streaming**: a Spark component that enables processing of live streams of data (feks logfiles or or queues of messages)
* **MLlib**: is a distributed Machine Learning framework on top of Spark. 
* **GraphX**: provides API for large scale graph processing. 

## Running Spark applications
We can run Spark applications by using:
* **Interactive shell**: commonly used for data exploration
* **Submitting a Spark job**: Used for automated processes 

To run a spark application, it is required to use a cluster manager, such as **YARN** or Spark **Standalone**. When a Spark job is run using YARN, it is managed by YARN ResourseManager and NodeManager. 

## Spark Shell
There are variants of Spark shell for different languages: 
* **Scala**: Spark-shell
* **Python**: Pyspark
* **R**: SparkR

#### Spark location
Some locations where *SPARK_HOME* might default to:
* */spark/*
* */usr/bin/spark*
* */usr/local/spark*

#### Start the Spark-shell:
* **Scala**: ./SPARK_HOME/bin/spark-shell
* **Python**: ./SPARK_HOME/bin/pyspark

Or locate the spark folder and run: *./spark-shell*

## Spark RDD (Prior Spark 2.0)
Resiliant Distributed Datasets (RDD) is Spark's data abraction layer. Understanding how RDDs work are essenial for understanding Spark. Past Spark 2.0, directly interacting with RDD is less relevant, but understanding how the underlying tools work is still prefered. RDDs provides a rich set of operations to make it easy to perform data analysis in Spark. 
* Operations are classified into two types: transformation and action. Transformations are designed to be *lazy evaluated* to provide opportunities for Spark to perform optimizations. Actions are *eager evaluated*, and they trigger the computation of all the transformation logic that preceded the call to an action. The lazay evaluation technique allow optimization to be done behind the scenes and potentially collapse or combine transformation steps. 
* Transformation are lazily evaluated. Some examples of transformations are *map*, *filter*, *substract*. Actions on an RDD triggers all stored transformation. Some examples are actions are *count*, *reduce*, *saveAsTextFile*. 
* RDDs are immutable, meaning that you cannot change an RDD, but rather define a transformation step ad create a new RDD. 
* RDDs are designed for parallell computatoin and in memory processing. 
* RDD persistence is a great way to speed the computation logic in your Spark jobs. 
* The data shuffle is an expensive but necessary data movement process, so it is important for Spark developers to be familiar with it. The goal is to not eliminate the shuffle process but to minimize the number of times the shuffling needs to happen in your Spark application.

## Spark DataFrame
The RDD was the initial core programming abstraction. A new programming abstraction called Structured APIs was introduced in Spark 1.6, which includes **DataFrames** and **Datasets** that defines the high-level APIs for working with structured data in Spark. A DataFrame is a Dataset organized into named columns. It is conceptually equivalent to a table in a relational database or a DataFrame in R/Python using **Pandas**, but with richer optimizations under the hood. The main difference is that a DataFrame in Spark can handle a large volume of data that is spread across many machines. 

A DataFrame is an immutable, distributed collection of data that is organized into rows, where each one consists a set of columns and each column has a name and an associated type. In other words, this distributed collection of data has a structure defined by a schema. Unlike
the RDD APIs, the DataFrame APIs offer a set of domain-specific operations that are relational and have rich semantics. Like the RDD APIs, the DataFrame APIs are classified into two buckets: transformations and actions. The evaluation semantics are identical in RDDs. Transformations are lazily evaluated, and actions are eagerly evaluated. 

## Spark SQL
Spark has an integrated SQL module that allows the users to type SQL to query the data. This allows those familiar with the SQL language to use Spark. 

## SparkSession vs. SparkContext and SparkConfig (Prior Spark 2.0)
SparkContext and SparkConfig was used prior to Spark 2.0 but was then replaced with **SparkSession**. 
**SparkContext** was used to create a Spark context object. **SparkConfig** was used to store parameters such as app name, number of cores, memory size, and so on. 

## Show all Configurations
*Spark* is a SparkSession object
```
spark.conf.getAll.foreach(println)
```

## Data Sources in Spark
Spark use the following data sources:
* **Parquet** (Binary): Like RC and ORC, Parquet files are compressed, which provides query performance benefits. Parquet is generally slower to write than non-columnar file formats. In Parquet, new columns can be added at the end of the structure. Parquet is known to be fast when using Spark SQL. Spark performs best with Parquet. 
* **ORC**: (Binary) ORC Files or Optimized RC Files were invented to optimize performance in Hive. This means ORC files compress better than RC files, but has the same overall limitations to adding columns (schema evolution). However, Impala does not support ORC. ORC also supports Indexes, and ACID transaction guarantees. Hive performs best with ORC. 
* **RC**: RC Files or Record Columnar Files were the first columnar file format adopted in Hadoop. RC can be significantlt compressed and can provide query performance benefits. However RC files does not support adding columns. 
* **CSV / TXT**: (Text) CSV files are often used for exchanging data between Hadoop and external systems. It is easy to use CSV when dumping data from databases. But CSV does not support compression, which makes reading from disk slow. 
* **Avro files**: (Binary) Avro files are quickly becoming the best multi-purpose storage format within Hadoop. Avro files are splittable, support block compression, and is a relatively mature storage type within the Hadoop ecosystem. 
* **JSON**: (Text) JSON files do not support block compression, which might makes replication difficult in hadoop since splitting the JSON file is not trivial. JSON records on the other hand is splittable, and can be easily used. 
* **Sequence**: Sequence files store data in a binary format with a similar structure to CSV. Unlike CSV, sequence files do support block compression. But due to the complexity of reading sequence files, it is often used within a sequence of a MapReduce job, not as a data source. 
* **JDBC or other Database**: (Binary) Common format for reading and writing to RDBMS. 
* **Hive Tables**:

#### Additional Data Source from Databricks (Delta)
* **Delta**: https://delta.io/


#### In short
* Sequence files are preferred when storing intermediate data between MapReduce jobs. 
* ORC or Parquet are optimal when the query performance is most important. 
* Avro is good when the schema is going to change over time and query performance is not critical. 
* CSV files are excellent if you are going to extract data from Hadoop to bulk load into a database.

Large files in Hadoop consume a lot of disk - especially when considering standard 3x replication. So, there is an economic incentive to compress data. There is also a performance incentive as disk IO is expensive. If you can reduce the disk footprint through compression, you can relieve IO bottlenecks. 

Here is an example of disk size, given file type:

| File Type | Disk Size |
|---|---|
| Uncompressed CSV | 1.8 GB |
| Avro | 1.5 GB |
| Avro w/ Snappy Compression | 750 MB |
| Parquet w/ Snappy Compression | 300 MB |

## Performance considerations using HDFS
There are three types of performance to consider:  
* Full read performance (how fast can you read every data element in a file)
* Partial read performance (how fast can you read individual columns within a file)
* Write performance (how fast can the data be written)

A columnar, compressed file format like Parquet or ORC may optimize partial and full read performance, but they do so at the expense of write performance. While uncompressed CSV files are fast to write, but are slow for reads due to the lack of compression.

Any format that is not splittable should generally be avoided. The use of **XML** File and **JSON** File formats is a common mistake.
