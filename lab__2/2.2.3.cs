package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("SparkColorOperations").setMaster("local[*]")
      val sc = new SparkContext(conf)

      // Створимо RDD з кольорами
      val colors = sc.parallelize(List("black", "blue", "white", "orange"), 2)

      // Виведемо кольори
      colors.collect().foreach(println)

      // Відобразимо довжину та сам кольори
      val colorLengths = colors.map(color => (color.length, color))
      colorLengths.collect().foreach(println)

      // Згрупуємо за довжиною та з'єднаємо кольори
      val groupedColors = colorLengths.reduceByKey(_ + _).sortByKey()
      groupedColors.collect().foreach { case (length, colors) =>
        println(s"($length,$colors)")
      }

      sc.stop()
    }
  }




