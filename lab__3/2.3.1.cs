package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


  object Main {
    def main(args: Array[String]): Unit = {
      val spark = SparkSession.builder()
        .appName("Spark DataFrame Example")
        .master("local[*]")
        .getOrCreate()
		
      val peoplePath = "C:///spark/examples/src/main/resources/people.json"
      val employeesPath = "C:///spark/examples/src/main/resources/employees.json"

      val peopleDF = spark.read.json(peoplePath)
      val employeesDF = spark.read.json(employeesPath)

      println("People DataFrame:")
      peopleDF.show()

      println("Employees DataFrame:")
      employeesDF.show()

      spark.stop()
    }
  }




