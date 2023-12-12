package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("SparkEuropeanCountries").setMaster("local[*]")
      val sc = new SparkContext(conf)

      // Створимо RDD з назвами країн Європи
      val europeanCountries = sc.parallelize(List(
        "Germany", "France", "Spain", "Italy", "United Kingdom",
        "Netherlands", "Belgium", "Switzerland", "Austria", "Poland",
        "Sweden", "Norway", "Denmark", "Greece", "Portugal"
      ), 2)

      // Відобразимо довжину та самі назви країн
      val countryLengths = europeanCountries.map(country => (country.length, country))

      // Витягнемо ключі (довжини)
      val keys = countryLengths.keys.collect()

      // Виведемо результат
      keys.foreach(println)

      sc.stop()
    }
  }




