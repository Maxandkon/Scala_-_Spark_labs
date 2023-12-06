package LR

class Car(private val manufacturer: String, private val model: String, private val year: Int, var registrationNumber: String) {

  def this(manufacturer: String, model: String) = this(manufacturer, model, -1, "")
  def this(manufacturer: String, model: String, year: Int) = this(manufacturer, model, year, "")
  def this(manufacturer: String, model: String, registrationNumber: String) = this(manufacturer, model, -1, registrationNumber)

  def getManufacturer: String = manufacturer
  def getModel: String = model
  def getYear: Int = year
}

object Main {
  def main(args: Array[String]): Unit = {
    val car1 = new Car("Toyota", "Camry")
    val car2 = new Car("Honda", "Civic", 2020)
    val car3 = new Car("Ford", "F-150", "ABC123")
    val car4 = new Car("Ford", "F-150", 1999, "ABC123")
	
    println(s"Car 1: ${car1.getManufacturer}, ${car1.getModel}, ${car1.getYear}, ${car1.registrationNumber}")
    println(s"Car 2: ${car2.getManufacturer}, ${car2.getModel}, ${car2.getYear}, ${car2.registrationNumber}")
    println(s"Car 3: ${car3.getManufacturer}, ${car3.getModel}, ${car3.getYear}, ${car3.registrationNumber}")
    println(s"Car 4: ${car4.getManufacturer}, ${car4.getModel}, ${car4.getYear}, ${car4.registrationNumber}")
  }
}
