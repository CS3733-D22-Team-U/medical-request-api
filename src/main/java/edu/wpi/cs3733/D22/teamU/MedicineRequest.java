package edu.wpi.cs3733.D22.teamU;

import edu.wpi.cs3733.D22.teamU.Employee.DefaultEmployee;
import edu.wpi.cs3733.D22.teamU.Exception.ServiceException;
import edu.wpi.cs3733.D22.teamU.JavaFX.App;
import edu.wpi.cs3733.D22.teamU.Location.DefaultLocation;
import edu.wpi.cs3733.D22.teamU.MedicineData.MedicineDao;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

/** Edit and open the Medicine Request window menu. */
public class MedicineRequest {

  /**
   * Runs the App with default settings as well as the default .css file
   *
   * @param args
   */
  public static void main(String[] args) throws ServiceException {
    setCurrentEmployee("Test");
    addAuthorizedEmployee("Test");
    Settings.destLocationID = "Location1";
    Settings.getLocations().put("Location1", new DefaultLocation("Location1"));
    App.launch(App.class, args);
  }

  /**
   * Runs the App with custom settings
   *
   * <p>Note: Window can be resized and will scale items. For best visual results, keep a 16:9
   * aspect ratio.
   *
   * @param xCoord xCoord to open the window at
   * @param yCoord yCoord to open the window at
   * @param windowWidth Width of the window
   * @param windowLength Length of the Window
   * @param cssPath Custom .css File Path
   * @param destLocationID Location ID for service request
   */
  public static void run(
      int xCoord,
      int yCoord,
      int windowWidth,
      int windowLength,
      String cssPath,
      String destLocationID)
      throws ServiceException {
    Settings.xCoord = xCoord;
    Settings.yCoord = yCoord;
    Settings.windowWidth = windowWidth;
    Settings.windowLength = windowLength;
    Settings.cssPath = styleSheetFormat(cssPath);
    Settings.destLocationID = destLocationID;

    if (Settings.getAuthorizedEmployees().containsKey(Settings.current.getID()))
      App.launch(App.class, new String[] {});
    else throw new ServiceException("Current employee is not authorized to use this service.");
  }

  /**
   * Add your own add, edit, and remove functionality by creating a MedicineDao with custom
   * functions. By default, the add, edit, and remove used do not do anything. These functions occur
   * after the HashMap of Medicines has been updated. Set these functions to do custom things
   * afterwards, such as updating your SQL Database.
   *
   * @param medicineDao
   */
  public static void setAddEditRemoveFunctions(MedicineDao medicineDao) {
    Settings.medicineActions = medicineDao;
  }

  private static String styleSheetFormat(String path) throws ServiceException {
    try {
      File stylesheetFile = new File(path);
      return stylesheetFile.toURI().toURL().toString();
    } catch (MalformedURLException e) {
      throw new ServiceException("CSS File Not Located");
    }
  }

  /**
   * Adds a new employee that can use this request
   *
   * @param ID ID of employee to give access
   * @throws ServiceException If employee is already authorized
   */
  public static void addAuthorizedEmployee(String ID) throws ServiceException {
    if (Settings.getAuthorizedEmployees().containsKey(ID))
      throw new ServiceException("Employee already authorized");
    else Settings.getAuthorizedEmployees().put(ID, new DefaultEmployee(ID));
  }

  /**
   * Removes an employee from using this request
   *
   * @param ID ID of employee to remove access
   * @throws ServiceException If employee with ID is not found
   */
  public static void removeAuthorizedEmployee(String ID) throws ServiceException {
    if (Settings.getAuthorizedEmployees().containsKey(ID))
      Settings.getAuthorizedEmployees().remove(ID);
    else throw new ServiceException("Employee already not authorized.");
  }

  /**
   * Edits an authorized employee's ID
   *
   * @param oldId Old employee ID
   * @param newID New employee ID
   * @throws ServiceException If employee with old ID wasn't found
   */
  public static void editAuthorizedEmployee(String oldId, String newID) throws ServiceException {
    if (Settings.getAuthorizedEmployees().containsKey(oldId)) {
      removeAuthorizedEmployee(oldId);
      addAuthorizedEmployee(newID);
    } else throw new ServiceException("Could not find employee with old ID");
  }

  /**
   * Sets the current Employee that with will be using this request page
   *
   * @param id ID of employee
   */
  public static void setCurrentEmployee(String id) {
    Settings.current = new DefaultEmployee(id);
  }

  public static void addLocationIDs(List<String> ids) {
    for (String id : ids) Settings.getLocations().put(id, new DefaultLocation(id));
  }
}
