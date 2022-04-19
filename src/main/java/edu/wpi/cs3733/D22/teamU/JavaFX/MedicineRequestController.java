package edu.wpi.cs3733.D22.teamU.JavaFX;

import edu.wpi.cs3733.D22.teamU.Employee.DefaultEmployee;
import edu.wpi.cs3733.D22.teamU.MedicineData.Medicine;
import edu.wpi.cs3733.D22.teamU.Settings;
import java.net.URL;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Scale;

public class MedicineRequestController implements Initializable {

  public AnchorPane masterPane;
  public DatePicker date;
  public Button addBtn;
  public Button removeBtn;
  public Button editBtn;
  public TextField name;
  public TextField patient;
  public TextField amount;
  public TextArea status;
  public StackPane stack;
  public TableColumn<Medicine, String> cname;
  public TableColumn<Medicine, String> cdestination;
  public TableColumn<Medicine, String> cpatient;
  public TableColumn<Medicine, String> cemployee;
  public TableColumn<Medicine, LocalDate> cdate;
  public TableColumn<Medicine, String> camount;
  public TableView table;
  public ComboBox<String> destinationbox;
  public ComboBox<DefaultEmployee> staffbox;
  private Medicine temp;

  /**
   * Initializes the Medicine Request Window
   *
   * @param location
   * @param resources
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    setColumnProperty();
    staffbox.setItems(
        FXCollections.observableArrayList(Settings.getInstance().getAuthorizedEmployees().values()));
    staffbox.setValue(Settings.getInstance().getCurrent());

    // Settings.getInstance().medicineActions.getMedicines().put( "test",new Medicine( "test", "test", "test",
    // "test", "test", LocalDate.of(2003, 1, 19), "test"));
    updateRequests();
    disableOnEmpty(addBtn);
    disableOnEmpty(editBtn);
    disableOnEmpty(removeBtn);
    stack.setAlignment(Pos.CENTER);
    masterPane
        .heightProperty()
        .addListener(
            (obs, oldVal, newVal) -> {
              double yScale = masterPane.getHeight() / masterPane.getPrefHeight();
              double xScale = masterPane.getWidth() / masterPane.getPrefWidth();
              double ratio = Math.min(yScale, xScale);
              Scale scale = new Scale(xScale, yScale);
              scale.setPivotX(0);
              scale.setPivotY(0);
              masterPane.getScene().getRoot().getTransforms().setAll(scale);
            });

    masterPane
        .widthProperty()
        .addListener(
            (obs, oldVal, newVal) -> {
              double yScale = masterPane.getHeight() / masterPane.getPrefHeight();
              double xScale = masterPane.getWidth() / masterPane.getPrefWidth();
              double ratio = Math.min(yScale, xScale);
              // Scale scale = new Scale(ratio, ratio);
              Scale scale = new Scale(xScale, yScale);
              scale.setPivotX(0);
              scale.setPivotY(0);
              masterPane.getScene().getRoot().getTransforms().setAll(scale);
            });
  }

  private void setColumnProperty() {
    cname.setCellValueFactory(new PropertyValueFactory<Medicine, String>("medicineName"));
    cdate.setCellValueFactory(new PropertyValueFactory<Medicine, LocalDate>("dateNeeded"));
    cdestination.setCellValueFactory(new PropertyValueFactory<Medicine, String>("destinationID"));
    cpatient.setCellValueFactory(new PropertyValueFactory<Medicine, String>("patientID"));
    camount.setCellValueFactory(new PropertyValueFactory<Medicine, String>("amount"));
    cemployee.setCellValueFactory(new PropertyValueFactory<Medicine, String>("employeeID"));
  }

  private void disableOnEmpty(Button b) {

    b.disableProperty()
        .bind(
            Bindings.isEmpty(date.getEditor().textProperty())
                .or(Bindings.isEmpty((ObservableStringValue) destinationbox.valueProperty()))
                .or(Bindings.isEmpty(name.textProperty()))
                .or(Bindings.isEmpty(patient.textProperty()))
                .or(Bindings.isEmpty((ObservableStringValue) staffbox.getValue()))
                .or(Bindings.isEmpty(amount.textProperty())));
  }

  private ObservableList<Medicine> medicines;

  private void updateRequests() {
    medicines =
        FXCollections.observableArrayList(Settings.getInstance().getMedicineActions().getMedicines().values());
    medicines.sort(
        new Comparator<Medicine>() {
          @Override
          public int compare(Medicine o1, Medicine o2) {
            LocalDate d1 = o1.getDateNeeded(), d2 = o2.getDateNeeded();
            if (d1.isEqual(d2)) {
              return 0;
            } else if (d1.isAfter(d2)) return 1;
            else return -1;
          }
        });
    table.setItems(medicines);
  }

  private void clearText() {
    date.getEditor().clear();
    destinationbox.setValue("");
    name.setText("");
    patient.setText("");
    destinationbox.setValue("");
    amount.setText("");
  }

  /**
   * Adds the Medicine to DataDao
   *
   * @param mouseEvent
   */
  public void add(MouseEvent mouseEvent) {
    Medicine m =
        new Medicine(
            name.getText(),
            destination.getText(),
            patient.getText(),
            staff.getText(),
            date.getValue(),
            amount.getText());

    if (Settings.getInstance().getMedicineActions().getMedicines().containsKey(m.getID())) {
      status.setText("Medicine with same ID already exists.");
    } else {
      Settings.getInstance().getMedicineActions().getMedicines().put(m.getID(), m);
      Settings.getInstance().getMedicineActions().add(m);
      updateRequests();
      clearText();
      status.setText("Successfully added new request.");
    }
  }

  /**
   * Removes the Medicine from the MedicineDao
   *
   * @param mouseEvent
   */
  public void remove(MouseEvent mouseEvent) {
    if (temp == null)
      status.setText("Please choose existing request in the \"View Requests\" table to remove.");
    else {
      Medicine m =
          new Medicine(
              temp.getID(),
              name.getText(),
              destination.getText(),
              patient.getText(),
              staff.getText(),
              date.getValue(),
              amount.getText());
      if (Settings.getInstance().getMedicineActions().getMedicines().containsKey(m.getID())) {
        Settings.getInstance().getMedicineActions().getMedicines().remove(m.getID());
        Settings.getInstance().getMedicineActions().remove(m);
        updateRequests();
        clearText();
        temp = null;
        status.setText("Successfully removed request.");
      } else status.setText("Medicine with same ID was not found to delete.");
    }
  }

  /**
   * Removes the Medicine from the MedicineDao
   *
   * @param mouseEvent
   */
  public void edit(MouseEvent mouseEvent) {
    if (temp == null)
      status.setText("Please choose existing request in the \"View Requests\" table to edit.");
    else {
      Medicine m =
          new Medicine(
              temp.getID(),
              name.getText(),
              destination.getText(),
              patient.getText(),
              staff.getText(),
              date.getValue(),
              amount.getText());
      if (Settings.getInstance().getMedicineActions().getMedicines().containsKey(m.getID())) {
        Settings.getInstance().getMedicineActions().getMedicines().put(m.getID(), m);
        Settings.getInstance().getMedicineActions().edit(m);
        updateRequests();
        clearText();
        temp = null;
        status.setText("Successfully edited request.");
      } else status.setText("Medicine with same ID was not found to edit.");
    }
  }

  /**
   * Gets the Medicine selected from the table
   *
   * @param mouseEvent
   */
  public void selectRequest(MouseEvent mouseEvent) {
    if (table.getSelectionModel().getSelectedItem() instanceof Medicine) {
      temp = (Medicine) table.getSelectionModel().getSelectedItem();
      date.setValue(temp.getDateNeeded());
      date.getEditor().setText(temp.getDateNeeded().toString());
      destination.setText(temp.getDestinationID());
      name.setText(temp.getMedicineName());
      patient.setText(temp.getPatientID());
      staff.setText(temp.getEmployeeID());
      amount.setText(temp.getAmount());
    }
  }
}
