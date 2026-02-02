class Animal{
  void makeSound(){
    System.out.println("Animal makes a sound");
  }
}
class Dog extends Animal{
  @Override
  void makeSound(){
    System.out.println("Dog Barks");
  }
}
public class AnimalSound {
  public static void main(String[] args) {
    Animal animal =new Dog();
    animal.makeSound();
  }
}
