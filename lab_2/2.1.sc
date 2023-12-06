package LR

class Time private (private val hours: Int, private val minutes: Int) {
  def before(other: Time): Boolean = {
    if (hours < other.hours) {
      true
    } else if (hours == other.hours && minutes < other.minutes) {
      true
    } else {
      false
    }
  }
}


object Time {
  def apply(hours: Int, minutes: Int): Time = {
    require(hours >= 0 && hours < 24, "Години мають бути в діапазоні від 0 до 23")
    require(minutes >= 0 && minutes < 60, "Хвилини мають бути в діапазоні від 0 до 59")
    new Time(hours, minutes)
  }
}


object Main {
  def main(args: Array[String]): Unit = {
    val time1 = Time(12, 30)
    val time2 = Time(14, 00)

    println(time2.before(time1)) 
  }
}



