package LR

class Point(val x: Int, val y: Int) {
  def +(other: Point): Point = Point(x + other.x, y + other.y)
}

object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
  def apply(point: Point): Int = point.x + point.y
}


object Main {
  def main(args: Array[String]): Unit = {
    val point1 = Point(3, 4) 
    val point2 = Point(1, 2)
	
    val sum = Point(point1 + point2) 
	
    println(s"Sum of cor: $sum") 
  }
}
