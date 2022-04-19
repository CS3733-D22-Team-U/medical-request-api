package edu.wpi.cs3733.D22.teamU;

import edu.wpi.cs3733.D22.teamU.MedicineData.DefaultImplementation;
import edu.wpi.cs3733.D22.teamU.MedicineData.MedicineDao;

public abstract class Settings {
  public static int xCoord = 0, yCoord = 0, windowWidth = 0, windowLength = 0;
  public static String cssPath =
      String.valueOf(
          MedicineRequest.class
              .getClassLoader()
              .getResource("edu/wpi/cs3733/D22/teamU/cssFiles/default.css"));
  public static String destLocationID, originLocationID;

  public static MedicineDao medicineActions = new DefaultImplementation();
}
