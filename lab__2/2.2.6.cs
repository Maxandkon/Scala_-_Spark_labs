package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("SparkRDDToMap").setMaster("local[*]")
      val sc = new SparkContext(conf)

      // Створимо вихідний RDD
      val inputRDD = sc.parallelize(List((1, 'a'), (1, 'b'), (2, 'c'), (2, 'd')))

      // Перетворимо RDD у вигляді Map
      val resultMap = inputRDD.map { case (key, value) => (key, List(value)) }.reduceByKey(_ ++ _)

      // Виведемо результат
      val resultArray = inputRDD.collect()
      val resultMapArray = resultMap.collectAsMap()

      println("Вихідний RDD:")
      resultArray.foreach(println)
      println("Получений Map:")
      resultMapArray.foreach { case (key, values) =>
        println(s"$key -> $values")
      }

      sc.stop()
    }
  }




