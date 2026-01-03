class AnimalHierarchy{
  public static void main(String[] args) {
    Animal myDog = new Dog();
    Animal myCat = new Cat();
    Animal myBird = new Bird();

    myDog.makeSound();
    myCat.makeSound();
    myBird.makeSound();
  }
}