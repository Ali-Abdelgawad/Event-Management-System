package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RegistrationPage extends Application {

    @Override
    public void start(Stage stage) {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(400, 400);

        // ComboBox
        ComboBox<String> accountTypeBox = new ComboBox<>(FXCollections.observableArrayList("Attendee", "Organizer"));
        accountTypeBox.setLayoutX(169);
        accountTypeBox.setLayoutY(80);
        accountTypeBox.setPrefWidth(150);
        accountTypeBox.setPromptText("Choose");

        // Labels and Fields
        Text title = new Text(2, 69, "Event Management System");
        title.setFont(new Font(33));

        Text accountTypeLabel = new Text(45, 97, "Account type");
        accountTypeLabel.setFont(new Font(20));

        Text usernameLabel = new Text(57, 131, "Username:");
        usernameLabel.setFont(new Font(20));

        TextField usernameField = new TextField();
        usernameField.setLayoutX(169);
        usernameField.setLayoutY(111);

        Text passwordLabel = new Text(60, 161, "Password:");
        passwordLabel.setFont(new Font(20));

        TextField passwordField = new TextField();
        passwordField.setLayoutX(169);
        passwordField.setLayoutY(141);

        Text birthDateLabel = new Text(59, 191, "Birth date:");
        birthDateLabel.setFont(new Font(20));

        DatePicker birthDatePicker = new DatePicker();
        birthDatePicker.setLayoutX(169);
        birthDatePicker.setLayoutY(170);

        Text balanceLabel = new Text(70, 220, "Balance:");
        balanceLabel.setFont(new Font(20));

        TextField balanceField = new TextField();
        balanceField.setLayoutX(169);
        balanceField.setLayoutY(200);

        Text addressLabel = new Text(68, 248, "Address:");
        addressLabel.setFont(new Font(20));

        TextField addressField = new TextField();
        addressField.setLayoutX(169);
        addressField.setLayoutY(229);

        Text genderLabel = new Text(33, 276, "(MALE/FEMALE):");
        genderLabel.setFont(new Font(18));

        TextField genderField = new TextField();
        genderField.setLayoutX(169);
        genderField.setLayoutY(256);

        Text interestsLabel = new Text(9, 305, "Interests (comma separated):");
        interestsLabel.setFont(new Font(14));

        TextField interestsField = new TextField();
        interestsField.setLayoutX(197);
        interestsField.setLayoutY(287);
        interestsField.setPrefSize(121, 25);

        Button registerButton = new Button("Register");
        registerButton.setLayoutX(81);
        registerButton.setLayoutY(329);
        registerButton.setPrefSize(238, 57);
        registerButton.setFont(new Font(27));

        // Add all components to root
        root.getChildren().addAll(accountTypeBox, accountTypeLabel, title, usernameLabel, usernameField,
                passwordLabel, passwordField, birthDateLabel, birthDatePicker, balanceLabel, balanceField,
                addressLabel, addressField, genderLabel, genderField, interestsLabel, interestsField,
                registerButton);

        // Set the visibility based on account type selection
        accountTypeBox.setOnAction(e -> {
            if ("Organizer".equals(accountTypeBox.getValue())) {
                balanceLabel.setVisible(false);
                balanceField.setVisible(false);
                addressLabel.setVisible(false);
                addressField.setVisible(false);
                genderLabel.setVisible(false);
                genderField.setVisible(false);
                interestsLabel.setVisible(false);
                interestsField.setVisible(false);
            } else if ("Attendee".equals(accountTypeBox.getValue())) {
                balanceLabel.setVisible(true);
                balanceField.setVisible(true);
                addressLabel.setVisible(true);
                addressField.setVisible(true);
                genderLabel.setVisible(true);
                genderField.setVisible(true);
                interestsLabel.setVisible(true);
                interestsField.setVisible(true);
            }
        });

        stage.setScene(new Scene(root));
        stage.setTitle("Registration Page");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
