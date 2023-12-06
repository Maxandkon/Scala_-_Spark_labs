package LR

case class Logger(private val msgNum: Int = 10) {
  def info(n: Int = 1): Logger = {
    if (n <= 0) this
    else {
      println("New Message")
      Logger(msgNum + 1).info(n - 1)
    }
  }

  def print: Unit = {
    println(msgNum)
  }
}

object Logger {
  def apply(): Logger = new Logger()
}

object Main extends App {
  val logger = Logger()
  logger.print
  logger.info().print
  logger.info(3).print 
}






