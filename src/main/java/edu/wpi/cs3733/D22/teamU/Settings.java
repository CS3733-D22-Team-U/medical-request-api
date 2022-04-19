package edu.wpi.cs3733.D22.teamU;

import edu.wpi.cs3733.D22.teamU.Employee.DefaultEmployee;
import edu.wpi.cs3733.D22.teamU.MedicineData.DefaultImplementation;
import edu.wpi.cs3733.D22.teamU.MedicineData.MedicineDao;
import java.util.HashMap;

public class Settings <Employee, Location>{

  static Settings instance;
  public static Settings getInstance() {
    return instance;
  }

  Settings(){

  }

   int xCoord = 0, yCoord = 0, windowWidth = 0, windowLength = 0;
   String cssPath =
      String.valueOf(
          MedicineRequest.class
              .getClassLoader()
              .getResource("edu/wpi/cs3733/D22/teamU/cssFiles/default.css"));
   String destLocationID;

   Employee current = null;

   MedicineDao medicineActions = new DefaultImplementation();

   HashMap<String, Employee> authorizedEmployees = new HashMap<>();

  public  int getxCoord() {
    return xCoord;
  }

  public  int getyCoord() {
    return yCoord;
  }

  public  int getWindowWidth() {
    return windowWidth;
  }

  public  int getWindowLength() {
    return windowLength;
  }

  public  String getCssPath() {
    return cssPath;
  }

  public  String getDestLocationID() {
    return destLocationID;
  }

  public  MedicineDao getMedicineActions() {
    return medicineActions;
  }

  public  HashMap<String, Employee> getAuthorizedEmployees() {
    return authorizedEmployees;
  }

  public  Employee getCurrent() {
    return current;
  }

   HashMap<String, Location> locations;

  public  HashMap<String, Location> getLocations(){
    return locations;
  }
}
