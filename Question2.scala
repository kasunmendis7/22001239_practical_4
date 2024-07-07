object Question2{
    def main(args: Array[String]):Unit={
        print("Enter an integer: ")
        var input = scala.io.StdIn.readLine().toInt
        patternMatching(input)
    }

    def patternMatching(num: Int):Unit={
        num match{
            case num if num<0 => println("You entered a negative number.")
            case 0 => println("You entered zero")
            case x if x%2==0 => println("Even Number")
            case _ => println("Odd Number")
        }
    }
}