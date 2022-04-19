package edu.wpi.cs3733.D22.teamU;

import edu.wpi.cs3733.D22.teamU.Employee.Employee;
import edu.wpi.cs3733.D22.teamU.MedicineData.DefaultImplementation;
import edu.wpi.cs3733.D22.teamU.MedicineData.MedicineDao;
import java.util.HashMap;

public abstract class Settings {
  static int xCoord = 0, yCoord = 0, windowWidth = 0, windowLength = 0;
  static String cssPath =
      String.valueOf(
          MedicineRequest.class
              .getClassLoader()
              .getResource("edu/wpi/cs3733/D22/teamU/cssFiles/default.css"));
  static String destLocationID;

  static Employee current = new Employee("");

  static MedicineDao medicineActions = new DefaultImplementation();

  static HashMap<String, Employee> authorizedEmployees = new HashMap<>();

  public static int getxCoord() {
    return xCoord;
  }

  public static int getyCoord() {
    return yCoord;
  }

  public static int getWindowWidth() {
    return windowWidth;
  }

  public static int getWindowLength() {
    return windowLength;
  }

  public static String getCssPath() {
    return cssPath;
  }

  public static String getDestLocationID() {
    return destLocationID;
  }

  public static MedicineDao getMedicineActions() {
    return medicineActions;
  }

  public static HashMap<String, Employee> getAuthorizedEmployees() {
    return authorizedEmployees;
  }
}
