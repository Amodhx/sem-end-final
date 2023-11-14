package lk.ijse.finalproject02.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.finalproject02.DTO.UserDTO;
import lk.ijse.finalproject02.Model.Usermodel;

import java.net.URL;
import java.util.ResourceBundle;

public class addminAddpopformController implements Initializable {

    @FXML
    private TextField UserNamefield;

    @FXML
    private JFXButton canselButton;

    @FXML
    private TextField emailField;

    @FXML
    private TextField namefeild;

    @FXML
    private TextField passwordField;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXComboBox<String> typeCombo;

    @FXML
    void onCanselButton(ActionEvent event) {
        Stage stage = (Stage) canselButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void onSaveClick(ActionEvent event) {
        String namefieldText = UserNamefield.getText();
        String text = namefeild.getText();
        String passwordFieldText = passwordField.getText();
        String emailFieldText = emailField.getText();
        String type = typeCombo.getValue();

        UserDTO userDTO = new UserDTO(0,namefieldText,passwordFieldText,type,emailFieldText,text);
        boolean b = Usermodel.savUser(userDTO);
        if (b){
            Stage stage = (Stage) canselButton.getScene().getWindow();
            stage.close();
            new Alert(Alert.AlertType.CONFIRMATION,"Admin add successfully");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> observableList = FXCollections.observableArrayList("Admin","Cashier","Security");
        typeCombo.setItems(observableList);
    }
}
