package lecturespart2oop

object Inheritance extends App {
  //Single class inheritance: can only extends one class at a time
  //final class Animal{
  sealed class Animal{
    val creatureType = "wild"
    //private def eat = println("nomnom")
    //protected def eat = println("nomnom")
    def eat = println("nomnom") //if there is no modifier, it means it is public
    //final def eat = println("nomnom") //prohibit future overriding

  }

  class Cat extends Animal { //Extends means inherinting all non-private fields and methods
    //Cat is a subclass of animal
    //Animal is a superclass of cat
    def crunch = {
      eat  //can use it inside the subclass when eat was defined as protected
      println("crunch crunch")
    }
  }

  val cat = new Cat
  //cat.eat //if eats is private or protected this will not work
  cat.crunch

  //class Person(name:String, age: Int)
  //class Adult(name: String, age: Int, idCard: String)  extends Person(name, age)
  //or
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0) //auxiliary function that sets a value for age
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //overring
  /*class Dog(override val creatureType: String = "domestic") extends Animal{
    //override val creatureType: String = "domestic"
    override def eat = println("crunch, crunch")
  }*/
  /*class Dog(override val creatureType: String) extends Animal{
    override val creatureType: String = dogType
  }*/
  class Dog(dogType: String) extends Animal {
    //override def eat = println("crunch, crunch")
    override def eat = {
      super.eat //will refer to the method eat from the super class
      println("crunch, crunch")
    }
  }
  val dog = new Dog("K9")
  //dog.eat
  println(dog.creatureType)

  val unknowAnimal: Animal = new Dog("K9") //polymorphism
  unknowAnimal.eat

  //overRIDING: supplying a different implementation in derived classes  vs.
  //overLOADING: supplying multiple methods with different signatures but with the same name and with the same class

  //super: when we want to reference a field or a method from the parent class

  //preventing overrrides: when you want to limit the override of fields and methods. There are some ways to do that:
  // 1. Use keyword final on member
  // 2. Use final in the class itself
  // 3. Seal the class = extend classes in THIS file, prevent extension in other files
}
