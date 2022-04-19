package edu.wpi.cs3733.D22.teamU.Employee;

import java.util.Objects;

public class Employee {
  private String ID;

  public Employee(String ID) {
    this.ID = ID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Objects.equals(ID, employee.ID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID);
  }

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }
}
