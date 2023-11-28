package lecturespart2oop

object AbstractDataTypes extends App{
  //Abstract:When you need to leave some fields or methods blank or unimplemented
  abstract class Animal{
    val creatureType: String
    def eat: Unit
    //We did not define a value because we want the subclasses to do that for us
  }
  //val animal = new Animal //The compiler would complain because the vals have no defined value
  class Dog extends Animal{
    override val creatureType: String = "Canine"
    override def eat:Unit = println("crunch crunch") //It is possible to remove the override that the compiler will understand
  }

  //traits: they extend the functionality of a class using a set of methods
  //Traits cannot be instantiated and have no arguments and parameters
  trait Carnivore{
    def eat(animal: Animal):Unit
  }
  class Crocodile extends Animal with Carnivore{
    //class Crocodile inheritance members from both Animal and Carnivore
    override val creatureType: String = "croc"
    def eat: Unit = "nomnomnom"
    def eat(animal: Animal):Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }
  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //traits vs. abstract classes
  //abstract classes can have both abstract and non-abstract members. Traits as weel
  //What is the difference then?
  // 1. Traits do not have constructor parameters
  // 2. Multiple traits can be inherited by the same class. Ex.: class Crocodile extends Animal with Carnivore with ColBlooded
  // 3. Traits are behavior (what they do), abstract class are things

}
