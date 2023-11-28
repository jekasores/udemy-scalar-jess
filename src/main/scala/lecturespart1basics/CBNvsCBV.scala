package lecturespart1basics
//Call-by-name and call-by-value function
object CBNvsCBV extends App{

  def callByValue(x:Long):Unit = { //Chose long type because of time function System.nanoTime()
    println("by value: " + x)
    println("by value: " + x)
  }

  def callByName(x: => Long): Unit = { //The => represents a functions that is called by name
    println("by name: " + x)
    println("by name: " + x)
  }

  callByValue(System.nanoTime()) //Will print the two same values
  //This is like you are given a fixed value for a function
  callByName(System.nanoTime()) //The values printed will be different
  //The expression is passed literally, so system time is evaluated two time

  def infinite() : Int = 1+infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34) //It crashes - stack overflow memory problem
  printFirst(34, infinite()) //Because the second parameter is never used, it does not crash

}
