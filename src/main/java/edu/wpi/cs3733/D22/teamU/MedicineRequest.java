package edu.wpi.cs3733.D22.teamU;

import edu.wpi.cs3733.D22.teamU.Employee.DefaultEmployee;
import edu.wpi.cs3733.D22.teamU.Exception.ServiceException;
import edu.wpi.cs3733.D22.teamU.JavaFX.App;
import edu.wpi.cs3733.D22.teamU.Location.DefaultLocation;
import edu.wpi.cs3733.D22.teamU.MedicineData.MedicineDao;
import java.io.File;
import java.net.MalformedURLException;

/** Edit and open the Medicine Request window menu. */
public class MedicineRequest<Employee, Location> {

  /**
   * Runs the App with default settings as well as the default .css file
   *
   * @param args
   */
  public static void main(String[] args) throws ServiceException {
    MedicineRequest<DefaultEmployee, DefaultLocation> md = new MedicineRequest<>();
    Settings.getInstance().instance = new Settings<DefaultEmployee, DefaultEmployee>();
    md.addAuthorizedEmployee("Test", new DefaultEmployee("Test"));
    md.setCurrentEmployee(new DefaultEmployee("Test"));
    App.launch(App.class, args);
  }

  public MedicineRequest(){
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
  public void run(
      int xCoord,
      int yCoord,
      int windowWidth,
      int windowLength,
      String cssPath,
      String destLocationID)
      throws ServiceException {
    Settings.getInstance().xCoord = xCoord;
    Settings.getInstance().yCoord = yCoord;
    Settings.getInstance().windowWidth = windowWidth;
    Settings.getInstance().windowLength = windowLength;
    Settings.getInstance().cssPath = styleSheetFormat(cssPath);
    Settings.getInstance().destLocationID = destLocationID;

    if (Settings.getInstance().getAuthorizedEmployees().containsValue(Settings.getInstance().getCurrent()))
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
  public void setAddEditRemoveFunctions(MedicineDao<Employee, Location> medicineDao) {
    Settings.getInstance().medicineActions = medicineDao;
  }

  private String styleSheetFormat(String path) throws ServiceException {
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
  public void addAuthorizedEmployee(String ID, Employee e) throws ServiceException {
    if (Settings.getInstance().getAuthorizedEmployees().containsKey(ID))
      throw new ServiceException("Employee already authorized");
    else Settings.getInstance().getAuthorizedEmployees().put(ID,e);
  }

  /**
   * Removes an employee from using this request
   *
   * @param ID ID of employee to remove access
   * @throws ServiceException If employee with ID is not found
   */
  public void removeAuthorizedEmployee(String ID) throws ServiceException {
    if (Settings.getInstance().getAuthorizedEmployees().containsKey(ID))
      Settings.getInstance().getAuthorizedEmployees();
    else throw new ServiceException("Employee already not authorized.");
  }

  /**
   * //todo
   *
   * @param ID
   * @param updated
   * @throws ServiceException
   */
  public void editAuthorizedEmployee(String ID, Employee updated) throws ServiceException {
    if (Settings.getInstance().getAuthorizedEmployees().containsKey(ID)) {
      Settings.getInstance().getAuthorizedEmployees().put(ID, updated);
    } else throw new ServiceException("Could not find employee with old ID");
  }

  /**
   * Sets the current Employee that with will be using this request page
   *
   * @param e Employee object
   */
  public void setCurrentEmployee(Employee e) {
    Settings.getInstance().current = e;
  }
}
