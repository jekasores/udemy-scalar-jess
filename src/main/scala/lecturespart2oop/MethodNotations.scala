package lecturespart2oop
import scala.language.postfixOps

object MethodNotations extends App {
  val mary = PersonNew("Mary", "Inception", 40)
  println(mary.likes("Inception"))
  println(mary likes "Inception") //infix notation = operator notation: it has the same effect of the previous
  //command but more similar to natural language. It only works with methods that have a single parameter

  val tom = new PersonNew("Tom", "Fight Club", 35)
  println(mary hangOutWith tom ) //Syntatic sugar: it is a way to write code that looks like natural language

  //Operators in Scala: we could name a method(function inside a class) using operator that Scala would not give an error
  //println(mary + tom )
  println(mary + "the rockstar")   //Ans exercise 1
  println(+mary)    //Ans exercise 2

  //All math operator are methods in scala
  println(1+2)
  println(1.+(2))

  //Prefix notation
  val x = -1 //equivalent with 1.unary_-
  val y = 1.unary_-
  //the unary_ only works with a few operators? - + ~ !
  println(!mary)
  println(mary.unary_!)
  
  //postfix notation: only for methods without parameters
  println(mary.isAlive)
  //println(mary isAlive)  //In this version ins command needs some extra configuration to run

  //apply
  //println(mary.apply())
  //println(mary()) //It has the same effect than the previous command
  //The compiler delegates mary() to the apply() method
  println(mary.apply(2))         //Ans exercise 3
  println(mary(10))
  println(mary learnsScala)

}

/*    EXERCISES 
    1. Overload the + operator
      mary + "the rockstar" => new person "Mary (the rockstar)"

    2. Add an age to the Person class
      Add a unary + operator => new person with the age +1
      +mary => mary with the age incrementer

   3. Overload the apply method
      mary.apply(2) => "Mary watched Inception 2 times"
 */

class PersonNew(val name: String, favoriteMovie: String, age: Int=0) {
  def likes(movie: String): Boolean = movie == favoriteMovie
  def hangOutWith(person: PersonNew):String = s"${this.name} is hanging out with ${person.name}"
  //def +(person: PersonNew):String = s"${this.name} is with ${person.name}"
  def +(nickname: String):String = s"${this.name} ($nickname)"  //Ans exercise 1
  def unary_+ : Int = age+1  //Ans exercise 2
  def unary_! : String = s"What the heck?!"   //: need to be separated from the method name so the compiles will not think : is part of the name
  def isAlive: Boolean = true   //function that does not receive any parameter
  //def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"   //Apply needs a ()
  def apply(x: Int): String = s"$name watched $favoriteMovie $x times"   //Ans exercise 3
  def learns(thing: String) = s"$name is learning $thing"
  def learnsScala = this learns "Scala"
}


