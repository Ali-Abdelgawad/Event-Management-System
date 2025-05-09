package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Choose_reg_or_login extends Application {

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(400, 400);

        // Title Text
        Text title = new Text("Event Management System");
        title.setFont(new Font(33));
        title.setLayoutX(2);
        title.setLayoutY(85);

        // Subtitle
        Text chooseText = new Text("Choose to :");
        chooseText.setFont(new Font(24));
        chooseText.setLayoutX(140);
        chooseText.setLayoutY(147);

        // Login Button
        Button loginButton = new Button("Login");
        loginButton.setFont(new Font(27));
        loginButton.setPrefSize(238, 57);
        loginButton.setLayoutX(81);
        loginButton.setLayoutY(200);
        loginButton.setOnAction(e -> System.out.println("Login button clicked"));

        // Register Button
        Button registerButton = new Button("Register");
        registerButton.setFont(new Font(27));
        registerButton.setPrefSize(238, 57);
        registerButton.setLayoutX(81);
        registerButton.setLayoutY(257);
        registerButton.setOnAction(e -> System.out.println("Register button clicked"));

        // Add all to root
        root.getChildren().addAll(title, chooseText, loginButton, registerButton);

        // Create scene and show
        Scene scene = new Scene(root);
        primaryStage.setTitle("Event Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
