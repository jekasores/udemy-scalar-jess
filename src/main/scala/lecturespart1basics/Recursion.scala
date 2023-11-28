package lecturespart1basics

import lecturespart1basics.Functions.aRepeatedFunction

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App{
  // @tailrec - This will give me an error because it is not a tail recursive function
  def factorial (n:Int):Int =
    if (n<=1) 1
    else{
      println("Computing factorial of " + n + " - I firt need factorial of "+ (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of "+n)
      result
    }
  println(factorial(10))
  //println(factorial(50000))
  //Each call of the recursive function uses a stack frame to save the calculated values
  //JVM keeps all the calls of the recursive function in its internal memory, what might be a problem
  //Stack overflow error happens when the calls of the recursion are very big. E.g: println(factorial(50000))

  //To solve the stackoverflow error, we need to define the recursion fucntion in a smarter way
  def anotherFactorial(n:Int):BigInt = {
    @tailrec // It will run normally because it is a tail recursive function
    def feactHelper(x: Int, accumulator: BigInt):BigInt=
      if (x<=1) accumulator
      else feactHelper(x-1, x*accumulator) //TAIL RECURSION = use a recursive call as the LAST expression

    feactHelper(n, 1)
  }
  /* Example of anotherFactorial execution
  anotherFactorial(10) = factHelper(10,1)
  = factHelper(9, 10 * 1)
  = factHelper(8, 9 * 10 *1)
  = factHelper(7, 8 * 9 * 10 *1)
  = ...
  = factHelper(2, 3 * 4 * ... * 10 *1)
  = factHelper(1, 1 * 2 *3 * 4 * ... * 10 *1)
   */
  println(anotherFactorial(50000))
  // Because the factorial number is very big, we need to substitute the type Int by BigInt
  // The tail recursion function solves the problem of data being stacked in the memory. So it is more optimized

  //WHEN YOU NEED LOOPS, USE _TAIL_RECURSION
  /* Exercises
  1 . Concatenate a string n times
  2. IsPrime function tail recursive
  3. Fibonacci function tail recursive
   */

  //Ans 1:
  /* Normal implementation of the recursive function
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }*/
  //Tail recursive representation
  @tailrec
  def aRepeatedFunctionTailrec(aString: String, n:Int, accumulator: String):String =
    if (n<=0) accumulator
    else aRepeatedFunctionTailrec(aString, n-1, aString+accumulator)
  println(aRepeatedFunctionTailrec("hello", 3, ""))


  //Ans 2:
  /* Normal implementation of the recursive function
  def isPrimeFunc(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }*/
  //Tail recursive representation
 //@tailrec
  def isPrime(n: Int):Boolean = {
    def isPrimeTailrec(t:Int, isStillPrime:Boolean):Boolean=
      if (!isStillPrime) false
      else if (t<=1) true
      else isPrimeTailrec(t-1, n%t != 0 && isStillPrime) //n%t return the rest of the division n by t

    isPrimeTailrec(n/2, true) //n/2 only gets the integer part of the division
  }
  println(isPrime(2003))
  println(isPrime(629))

  //Ans 3:
  /*Normal implementation of the recursive function
  def fibonacciFunc(n: Int): Int = {
    if (n <= 2) 1
    else fibonacciFunc(n - 1) + fibonacciFunc(n - 2)
  }*/
  //Tail recursive representation
  //@tailrec
  def fibonaci(n:Int):Int = {
    def fiboTailrec(i:Int, last: Int, nextToLast:Int):Int =  //however many recursive call == how many accumulators in tail recursive function. E.g: last = n-1 and nextTolast = n-2
      if (i>=n) last
      else fiboTailrec(i+1, last+nextToLast, last)
    if (n<=2) 1
    else fiboTailrec(2, 1, 1)
  }
  println(fibonaci(8))


}
