package edu.wpi.cs3733.D22.teamU.JavaFX;

import edu.wpi.cs3733.D22.teamU.Settings;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App extends Application {

  @Override
  public void init() {
    log.info("Starting Up");
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    if (Settings.getWindowLength() <= 0)
      primaryStage.setHeight(Screen.getPrimary().getBounds().getHeight());
    else primaryStage.setHeight(Settings.getWindowLength());

    if (Settings.getWindowWidth() <= 0)
      primaryStage.setWidth(Screen.getPrimary().getBounds().getWidth());
    else primaryStage.setWidth(Settings.getWindowWidth());

    if (Settings.getxCoord() <= 0) primaryStage.setX(0);
    else primaryStage.setX(Settings.getxCoord());

    if (Settings.getyCoord() <= 0) primaryStage.setY(0);
    primaryStage.setY(Settings.getyCoord());
    Scene scene = getScene("edu/wpi/cs3733/D22/teamU/fxmlFiles/MedicineRequest.fxml");
    scene.getStylesheets().add(Settings.getCssPath());
    primaryStage.setTitle("Medicine Request Service");
    primaryStage.setScene(scene);
    primaryStage.setResizable(true);
    primaryStage.show();
  }

  private static Scene getScene(String path) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    Parent root = loader.load(App.class.getClassLoader().getResource(path));

    return new Scene(root);
  }

  @Override
  public void stop() {
    log.info("Shutting Down");
  }
}
