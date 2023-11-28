package lecturespart1basics

object Expressions extends App {
  val x = 1+2 //expression
  //Expression have a type. The most basic expressions are math expression
  //The compiler usually can figure out the type
  println(x)

  println(2+3*4)
  //Math expression preserve the order toughtt in school
  // Math operations: + - * /
  // Bitwise operation: & | ^ (exclusive or) << (left shift) >> (right shift) >>> (right shift with zero extension)

  println(1 == x)
  //Expression of equality, return true or false
  // == != > >= < <=

  println(!(1 == x))
  //Logical negation
  // Unity operation, apply to boolean and returns a boolean
  // ! && ||

  var aVariable = 2
  aVariable += 3 //also works with -=, *=, /= ... these are all side effects
  println(aVariable)
  //changing a variable is called side effects

  //Instructions (DO) vs. Expressions
  // Expressions: it has a value, type, will compute a value
  // Instructions: will tell the computer what to do : show this, send this

  //IF expression
  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3 //because it gives a value, it is called IF EXPRESSION
  println(aConditionValue)

  //Avoid while loop
  //Avoid loops in general because they only execute side effects
  var i =0
  while (i<10){
    println(i)
    i+= 1
  }

  //Scala forces everything to be an expression!

  val aWeirdValue = (aVariable = 3) //Type Unit == Void
  println(aWeirdValue)
  //Unit type means that it does not return anything meaningful.
  //Side effects in scala are actually expressions returning Unit type
  //Side effects examples: println(), whiles, reassigning

  //Code block example
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z>2) "Hello" else "goodbye"
  }
  //Code block is an expression
  //The value of the block is the value of its final expression (in this example, the result of the if expression)
  //The type will be the value of its last expression
  //What was created inside the code block is not visible outside the code block

  //1. What is the difference between "hello world" vs println ("hello world")?
  // Ans1 : The first type is a string, the second type is a unit that has the power to print in the console
  //2.What is the value of:

  val someValue = {
    2<3
  }
  //Ans2 : It is a boolean
  println(someValue)

  //also, what is the value of:
  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  //Ans2 : the type is int and it return 42 (last expression)
  println(someOtherValue)

}
