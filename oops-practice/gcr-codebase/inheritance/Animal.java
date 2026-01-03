public class Animal {
  private String name;
  private int age;

  void makeSound(){
    System.out.println("Animal makes a sound");
  }
}
class Dog extends Animal{
  void makeSound(){
    System.out.println("Dog barks");
  }
}

class Cat extends Animal{
  void makeSound(){
    System.out.println("Cat meows");
  }
}

class Bird extends Animal{
  void makesound(){
    System.out.println("Birds chirps");
  }
}

public class Main{
  public static void main(String[] args) {
    Animal myDog = new Dog();
    Animal myCat = new Cat();
    Animal myBird = new Bird();

    myDog.makeSound();
    myCat.makeSound();
    myBird.makeSound();
  }
}