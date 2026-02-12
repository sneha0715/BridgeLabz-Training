package com.sneha.model;

import java.time.LocalDate;

public class Patient {
  private int id;
  private String name;
  private String email;
  private LocalDate dob;
  private String phone;
  private String address;
  private String bloodGroup;

  //for new patient as he will be assigned new unique id after registeration
  public Patient(String name , String email , LocalDate dob , String phone , String address , String bloodGroup){
    this.name=name;
    this.email=email;
    this.dob=dob;
    this.phone=phone;
    this.address=address;
    this.bloodGroup=bloodGroup;
  }

  //for alreay existing user

  public Patient(int id , String name , String email , LocalDate dob , String phone , String address , String bloodGroup){
    this.id=id;
    this.name=name;
    this.email=email;
    this.dob=dob;
    this.phone=phone;
    this.address=address;
    this.bloodGroup=bloodGroup;
  }

  //getter setter
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  } 

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDob(){
    return dob;
  }

  public void setDob(LocalDate dob){
    this.dob=dob;
  }

  public String getPhone(){
    return phone;
  }

  public void setPhone(String phone){
    this.phone=phone;
  }

  public String getAddress(){
    return address;
  }

  public void setAddress(String address){
    this.address=address;
  }

  public String getBloodGroup(){
    return bloodGroup;
  }

  public void setBloodGroup(String bloodGroup){
    this.bloodGroup=bloodGroup;
  }
}
