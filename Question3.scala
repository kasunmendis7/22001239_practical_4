object Question3 {
  def main(args: Array[String]): Unit = {
    val names = List("Benny", "Niroshan", "Saman", "Kumara")

    names.foreach { name =>
      println(formatNames(name))
    }
  }

  def formatNames(name: String): String = {
    name match {
      case "Benny"    => name.toUpperCase
      case "Niroshan" => name.take(2).toUpperCase + name.drop(2)
      case "Saman"    => name.toLowerCase
      case "Kumara"   => name.init + name.last.toUpper
      case _          => name
    }
  }
}