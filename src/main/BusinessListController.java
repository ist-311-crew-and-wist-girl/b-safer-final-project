package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
        for (Business bus : bsList.getBusinesses()) {
            Button iterButton = new Button();
            iterButton.setText(bus.getBusinessName());


            // EventHandler for each button, passes business to goToBusinessPage in the Main class
            EventHandler<MouseEvent> menuClicked = e -> {
                        //app.goToBusinessPage(bus);
                    };

            // Adds Event to button
            iterButton.addEventHandler(MouseEvent.MOUSE_CLICKED, menuClicked);

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
}
