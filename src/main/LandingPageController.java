package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LandingPageController extends AnchorPane implements Initializable {
    private Main app;

    @FXML
    private Button userlogin;

    public void setApp(Main app) {
        this.app = app;
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle){
    }

    public void loginUserButton() {
        try {
            app.gotToLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
