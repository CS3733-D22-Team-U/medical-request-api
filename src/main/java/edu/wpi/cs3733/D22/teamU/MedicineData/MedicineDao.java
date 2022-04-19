package edu.wpi.cs3733.D22.teamU.MedicineData;

import java.util.HashMap;

public abstract class MedicineDao {
  private HashMap<String, Medicine> medicines;

  public abstract void add(Medicine m);

  public abstract void edit(Medicine m);

  public abstract void remove(Medicine m);

  public HashMap<String, Medicine> getMedicines() {
    return medicines;
  }

  public void setMedicines(HashMap<String, Medicine> medicines) {
    this.medicines = medicines;
  }
}
