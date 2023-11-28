package lecturespart1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala" //Index of the string starts from 0

  println(str.charAt(2)) //It returns the character of that index
  println(str.substring(7,11)) //It returns a substring interval according to the specified index
  println(str.split(" ").toList) //Splits the string according to a given character. The to List displays the results in a prettier fashion
  println(str.startsWith(("Hello"))) //It returns true or false if the condition starts with is satisfied
  println(str.replace(" ", "-")) //Replace a string with another string in the given val or variable
  println(str.toLowerCase()) //Convert all characters in to lower case
  println(str.toUpperCase()) //Convert all characters in to upper case
  println(str.length) //Gives the number of character in a string

  val aNumberString = "45"
  val aNumber = aNumberString.toInt //Converts a string number into integer
  println('a' +: aNumberString :+ 'z') //the operator +: concatenates two collections
  println('a' + aNumberString + 'z')
  println(str.reverse) //This command reverts the string order
  println(str.take(2)) //Returns the 2 first characters of the string

  //Scala-specific: String interpolators

  //S-interpoçators
  val name = "David"
  val age = 12
  val greeting =  s"Hello, my name is $name and I am $age years old" //to use vals inside a string we add an s before the string. To mention vals add the sign $
  println(greeting)
  val anotherGreeting =  s"Hello, my name is $name and I am ${age+1} years old" //adding {} enables us to do operations with the vals inside a string
  println(anotherGreeting)

  //F-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f" //%2.2f two characters total and 2 decimal points precision; %s is for string type of val
  //f intermotator = formatted strings can check for type correctness
  println(myth)

  //Raw-interpolator
  println(raw"This is a \n newline") //Prints the string literaly - It will not consider \n as a command to create a new line in this case
  val escaped = "This is a \n newline"
  println(raw"$escaped") //In this case \n will work
}
