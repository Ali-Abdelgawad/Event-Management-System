package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OrganizerLogin extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setPrefSize(400, 400);

        // Title
        Text title = new Text("Logging in as Organizer");
        title.setFont(new Font(29));
        title.setLayoutX(68);
        title.setLayoutY(65);

        // Username Label
        Text usernameLabel = new Text("Username:");
        usernameLabel.setFont(new Font(24));
        usernameLabel.setLayoutX(56);
        usernameLabel.setLayoutY(150);

        // Password Label
        Text passwordLabel = new Text("Password:");
        passwordLabel.setFont(new Font(24));
        passwordLabel.setLayoutX(56);
        passwordLabel.setLayoutY(199);

        // Username Field
        TextField usernameField = new TextField();
        usernameField.setLayoutX(196);
        usernameField.setLayoutY(128);

        // Password Field
        TextField passwordField = new TextField();  // You may replace this with PasswordField for masking
        passwordField.setLayoutX(196);
        passwordField.setLayoutY(178);

        // Login Button
        Button loginButton = new Button("Login");
        loginButton.setPrefSize(289, 57);
        loginButton.setLayoutX(56);
        loginButton.setLayoutY(255);
        loginButton.setOnAction(e -> {
            System.out.println("Login pressed");
            System.out.println("Username: " + usernameField.getText());
            System.out.println("Password: " + passwordField.getText());
        });

        root.getChildren().addAll(title, usernameLabel, passwordLabel, usernameField, passwordField, loginButton);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin Login");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
