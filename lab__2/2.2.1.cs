package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("SparkRDDTasks").setMaster("local[*]")
      val sc = new SparkContext(conf)

      // Завдання 1
      val rdd1 = sc.parallelize(List(1, 2, 3, 4, 5))
      val summa = rdd1.aggregate(0)(_ + _, _ + _)
      println("Завдання 1: " + summa)

      // Завдання 2
      val rdd2 = sc.parallelize(List("This", "is", "an", "example"))
      val chars = rdd2.map(_.length).reduce(_ + _)
      println("Завдання 2: " + chars)

      // Завдання 3
      val rdd3 = sc.parallelize(List(List(1, 2, 3), List(4, 5, 6)))

      // 3а) сума в кожному List
      val summaList = rdd3.map(list => list.sum)
      println("Завдання 3а: " + summaList.collect().toList)

      // 3б) сума всіх елементів
      val summaAll = rdd3.flatMap(list => list).sum()
      println("Завдання 3б: " + summaAll)

      // 3в) максимальне в кожному List
      val maxList = rdd3.map(list => list.max)
      println("Завдання 3в: " + maxList.collect().toList)

      // 3г) максимальне з максимальних
      val maxAll = maxList.max()
      println("Завдання 3г: " + maxAll)

      // 3д) сума і кількість елементів для кожного List
      val all = rdd3.map(list => (list.sum, list.length))
      println("Завдання 3д: " + all.collect().toList)

      // 3е) середнє для кожного List
      val avg = rdd3.map(list => list.sum.toDouble / list.length)
      println("Завдання 3е: " + avg.collect().toList)

      sc.stop()
    }
  }




