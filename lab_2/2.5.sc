package LR

object Conversions {
  def inchesToCentimeters(inches: Double): Double = {
    val centimeters = inches * 2.54
    centimeters
  }

  def gallonsToLiters(gallons: Double): Double = {
    val liters = gallons * 3.78541
    liters
  }

  def milesToKilometers(miles: Double): Double = {
    val kilometers = miles * 1.60934
    kilometers
  }
}


object Main {
  def main(args: Array[String]): Unit = {
    val inches = 3.5
    val gallons = 3.5
    val miles = 3.5
	
    val centimeters = Conversions.inchesToCentimeters(inches)
    val liters = Conversions.gallonsToLiters(gallons)
    val kilometers = Conversions.milesToKilometers(miles)

    println(s"$inches дюймів = $centimeters см")
    println(s"$gallons галонів = $liters л")
    println(s"$miles миль = $kilometers км")
  }
}
