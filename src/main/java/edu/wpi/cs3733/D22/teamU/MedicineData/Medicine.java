package edu.wpi.cs3733.D22.teamU.MedicineData;

public class Medicine {
  private String ID;
  private String medicineName;
  private String destinationID;
  private String patientID;
  private String employeeID;

  private String dateNeeded;

  private String amount;

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public Medicine(
      String id,
      String medicineName,
      String destinationID,
      String patientID,
      String employeeID,
      String dateNeeded,
      String amount) {
    setID(id);
    setMedicineName(medicineName);
    setDestinationID(destinationID);
    setPatientID(patientID);
    setEmployeeID(employeeID);
    setDateNeeded(dateNeeded);
    setAmount(amount);
  }

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

  public String getDestinationID() {
    return destinationID;
  }

  public void setDestinationID(String destinationID) {
    this.destinationID = destinationID;
  }

  public String getPatientID() {
    return patientID;
  }

  public void setPatientID(String patientID) {
    this.patientID = patientID;
  }

  public String getEmployeeID() {
    return employeeID;
  }

  public void setEmployeeID(String employeeID) {
    this.employeeID = employeeID;
  }

  public String getDateNeeded() {
    return dateNeeded;
  }

  public void setDateNeeded(String dateNeeded) {
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
        + destinationID
        + '\''
        + ", patientID='"
        + patientID
        + '\''
        + ", employeeID='"
        + employeeID
        + '\''
        + ", dateNeeded='"
        + dateNeeded
        + '\''
        + '}';
  }
}
