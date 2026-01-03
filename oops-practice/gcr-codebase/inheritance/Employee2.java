public class Employee2 {
  String name;
  int id;
  double salary;

  Employee2(String name,int id,double salary){
    this.name=name;
    this.id=id;
    this.salary=salary;
  }

  void displayDetails(){
    System.out.println("Name: "+name);
    System.out.println("Id: "+id);
    System.out.println("Salary: "+salary);
  }
}
class Manager extends Employee2{
  int teamSize;
  
  Manager(String name, int id,double salary, int teamSize){
     super(name,id,salary);
     this.teamSize=teamSize;
  }

  @Override
  void displayDetails(){
    super.displayDetails();
    System.out.println("Team size: "+teamSize);
  }
}
 class Developer extends Employee2{
  String programmingLanguage;

  Developer(String name,int id, double salary,String programmingLanguage){
    super(name,id,salary);
    this.programmingLanguage=programmingLanguage;
  }

  @Override
  void displayDetails(){
    super.displayDetails();
    System.out.println("Programming language: "+programmingLanguage);
  }
 }

class Intern extends Employee2{
  int duration;

  Intern(String name,int id,double salary,int duration){
    super(name,id,salary);
    this.duration=duration;
  }

  @Override
  void displayDetails(){
    super.displayDetails();
    System.out.println("Duration: "+duration);
  }
}
