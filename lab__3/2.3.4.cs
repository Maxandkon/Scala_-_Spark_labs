package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Dataset

case class Author(FirstName: String, LastName: String, Dob: String)

  object Main {
    def main(args: Array[String]): Unit = {
      val spark = SparkSession.builder()
        .appName("Spark DataFrame Operations")
        .master("local[*]")
        .getOrCreate()

      import spark.implicits._

      val authors = Seq(
        Author("Thomas", "Hardy", "June 2, 1840"),
        Author("Charles", "Dickens", "7 February 1812"),
        Author("Mark", "Twain", null),
        Author("Emily", null, null)
      )

      val ds1: Dataset[Author] = spark.createDataset(authors)

      println("Initial DataSet:")
      ds1.show()

      val ds2 = ds1.na.drop(Seq("LastName"))

      println("DataSet after removing empty values in LastName:")
      ds2.show()

      spark.stop()
    }
  }




