package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.model.business.Business;

import java.io.InputStream;

public class Main extends Application {
    private Stage stage;

    // Set window width and height
    private final double MINIMUM_WINDOW_WIDTH = 800;
    private final double MINIMUM_WINDOW_HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            stage = primaryStage;
            stage.setTitle("B-Safer");
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            goToLandingPage();
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function to replace scene content
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream stdin = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;

        try {
            page = (AnchorPane) loader.load(stdin);
        } finally {
            stdin.close();
        }

        // Create new Scene
        Scene scene = new Scene(page, MINIMUM_WINDOW_WIDTH, MINIMUM_WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    // Open Landing Page
    public void goToLandingPage() {
        try {
            LandingPageController landingPageController = (LandingPageController)
                    replaceSceneContent("templates/landing-page.fxml");
            landingPageController.setApp(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Open Login Page
    public void gotToLoginPage() {
        try {
            LoginController loginController = (LoginController)
                    replaceSceneContent("templates/login.fxml");
            loginController.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Open BusinessList Page
    public void goToBusinessList() {
        try {
            BusinessListController businessList = (BusinessListController)
                    replaceSceneContent("templates/business-list.fxml");
            businessList.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Open specific BusinessPage
    public void goToBusinessPage(Business business) {
        try {
            BusinessPageController businessPage = (BusinessPageController)
                    replaceSceneContent("templates/business-page.fxml");
            businessPage.setApp(this, business);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
