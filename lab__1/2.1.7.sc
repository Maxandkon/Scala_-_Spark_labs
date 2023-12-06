package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("IntersectRDDExample").setMaster("local")
      val sc = new SparkContext(conf)
      val rdd1 = sc.parallelize(8 to 16)
      val rdd2 = sc.parallelize(5 to 13 by 2)
      val intersectedRdd = rdd1.intersection(rdd2)


      println("Elemets which in both | Елементи що є в обох:")
      intersectedRdd.collect().foreach(println)

      sc.stop()
    }
  }




