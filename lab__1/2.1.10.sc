package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("SumOfSquaresRDDExample").setMaster("local")

      val sc = new SparkContext(conf)
      val rdd = sc.parallelize(Seq(1, 2, 3, 4, 5))
      val sumOfSquares = rdd.map(x => x * x).reduce((a, b) => a + b)
      println("Сума квадратів кожного значення: " + sumOfSquares)

      sc.stop()
    }
  }




