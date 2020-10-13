package SparkSetupTemplate

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
