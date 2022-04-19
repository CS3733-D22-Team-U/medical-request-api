package edu.wpi.cs3733.D22.teamU.MedicineData;

import java.util.HashMap;

/**
 * MedicineDao contains a HashMap of medicine, with the Value being the Medicine Object and it's key
 * being the String ID value of the Medicine
 */
public abstract class MedicineDao <Employee, Location>{
  private HashMap<String, Medicine<Employee,Location>> medicines = new HashMap<>();

  /**
   * Have MedicineDao do a certain function after updating the HashMap
   *
   * @param m The Medicine Object that was added
   */
  public abstract void add(Medicine<Employee, Location> m);

  /**
   * Have MedicineDao do a certain function after updating the HashMap
   *
   * @param m The Medicine Object that was edited
   */
  public abstract void edit(Medicine<Employee, Location> m);

  /**
   * Have MedicineDao do a certain function after updating the HashMap
   *
   * @param m The Medicine Object that was removed
   */
  public abstract void remove(Medicine<Employee, Location> m);

  /** @return Gets the Medicine HashMap */
  public HashMap<String, Medicine<Employee, Location>> getMedicines() {
    return medicines;
  }

  /**
   * Sets the Medicine HashMap. Useful for an initial load, such as filling out the list from stored
   * values in an SQL Database.
   *
   * @param medicines HashMap<String,Medicine> of the medicines, with String being the Medicine's ID
   */
  public void setMedicines(HashMap<String, Medicine<Employee, Location>> medicines) {
    this.medicines = medicines;
  }
}
