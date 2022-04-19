package edu.wpi.cs3733.D22.teamU.JavaFX;

import edu.wpi.cs3733.D22.teamU.MedicineData.Medicine;
import edu.wpi.cs3733.D22.teamU.Settings;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MedicineRequestController implements Initializable {

  public AnchorPane masterPane;
  public DatePicker date;
  public Button addBtn;
  public Button removeBtn;
  public Button editBtn;
  public TextField destination;
  public TextField name;
  public TextField patient;
  public TextField staff;
  public TextField amount;
  public ComboBox<Medicine> requests;

  private Medicine temp;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Settings.medicineActions
        .getMedicines()
        .put("test", new Medicine("test", "test", "test", "test", "test", "test", "test"));
    updateRequests();
  }

  private void updateRequests() {
    requests.setItems(
        FXCollections.observableArrayList(Settings.medicineActions.getMedicines().values()));
  }

  private void clearText() {
    date.getEditor().clear();
    destination.setText("");
    name.setText("");
    patient.setText("");
    staff.setText("");
    amount.setText("");
  }

  public void add(MouseEvent mouseEvent) {
    LocalDate d = date.getValue();
    Medicine m =
        new Medicine(
            String.valueOf(new Random().nextInt()),
            name.getText(),
            destination.getText(),
            patient.getText(),
            staff.getText(),
            date.getEditor().getText(),
            amount.getText());
    Settings.medicineActions.add(m);
    updateRequests();
    clearText();
  }

  public void remove(MouseEvent mouseEvent) {
    System.out.println("Removed");
    LocalDate d = date.getValue();
    Medicine m =
        new Medicine(
            temp.getID(),
            name.getText(),
            destination.getText(),
            patient.getText(),
            staff.getText(),
            date.getEditor().getText(),
            amount.getText());

    Settings.medicineActions.remove(m);
    updateRequests();
    clearText();
  }

  public void edit(MouseEvent mouseEvent) {

    Medicine m =
        new Medicine(
            temp.getID(),
            name.getText(),
            destination.getText(),
            patient.getText(),
            staff.getText(),
            date.getEditor().getText(),
            amount.getText());
    Settings.medicineActions.edit(m);
    updateRequests();
    clearText();
  }

  public void getRequest(ActionEvent actionEvent) {
    temp = requests.getValue();
    date.getEditor().setText(temp.getDateNeeded());
    destination.setText(temp.getDestinationID());
    name.setText(temp.getMedicineName());
    patient.setText(temp.getPatientID());
    staff.setText(temp.getEmployeeID());
    amount.setText(temp.getAmount());
  }
}
