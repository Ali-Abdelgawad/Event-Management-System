package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane login_selection_pane = new Pane();
        login_selection_pane.setPrefSize(400, 400);

        // "Event Management System" text
        Text title = new Text("Event Management System");
        title.setFont(new Font(33.0));
        title.setLayoutX(2.0);
        title.setLayoutY(85.0);

        // "Login as:" text
        Text loginAsText = new Text("Login as:");
        loginAsText.setFont(new Font(29.0));
        loginAsText.setLayoutX(144.0);
        loginAsText.setLayoutY(155.0);

        // Attendee button
        Button attendeeBtn = new Button("Attendee");
        attendeeBtn.setLayoutX(81.0);
        attendeeBtn.setLayoutY(200.0);
        attendeeBtn.setPrefWidth(238.0);
        attendeeBtn.setPrefHeight(57.0);
        attendeeBtn.setOnAction(e -> System.out.println("Attendee clicked"));

        // Organizer button
        Button organizerBtn = new Button("Organizer");
        organizerBtn.setLayoutX(81.0);
        organizerBtn.setLayoutY(257.0);
        organizerBtn.setPrefWidth(119.0);
        organizerBtn.setPrefHeight(42.0);
        organizerBtn.setOnAction(e -> System.out.println("Organizer clicked"));

        // Admin button
        Button adminBtn = new Button("Admin");
        adminBtn.setLayoutX(200.0);
        adminBtn.setLayoutY(257.0);
        adminBtn.setPrefWidth(119.0);
        adminBtn.setPrefHeight(42.0);
        adminBtn.setOnAction(e -> System.out.println("Admin clicked"));

        // Add all elements to the login_selection_pane pane
        login_selection_pane.getChildren().addAll(title, loginAsText, attendeeBtn, organizerBtn, adminBtn);

        // Set up the scene and stage
        Scene scene = new Scene(login_selection_pane);
        primaryStage.setTitle("Login Selection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}