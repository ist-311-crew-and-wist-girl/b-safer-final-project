package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.model.security.Authenticate;
import main.model.users.ActorUser;

import java.util.ResourceBundle;
import java.net.URL;

public class LoginController extends AnchorPane implements Initializable {

    @FXML
    TextField userNameEntry;
    @FXML
    TextField passwordEntry;
    @FXML
    Label actiontarget;
    @FXML
    Button cancelLoginButton;
    @FXML
    Button loginButton;

    private Main app;

    public void setApp(Main app) {
        this.app = app;
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        actiontarget.setText("");
        actiontarget.setVisible(false);
    }

    @FXML protected void cancelLogin() {
        try {
            app.goToLandingPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML protected void handleSignInButtonAction(ActionEvent event) {
        ActorUser user = new ActorUser(userNameEntry.getText());
        if (Authenticate.validate(user.getUsername(), passwordEntry.getText())) {
            try {
                app.goToBusinessList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            actiontarget.setText("Your username or password is incorrect!");
            actiontarget.setVisible(true);
        }
    }
}
