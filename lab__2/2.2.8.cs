package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("SparkRDDJoinExample").setMaster("local[*]")
      val sc = new SparkContext(conf)

      // Створимо два набори RDD
      val operatingSystems = sc.parallelize(List("Windows", "Linux", "macOS"), 3)
      val programmingLanguages = sc.parallelize(List("Java", "Python", "C++"), 3)

      // Відобразимо довжину та самі назви операційних систем
      val osLengths = operatingSystems.keyBy(_.length)

      // Відобразимо довжину та самі назви мов програмування
      val plLengths = programmingLanguages.keyBy(_.length)

      // Здійснимо об'єднання (join) наборів RDD
      val joinedRDD = osLengths.join(plLengths)

      // Виведемо результат
      val result = joinedRDD.collect()
      result.foreach { case (length, (os, pl)) =>
        println(s"($length, ($os, $pl))")
      }

      sc.stop()
    }
  }




