
package gui;

import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AttendeeDashboard extends Application {

    private ObservableList<Event> availableEvents = FXCollections.observableArrayList();
    private ObservableList<Event> myTickets = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        tabPane.getTabs().add(createAvailableEventsTab());
        tabPane.getTabs().add(createMyTicketsTab());
        tabPane.getTabs().add(createProfileTab());

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setTitle("Attendee Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Tab createAvailableEventsTab() {
        Tab tab = new Tab("Available Events");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        TableView<Event> table = new TableView<>(availableEvents);
        TableColumn<Event, String> titleCol = new TableColumn<>("Event Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Event, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.getColumns().addAll(titleCol, priceCol);

        Button buy = new Button("Buy Ticket");
        buy.setOnAction(e -> {
            Event selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                myTickets.add(selected);
                availableEvents.remove(selected);
            }
        });

        layout.getChildren().addAll(table, buy);
        tab.setContent(layout);
        return tab;
    }

    private Tab createMyTicketsTab() {
        Tab tab = new Tab("My Tickets");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        TableView<Event> table = new TableView<>(myTickets);
        TableColumn<Event, String> titleCol = new TableColumn<>("Event Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Event, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.getColumns().addAll(titleCol, priceCol);

        layout.getChildren().addAll(table);
        tab.setContent(layout);
        return tab;
    }

    private Tab createProfileTab() {
        Tab tab = new Tab("Profile");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        Label username = new Label("Username: attendee1");
        Label address = new Label("Address: 123 Street");
        Label gender = new Label("Gender: MALE");
        Label balance = new Label("Balance: 150.0");
        Label interests = new Label("Interests: Music, Tech");

        layout.getChildren().addAll(username, address, gender, balance, interests);
        tab.setContent(layout);
        return tab;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Event {
        private final String title;
        private final double price;

        public Event(String title, double price) {
            this.title = title;
            this.price = price;
        }

        public String getTitle() { return title; }
        public double getPrice() { return price; }
    }
}
