package edu.wpi.cs3733.D22.teamU;

import edu.wpi.cs3733.D22.teamU.JavaFX.App;

public abstract class MedicineRequest {

  public static void main(String[] args) {
    App.launch(App.class, args);
  }

  public static void run(
      int xCoord,
      int yCoord,
      int windowWidth,
      int windowLength,
      String cssPath,
      String destLocationID,
      String originLocationID) {
    Settings.xCoord = xCoord;
    Settings.yCoord = yCoord;
    Settings.windowWidth = windowWidth;
    Settings.windowLength = windowLength;
    Settings.cssPath = cssPath;
    Settings.destLocationID = destLocationID;
    Settings.originLocationID = originLocationID;
    App.launch(App.class, new String[] {});
  }
}
