
package gui;

import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class OrganizerDashboard extends Application {

    private ObservableList<Room> availableRooms = FXCollections.observableArrayList();
    private ObservableList<Event> myEvents = FXCollections.observableArrayList();
    private ObservableList<Attendee> attendeesForEvents = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        tabPane.getTabs().add(createAvailableRoomsTab());
        tabPane.getTabs().add(createMyEventsTab());
        tabPane.getTabs().add(createAttendeesTab());

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setTitle("Organizer Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Tab createAvailableRoomsTab() {
        Tab tab = new Tab("Available Rooms");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        TableView<Room> table = new TableView<>(availableRooms);
        TableColumn<Room, String> idCol = new TableColumn<>("Room ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        table.getColumns().add(idCol);

        layout.getChildren().addAll(table);
        tab.setContent(layout);
        return tab;
    }

    private Tab createMyEventsTab() {
        Tab tab = new Tab("My Events");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        TableView<Event> table = new TableView<>(myEvents);
        TableColumn<Event, String> nameCol = new TableColumn<>("Event Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameCol);

        TextField eventNameField = new TextField();
        eventNameField.setPromptText("Event Name");

        Button add = new Button("Add");
        add.setOnAction(e -> {
            myEvents.add(new Event(eventNameField.getText()));
            eventNameField.clear();
        });

        Button remove = new Button("Remove");
        remove.setOnAction(e -> {
            Event selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) myEvents.remove(selected);
        });

        layout.getChildren().addAll(table, eventNameField, new HBox(10, add, remove));
        tab.setContent(layout);
        return tab;
    }

    private Tab createAttendeesTab() {
        Tab tab = new Tab("Attendees for My Events");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        TableView<Attendee> table = new TableView<>(attendeesForEvents);
        TableColumn<Attendee, String> nameCol = new TableColumn<>("Username");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        table.getColumns().add(nameCol);

        layout.getChildren().addAll(table);
        tab.setContent(layout);
        return tab;
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Dummy classes for demonstration
    public static class Room {
        private final String roomId;
        public Room(String roomId) { this.roomId = roomId; }
        public String getRoomId() { return roomId; }
    }

    public static class Event {
        private final String name;
        public Event(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class Attendee {
        private final String username;
        public Attendee(String username) { this.username = username; }
        public String getUsername() { return username; }
    }
}
