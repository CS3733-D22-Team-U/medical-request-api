package edu.wpi.cs3733.D22.teamU.MedicineData;

import java.util.HashMap;

public class DefaultImplementation extends MedicineDao {

  public DefaultImplementation() {
    setMedicines(new HashMap<>());
  }

  @Override
  public void add(Medicine m) {
    if (getMedicines().containsKey(m.getID()))
      throw new RuntimeException("Medicine with same ID already exists.");
    else getMedicines().put(m.getID(), m);
  }

  @Override
  public void edit(Medicine m) {
    if (getMedicines().containsKey(m.getID())) {
      getMedicines().put(m.getID(), m);
    } else throw new RuntimeException("Medicine with same ID was not found to edit.");
  }

  @Override
  public void remove(Medicine m) {
    if (getMedicines().containsKey(m.getID())) {
      getMedicines().remove(m.getID());
    } else throw new RuntimeException("Medicine with same ID was not found to delete.");
  }
}
