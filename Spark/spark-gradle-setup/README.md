
# How to setup a local Spark environment with Gradle

1. Initialize gradle as a Scala application. 
```
gradle init --type scala-library
```

2. Add Spark dependencies in *build.gradle*
```
dependencies {
    ...

    compile "org.apache.spark:spark-sql_2.12:2.4.4"
    compile "org.apache.spark:spark-core_2.12:2.4.4"
}
```

3. Create main *Object* file in *src/main/scala/myPackage/*
```
package myPackage

import org.apache.spark.sql.{DataFrame, SparkSession}

object SparkSetupTemplate {
  val FilePath = "pathToFile.parquet"
  val AppName = "CategoryTreeApp"

  def exampleFunction(df: DataFrame): DataFrame = {
    df.select("*")
  }

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName(AppName).getOrCreate()
    val df = spark.read.parquet(FilePath)
    val df2 = exampleFunction(df)
    df2.show(false)
    spark.stop()
  }
}
```

4. Create test class file in *src/test/cala/myPackage/*
```
package myPackage

import org.scalatest.FlatSpec
import org.scalatestplus.junit.JUnitRunner
import org.apache.spark.sql.SparkSession
import org.junit.runner.RunWith
import org.apache.log4j.{Level, Logger}

@RunWith(classOf[JUnitRunner])
class SparkSetupTemplateTest extends FlatSpec {

  Logger.getLogger("org").setLevel(Level.OFF)
  Logger.getLogger("akka").setLevel(Level.OFF)
  private val spark = SparkSession.builder().config("spark.master", "local").getOrCreate()
  import spark.implicits._

  it must "not do anything" in {
    val dfInput = List(
      17,
      19
    ).toDF("age")

    val dfExpected = List(
      17,
      19
    ).toDF("age")

    val dfTransformed = SparkSetupTemplate.exampleFunction(dfInput)
    val dfDiff = dfTransformed.exceptAll(dfExpected)
    assert(dfDiff.count() == 0)
  }
}

```
