package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
	
      val conf = new SparkConf().setAppName("CartesianRDDExample").setMaster("local")
      val sc = new SparkContext(conf)
      val rdd1 = sc.parallelize(List(1, 2, 3))
      val rdd2 = sc.parallelize(List("A", "B", "C"))
      val cartesianResult = rdd1.cartesian(rdd2)


      println("набір:")
      cartesianResult.collect().foreach(println)

      sc.stop()
    }
  }




