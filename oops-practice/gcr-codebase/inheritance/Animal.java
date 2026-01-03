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
  void makeSound(){
    System.out.println("Birds chirps");
  }

}