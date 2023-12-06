package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("UnionRDDExample").setMaster("local")

      val sc = new SparkContext(conf)
      val rdd1 = sc.parallelize(3 to 7, 1)
      val rdd2 = sc.parallelize(7 to 9, 1)
      val unionResult1 = rdd1.union(rdd2)
      val unionResult2 = rdd1 ++ rdd2

      println("Результат за допомогою методу union:")
      unionResult1.collect().foreach(println)

      println("Результат за допомогою оператора ++:")
      unionResult2.collect().foreach(println)

      sc.stop()
    }
  }




