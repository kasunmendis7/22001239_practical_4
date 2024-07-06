import scala.annotation.switch

object Question1 {
  def main(args: Array[String]): Unit = {
    var itemNames = Array("40pgBooks", "80pgBooks", "120pgBooks", "CRBooks")
    var numberOf = Map(
      "40pgBooks" -> 14,
      "80pgBooks" -> 35,
      "120pgBooks" -> 20,
      "CRBooks" -> 30
    )
    while (true) {
      println("------------------------------------------")
      println("Inventory Management System")
      println("1. Display Inventory")
      println("2. Restock Item")
      println("3. Sell Item")
      println("Press 4 to exit")
      print("Enter your choice: ")
      var choice = scala.io.StdIn.readLine().toInt
      choice match {
        case 1 =>
          displayInventory(itemNames, numberOf)
        case 2 =>
          print("Enter the name of the item: ")
          var name = scala.io.StdIn.readLine()
          numberOf = restockItem(name, numberOf)
        case 3 =>
          print("Enter the name of the item: ")
          var name = scala.io.StdIn.readLine()
          numberOf = sellItem(name, numberOf)
        case 4 =>
          println("Exiting the system.")
          System.exit(0)
        case _ =>
          println("Invalid choice. Please select a valid option.")
      }
      println("------------------------------------------")
    }
  }

  def displayInventory(
      items: Array[String],
      quantities: Map[String, Int]
  ): Unit = {
    for (i <- items.indices) {
      println(s"${items(i)} =\t${quantities(items(i))}")
    }
  }

  def restockItem(
      name: String,
      quantities: Map[String, Int]
  ): Map[String, Int] = {
    print("Enter the amount that is restocked: ")
    var amount = scala.io.StdIn.readLine().toInt
    quantities.get(name) match {
      case Some(existingQuantity) =>
        val updatedQuantity = existingQuantity + amount
        println(s"Restocked $name. New quantity = $updatedQuantity")
        quantities.updated(name, updatedQuantity)
      case None =>
        println(s"Item $name does not exist in the inventory")
        quantities
    }
  }

  def sellItem(name: String, quantities: Map[String, Int]): Map[String, Int] = {
    print("Enter the amount that is sold: ")
    var amount = scala.io.StdIn.readLine().toInt
    quantities.get(name) match {
      case Some(existingQuantity) =>
        val updatedQuantity = existingQuantity - amount
        println(s"After selling $name. Remaining quantity = $updatedQuantity")
        quantities.updated(name, updatedQuantity)
      case None =>
        println(s"Item $name does not exist in the inventory")
        quantities
    }
  }
}
