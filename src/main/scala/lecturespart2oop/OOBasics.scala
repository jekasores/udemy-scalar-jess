package lecturespart2oop

object OOBasics extends App {
  val person = new Person("John", 26) // To instantiate a class use the operator new
  //Everytime we instantiate a class, the body of the class will be executed
  //Instantiation reserves space in memory for the created class
  println(person)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet() //It will not be a problem because the parameters are different (different number of parameters, type of parameters, etc)
  println("__________________")

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(author.fullname())
  println(novel.authorAge)
  println(novel.isWrittenBy((author)))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

//A class organizes data and behavior
//To pass parameters to a class is similar to a function
//Class parameters are not fields! You can not just access doing person.age. Unless the age was created with a val or var before
// {} define the class body
class Person(name: String, val age:Int) { //This is a constrductor: it means that every person should be specified using a name and an age
  //body
  val x= 2
  println(1+3)

  //Because the function is created inside a class definition, it will be called a method
  def greet(name: String): Unit = println(s"${this.name} says:Hi, $name") //When we add "this" it will refer to name in the constructor definition

  //overloading: defining methods with the same name but with different signatures
  def greet():Unit = println(s"Hi, I am ${this.name}")

  //Multiple constructors or overloading constructors
  def this(name: String) = this(name, 0 )
  def this() = this("John Doe")

  /* Exercises
  Implement a Novel and a Writer class

  Writer: first name, surename, year
    -method fullname

  Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy (new year of release) new instance of a novel

  Counter class
    -receives an int value
    -method current count
    -method increment/decrement -> new Counter
    -overload inc/dec to receive an amount
   */

}

class Writer(firstName: String, surename:String, val year:Int){
  def fullname():String = firstName + " " + surename
}

class Novel(name:String, val year: Int, author: Writer){
  def authorAge = year - author.year
  def isWrittenBy(author:Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val count: Int= 0 ){
  //Immutability: because it is returning a new counter instead of modifying the current count
  //Immutability is similar to context of a val that can not have its value changed
  def inc = {
    println("incrementing")
    new Counter(count+1)
  }
  def dec = {
    println("decrementing")
    new Counter(count-1)
  }

  def inc(n:Int): Counter = {
    if (n<=0) this
    else inc.inc(n-1)
  }

  def dec(n:Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print =  println(count)
}
