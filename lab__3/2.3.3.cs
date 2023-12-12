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
        .appName("Spark OrderBy Tables")
        .master("local[*]")
        .getOrCreate()

      val colors = List("white", "green", "yellow", "red", "brown", "pink")

      val colorDF: DataFrame = spark.createDataFrame(colors.map(x => (x, x.length))).toDF("color", "length")

      println("Table:")
      colorDF.show()

      val sortedTable1 = colorDF.orderBy(asc("length"), asc("color"))

      println("Sorted Table 1:")
      sortedTable1.show()

      val sortedTable2 = colorDF.orderBy(asc("length"), desc("color"))

      println("Sorted Table 2:")
      sortedTable2.show()

      val table3 = spark.createDataFrame(colors.map(x => (x, x.length))).toDF("color", "length")

      val sortedTable3 = table3.orderBy(asc("color"))

      println("Sorted Table 3:")
      sortedTable3.show()

      spark.stop()
    }
  }




