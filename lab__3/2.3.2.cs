package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.functions._


  object Main {
    def main(args: Array[String]): Unit = {
      val spark = SparkSession.builder()
        .appName("Spark DataFrame to List and RDD")
        .master("local[*]")
        .getOrCreate()

      val colors = List("white", "green", "yellow", "brown", "pink")

      val colorDF: DataFrame = spark.createDataFrame(colors.map(x => (x, x.length))).toDF("color", "length")

      println("Initial DataFrame:")
      colorDF.show()

      val sortedAscDF = colorDF.orderBy(asc("length"))

      println("DataFrame Sorted in Ascending Order:")
      sortedAscDF.show()

      val sortedDescDF = colorDF.orderBy(desc("length"))

      println("DataFrame Sorted in Descending Order:")
      sortedDescDF.show()

      spark.stop()
    }
  }




