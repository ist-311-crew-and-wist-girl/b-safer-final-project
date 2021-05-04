package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import main.model.business.Business;
import main.model.business.BusinessList;

import java.net.URL;
import java.util.ResourceBundle;

public class BusinessListController extends AnchorPane implements Initializable {

    @FXML
    ScrollPane scrollArea;

    @FXML
    VBox scrollBox;

    private Main app;

    BusinessList bsList = new BusinessList();
    public void setApp(Main app) {
        this.app = app;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Loops through business list from XML file and sets each button's text to each business's name
        for (Business business : bsList.getBusinesses()) {
            Button iterButton = new Button();
            iterButton.setText(business.getBusinessName());


            // EventHandler for each button, passes business to goToBusinessPage in the Main class
            EventHandler<MouseEvent> menuClicked = e -> app.goToBusinessPage(business);

            // Adds Event to button
            iterButton.addEventHandler(MouseEvent.MOUSE_CLICKED, menuClicked);

            // Add styling to button
            Font font = Font.font("Calibri", 36);
            iterButton.setStyle("-fx-background-color: #333333");
            iterButton.setTextFill(Paint.valueOf("WHITE"));
            iterButton.setFont(font);
            iterButton.setMaxWidth(300.0);
            DropShadow dropShadow = new DropShadow();
            dropShadow.setOffsetY(3.0);
            iterButton.setEffect(dropShadow);
            scrollBox.setSpacing(15.0);

            // Make the Business Buttons visible to the user
            iterButton.setVisible(true);

            // Adding button to Vbox in the scrollPane
            scrollBox.getChildren().add(iterButton);
        }
    }

    @FXML
    protected void openBusinessPage(ActionEvent event){
        try {
            //app.goToBusinessPage();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void userLogout(ActionEvent event) {
        app.actorUserLogout();
    }
}
