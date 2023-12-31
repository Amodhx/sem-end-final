package lk.ijse.finalproject02.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.finalproject02.DTO.StudentDTO;
import lk.ijse.finalproject02.service.ServiceFactory;
import lk.ijse.finalproject02.service.custom.impl.StudentServiceImpl;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class dashboardController implements Initializable {
    public static String ty;
    public static String fullname;




    @FXML
    private JFXButton attendencebutton;

    @FXML
    private JFXButton classbutton;




    @FXML
    private JFXButton studentbutton1;
    @FXML
    private JFXButton exambutton;

    @FXML
    private JFXButton mailbutton;

    public static JFXButton button;
    @FXML
    private TextField searchfield;



    @FXML
    private JFXButton settingbutton;

    @FXML
    private JFXButton studentbutton;



    @FXML
    private JFXButton teacherbutton;

    @FXML
    private TextField textfield;

    @FXML
    private AnchorPane pane;
    @FXML
    private Label typeLable;
    @FXML
    private Label fulNameLable;

    @FXML
    private Button iconButton;
    StudentServiceImpl studentService = (StudentServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.STUDENT);

    ArrayList<StudentDTO> allStudents;

    {
        try {
            allStudents = studentService.getAll();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    ;
    private Set<String> studentlistDTO = new HashSet<>();

    @FXML
    void onsearching(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)){
            String searchfieldText = searchfield.getText();
        }


    }
    @FXML
    void oniconCLick(ActionEvent event) {
        Stage stage = new Stage();
        addadminController.button = teacherbutton;
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("/view/addadmin-form.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setX(1060);
        stage.setY(50);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }



    @FXML
    void onadminiconClikc(MouseEvent event) {


    }
    @FXML
    void onattendenceclick(ActionEvent event) {
        colourRemove();
        attendencebutton.setStyle("-fx-background-color:rgba(203, 231, 235, 1) ");
        attendencebutton.setTextFill(Color.rgb(5, 75, 180, 1));
        changePage("/view/attendence-form.fxml");

    }

    @FXML
    void onclassesclick(ActionEvent event) {
        colourRemove();
        classbutton.setStyle("-fx-background-color:rgba(203, 231, 235, 1) ");
        classbutton.setTextFill(Color.rgb(5, 75, 180, 1));
        changePage("/view/class-form.fxml");

    }
    @FXML
    void ondashclick(ActionEvent event) {
        colourRemove();
        studentbutton1.setStyle("-fx-background-color:rgba(203, 231, 235, 1) ");
        studentbutton1.setTextFill(Color.rgb(5, 75, 180, 1));
        changePage("/view/db-form.fxml");
    }

    @FXML
    void onexamclikc(ActionEvent event) {
        colourRemove();
        exambutton.setStyle("-fx-background-color: rgba(255, 255, 255, 1)");
        exambutton.setTextFill(Color.rgb(5, 75, 180, 1));
        changePage("/view/exam-form.fxml");

    }

    @FXML
    void onmailclick(ActionEvent event) {
        colourRemove();
        mailbutton.setStyle("-fx-background-color:rgba(203, 231, 235, 1) ");
        mailbutton.setTextFill(Color.rgb(5, 75, 180, 1));
        changePage("/view/mailsend-form.fxml");

    }

    @FXML
    void onsettingclick(ActionEvent event) throws IOException {
        colourRemove();
        changePage("/view/setting-form.fxml");
        settingbutton.setStyle("-fx-background-color:rgba(203, 231, 235, 1) ");
        settingbutton.setTextFill(Color.rgb(5, 75, 180, 1));

    }

    @FXML
    void onstudentclick(ActionEvent event) {
        colourRemove();
        studentbutton.setStyle("-fx-background-color:rgba(203, 231, 235, 1) ");
        studentbutton.setTextFill(Color.rgb(5, 75, 180, 1));
        changePage("/view/student-form.fxml");

    }

    @FXML
    void onteacherclick(ActionEvent event) {
        colourRemove();
        teacherbutton.setStyle("-fx-background-color:rgba(203, 231, 235, 1) ");
        teacherbutton.setTextFill(Color.rgb(5, 75, 180, 1));
        changePage("/view/teacher-form.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searching();
        fulNameLable.setText(fullname);
        typeLable.setText(ty);
            if (ty.equals("Admin")){

        }else if(ty.equals("Cashier")){
                settingbutton.setDisable(true);


        }else if(ty.equals("Security")){
            studentbutton1.setDisable(true);
            mailbutton.setDisable(true);
            teacherbutton.setDisable(true);
            classbutton.setDisable(true);
            settingbutton.setDisable(true);
            exambutton.setDisable(true);
            studentbutton.setDisable(true);

        }
        colourRemove();
        changePage("/view/db-form.fxml");
        studentbutton1.setStyle("-fx-background-color:rgba(203, 231, 235, 1) ");
        studentbutton1.setTextFill(Color.rgb(5, 75, 180, 1));
        dbformController.pane = pane;
    }

    private void searching() {
        allStudents.forEach(StudentDTO -> {
            studentlistDTO.add(StudentDTO.getFirstName() +" "+ StudentDTO.getLastName()+" - " + StudentDTO.getNIC());
        });

        TextFields.bindAutoCompletion(searchfield, studentlistDTO);


    }

    public void changePage(String uiName){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(uiName));
            pane.getChildren().clear();
            pane.getChildren().add(parent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void colourRemove(){
        studentbutton1.setStyle("-fx-background-color:rgba(5, 75, 180, 1) ");
        studentbutton.setStyle("-fx-background-color:rgba(5, 75, 180, 1) ");
        teacherbutton.setStyle("-fx-background-color:rgba(5, 75, 180, 1) ");
        classbutton.setStyle("-fx-background-color:rgba(5, 75, 180, 1) ");
        exambutton.setStyle("-fx-background-color:rgba(5, 75, 180, 1) ");
        attendencebutton.setStyle("-fx-background-color:rgba(5, 75, 180, 1) ");
        mailbutton.setStyle("-fx-background-color:rgba(5, 75, 180, 1) ");
        settingbutton.setStyle("-fx-background-color:rgba(5, 75, 180, 1) ");
        studentbutton1.setTextFill(Color.rgb(255, 255, 255, 1));
        studentbutton.setTextFill(Color.rgb(255, 255, 255, 1));
        teacherbutton.setTextFill(Color.rgb(255, 255, 255, 1));
        classbutton.setTextFill(Color.rgb(255, 255, 255, 1));
        exambutton.setTextFill(Color.rgb(255, 255, 255, 1));
        attendencebutton.setTextFill(Color.rgb(255, 255, 255, 1));
        mailbutton.setTextFill(Color.rgb(255, 255, 255, 1));
        settingbutton.setTextFill(Color.rgb(255, 255, 255, 1));
    }


}
