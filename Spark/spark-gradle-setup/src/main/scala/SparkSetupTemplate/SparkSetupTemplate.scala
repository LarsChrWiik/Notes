package SparkSetupTemplate

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
