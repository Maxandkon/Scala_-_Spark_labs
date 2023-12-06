package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


object Main {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CreateRDDWithParallelismExample").setMaster("local")

    val sc = new SparkContext(conf)
    val input_data = 1 to 8
    val even_rdd = sc.parallelize(input_data.filter(_ % 2 == 0), 4)
    val odd_rdd = sc.parallelize(input_data.filter(_ % 2 != 0), 4)
    val step_3_rdd = sc.parallelize(input_data.filter(_ % 3 == 0), 4)

    println("Even RDD:")
    even_rdd.collect().foreach(println)

    println("Odd RDD:")
    odd_rdd.collect().foreach(println)

    println("Step 3 RDD:")
    step_3_rdd.collect().foreach(println)

    sc.stop()
  }
}



