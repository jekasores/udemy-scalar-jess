package lecturespart1basics

object Functions extends App {

  //Every parameter has a type. In the end we also have to specify the type that will be returned
  //by the function
  //After the equal sign there is the definition of the function
  //If we do not specify the type of return in a function, the compile will infer by looking at the implementation
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  //How to call a function without parameter
  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())


  //Instead of using a loop, this function prints the concatenation of a string N types by using recursion
  //In normal languages you would use a loop. in functional languages and skala you use recursion
  //We can not delete the return type of a recursive function
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))
  //When you need loops, use recursion!

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  //We need a function with side effects if we want something that has nothing to do with computation
  //Example, printing something into the console, write something in a file

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  println(aBigFunction(5))

  /* EXERCISES
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
    2. Factorial function 1*2*3*...*n
    3. A Fibonacci function
        f(1) = 1
        f(2) = 1
        f(n) = f(n-1) + f(n-2)
    4. Tests if a number is prime
   */

  //Ans 1:
  def greetingFunc(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old"
  }

  println(greetingFunc("Jess", 30))

  //Ans 2:
  def factorialFunc(n: Int): Int = {
    if (n <= 0) 1
    else n * factorialFunc(n - 1)
  }

  println(factorialFunc(5))

  //Ans 3:
  def fibonacciFunc(n: Int): Int = {
    if (n <= 2) 1
    else fibonacciFunc(n - 1) + fibonacciFunc(n - 2)
  }

  println(fibonacciFunc(8))

  //Ans 4:
  def isPrimeFunc(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }

  println(isPrimeFunc(37))
  println(isPrimeFunc(4))
}