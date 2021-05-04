package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import main.model.business.Business;
import main.model.business.BusinessReview;
import main.model.business.ReviewLoader;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class BusinessPageController extends AnchorPane implements Initializable {

    @FXML
    public Label businessNameLabel;

    @FXML
    public Label addressLabel;

    @FXML
    public Label ratingLabel;

    @FXML
    public Label safetyWarningLabel;

    @FXML
    public Label urlLabel;

    @FXML
    public Label phoneLabel;

    @FXML
    private VBox scrollPage;

    @FXML
    private Button signup;

    @FXML
    private Button login;


    private Main app;

    Business business;

    public void setApp(Main app, Business businessToSet) {
        this.business = businessToSet;
        this.app = app;

        // Load in business information
        businessNameLabel.setText(business.getBusinessName());
        businessNameLabel.setVisible(true);
        addressLabel.setText(business.getBusinessAddress());
        addressLabel.setVisible(true);
        ratingLabel.setText(business.getBusinessRating());
        ratingLabel.setVisible(true);
        safetyWarningLabel.setText(business.getBusinessSafetyWarning());
        safetyWarningLabel.setVisible(true);
        urlLabel.setText(business.getBusinessURL());
        urlLabel.setVisible(true);
        phoneLabel.setText(business.getBusinessPhone());
        phoneLabel.setVisible(true);

        // Load in current reviews
        ReviewLoader loader = new ReviewLoader(business.getIdNum());
        for (BusinessReview review : loader.getReviews()) {
            HBox reviewInfo = new HBox();

            // Short for rating label
            Label ratLab = new Label("Rating:");
            ratLab.setTextFill(Paint.valueOf("WHITE"));
            reviewInfo.getChildren().add(ratLab);

            Label rat = new Label(review.getRating()+"");
            rat.setTextFill(Paint.valueOf("WHITE"));
            reviewInfo.getChildren().add(rat);


            Label userLab = new Label("Username:");
            userLab.setTextFill(Paint.valueOf("WHITE"));
            reviewInfo.getChildren().add(userLab);

            Label user = new Label(review.getReviewer());
            user.setTextFill(Paint.valueOf("WHITE"));
            reviewInfo.getChildren().add(user);


            scrollPage.setSpacing(10.0);
            scrollPage.getChildren().add(reviewInfo);
            Label reviewComment = new Label(review.getComment());
            reviewComment.setTextFill(Paint.valueOf("WHITE"));
            reviewComment.setWrapText(true);
            scrollPage.getChildren().add(reviewComment);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
    }

    @FXML
    public void backToBusinessList(ActionEvent event) {
        app.goToBusinessList();
    }

    @FXML
    public void userLogout(ActionEvent event) {
        app.actorUserLogout();
    }
}