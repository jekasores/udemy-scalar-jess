package lecturespart1basics

object ValuesVariablesTypes extends App {
    //To make this code runable we must add  extends App to object declaration

    // ************************************ VALUES TYPE ************************************

    val x: Int = 42
    println(x)
    //x=2 //It will give an error because vals are immutable
    //Types are val are optional because they can be inferred by compiler. E.g: val x = 42
    //If we define a type for val, the content should be consistent with the type.
    // Otherwise, the compiler will give an error. E.g:val x: Int = "Hello Scala"

    val aString: String = "Hello"; val anotherString = "Gooddby"
    //We can use ; in the end of a command line but it is not necessary
    //Unless we are separating commands. For coding style it is preferable one command per line

    val aBoolean: Boolean = false //can be true or false
    val aChar: Char = 'a' //Char type is only one character between single quotes

    val anInt: Int = x //A val can receive values from other vals
    val aShort: Short = 4163 //Short is a number with half of representation of an int (2 bytes instead of 4)
    //If the value is too big, the compiler will complain. E,g: aShort =416345
    val aLong: Long = 991541852169213 //Integer type with the double of representation (8 bytes intead of 4)
    //Should be used when number is too long for an Integer
    val aLong2 = 991541852169213L
    // We could use an L in the end of the number to make explicit it is a long
    val aFloat: Float = 2.0f
    // It must have the letter f in the end, otherwise the compiler will understand as a Double type
    val aFloat2 = 2.0
    //If we run the code and check the aFloat2 type it will be defined as a Double
    val aDouble: Double = 3.14
    // The difference between double and float is that float has size of 32 bits and double 64.
    //Therefore, double can handle bigger fractional numbers

  // ************************************ VARIABLE TYPE ************************************

  var aVariable: Int = 4
  aVariable = 5 //side effects
  //Variables can be redefined. They are used as side effects because they allow us to see what the programmer
  //is doing. Programs without side effect are easier to understand because there are no variables to keep track
  //of but we usually can not elliminate side effects completly.
  //Functional programming involves working less with variables and more with values

}
