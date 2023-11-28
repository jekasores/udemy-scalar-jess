package lecturespart2oop

object Objects{
  //Class level functionality: Does not depend in the instance of a class
  //SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY (It does not know the concept of "statiy")
 //However it has the object option
 object Person{ //define its type and its only instance
    //an object has values, vars, or method definitions (functions)
    //The difference between objects and classes is that objects do not receive parameters
    //static/class level functionality
    val N_EYES = 2
    def canFly:Boolean = false

    //Factory method : because it builds persons given some parameters
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String){
    //instance-level functionality
  }
  //COMPANIONS: Writing object and class with the same name in the same scope

  def main (args: Array[String]): Unit = { //It makes what is inside this function runable. Specially considering we removed "extends App" from the beggining
    println(Person.N_EYES)
    println(Person.canFly)

    //Scala object = SINGLETON INSTANCE - The object is its own type and only instance
    val mary = new Person("Mary") //refers to the class
    val john = new Person("John")
    println(mary == john)

    val person1 = Person
    val person2 = Person //refers to the object
    println(person1 == person2)

    val bobbie = Person(mary, john)

    //Scala applications = Scala object with
    //def main (args: Array[String]): Unit
  }

}
