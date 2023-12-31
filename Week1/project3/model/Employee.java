package project3.model;

public class Employee {
  private int id;
  private String name;

  public Employee() {
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

  public void setSalary(int salary) {
  }
  
  public void getDetails() {
    System.out.println("Employee ID: " + id);
    System.out.println("Employee Name: " + name);
  }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", name=" + name + "]";
  }
}
