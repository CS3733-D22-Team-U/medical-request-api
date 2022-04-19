package edu.wpi.cs3733.D22.teamU.MedicineData;

import edu.wpi.cs3733.D22.teamU.Employee.DefaultEmployee;
import edu.wpi.cs3733.D22.teamU.Location.DefaultLocation;

import java.util.HashMap;

/** Default MedicineDao with no functionality */
public class DefaultImplementation extends MedicineDao<DefaultEmployee, DefaultLocation> {

  /** Default MedicineDao with no functionality */
  public DefaultImplementation() {
    setMedicines(new HashMap<>());
  }

  /**
   * No functionality
   *
   * @param m The Medicine Object that was added
   */
  @Override
  public void add(Medicine m) {}

  /**
   * No functionality
   *
   * @param m The Medicine Object that was added
   */
  @Override
  public void edit(Medicine m) {}

  /**
   * No functionality
   *
   * @param m The Medicine Object that was added
   */
  @Override
  public void remove(Medicine m) {}
}
