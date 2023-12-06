package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("FilterAndCountWordsExample").setMaster("local")

      val sc = new SparkContext(conf)
      val textRdd = sc.textFile("D:/date.txt")
      val filteredRdd = textRdd.filter(line => line.contains("scala"))
      val count = filteredRdd.count()

      println(s"Кількість строк, які містять слово 'scala': $count")
      println("Перші 5 строк, які містять слово 'scala':")
      filteredRdd.take(5).foreach(println)

      sc.stop()
    }
  }




