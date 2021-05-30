package com.mycompany.beans;  
  
public class Emp { 

private int id;  
private String name;  
private float salary;  
private String designation;
private String gender;
private String shift;
private String[] food = new String[0]; 


public String[] getFood() {
	return food;
}
public void setFood(String[] food) {
	this.food = food;
}

public String getShift() {
	return shift;
}
public void setShift(String shift) {
	this.shift = shift;
}

public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
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
public float getSalary() {  
    return salary;  
}  
public void setSalary(float salary) {  
    this.salary = salary;  
}  
public String getDesignation() {  
    return designation;  
}  
public void setDesignation(String designation) {  
    this.designation = designation;  
}  
  
}  