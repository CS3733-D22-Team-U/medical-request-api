package edu.wpi.cs3733.D22.teamU.MedicineData;

import java.time.LocalDate;

/** Medicine Object */
public class Medicine <Employee,Location>{
  private String ID;
  private String medicineName;
  private Location destination;
  private String patientID;
  private Employee employee;
  private LocalDate dateNeeded;
  private String amount;

  /**
   * Return amount of medication needed Note: Amount is a String since different units of medication
   * might be needed (ex. 1 pill is not the same as 1mg)
   *
   * @return String of amount
   */
  public String getAmount() {
    return amount;
  }

  /**
   * Set amount of medication needed Note: Amount is a String since different units of medication
   * might be needed (ex. 1 pill is not the same as 1mg)
   *
   * @param amount Amount of medicine
   */
  public void setAmount(String amount) {
    this.amount = amount;
  }

  public Medicine(
      String ID,
      String medicineName,
      Location destinationID,
      String patientID,
      Employee employeeID,
      LocalDate dateNeeded,
      String amount) {
    setMedicineName(medicineName);
    setDestination(destinationID);
    setPatientID(patientID);
    setEmployee(employeeID);
    setDateNeeded(dateNeeded);
    setAmount(amount);
    setID(ID);
  }

  public void setDestination(Location destination) {
    this.destination = destination;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Medicine(
      String medicineName,
      Location destination,
      String patientID,
      Employee employee,
      LocalDate dateNeeded,
      String amount) {
    setMedicineName(medicineName);
    setDestination(destination);
    setPatientID(patientID);
    setEmployee(employee);
    setDateNeeded(dateNeeded);
    setAmount(amount);
    setID(makeID());
  }

  /**
   * Gets ID of object
   *
   * @return ID of Object
   */
  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public String getMedicineName() {
    return medicineName;
  }

  public void setMedicineName(String medicineName) {
    this.medicineName = medicineName;
  }

  public Object getDestination() {
    return destination;
  }

  public String getPatientID() {
    return patientID;
  }

  public void setPatientID(String patientID) {
    this.patientID = patientID;
  }


  public LocalDate getDateNeeded() {
    return dateNeeded;
  }

  public void setDateNeeded(LocalDate dateNeeded) {
    this.dateNeeded = dateNeeded;
  }

  @Override
  public String toString() {
    return "Medicine{"
        + "ID='"
        + ID
        + '\''
        + ", medicineName='"
        + medicineName
        + '\''
        + ", destinationID='"
        + destination.toString()
        + '\''
        + ", patientID='"
        + patientID
        + '\''
        + ", employeeID='"
        + employee.toString()
        + '\''
        + ", dateNeeded="
        + dateNeeded
        + ", amount='"
        + amount
        + '\''
        + '}';
  }

  private String makeID() {
    return medicineName
        + "_"
        + destination.toString()
        + "_"
        + patientID
        + "_"
        + employee.toString()
        + "_"
        + dateNeeded.toString();
  }
}
