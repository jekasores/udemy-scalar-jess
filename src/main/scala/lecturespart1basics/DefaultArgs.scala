package lecturespart1basics

object DefaultArgs extends App {

  //Factorial function example with tail recursion
  def trFact(n: Int, acc: Int): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  val fact10 = trFact(10, 1) //The accumulative variable will always be 1 to calculate the factorial

  //Second version of the previous function where we specify a value in case we do no pass the value of acc (default parameter)
  def trFactV2(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFactV2(n - 1, n * acc)

  val fact10V2 = trFactV2(10) //I can also do val fact10 = trFact(10,1) and I can change the default value by passing other value to the function

  //def savePicture (format: String = "jpg", width: Int, height: Int): Unit = println("Saving picture")
  //savePicture(800, 600) //the compiler thinks that 800 is the value of the first parameter format that should be a string. It gets confused

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int=1080): Unit = println("Saving picture") //Now we set a defaul paramenter for all parameters
  savePicture() //if we no pass any parameter it will run well
  //savePicture(800) //the compiler will be confused as well

  /*Solutions for the previous issues
  1. pass in every leading argument
  2. name the arguments
  */
  savePicture(width = 800) //This works!

  //If you name the parameters, you can pass them in a different order
  savePicture(height=600, width = 800, format = "bmp")

}
