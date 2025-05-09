package gui;



import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminDashboard extends Application {

private ObservableList<Room> rooms = FXCollections.observableArrayList();
private ObservableList<Event> events = FXCollections.observableArrayList();
private ObservableList<Attendee> attendees = FXCollections.observableArrayList();
private ObservableList<Organizer> organizers = FXCollections.observableArrayList();
private ObservableList<Category> categories = FXCollections.observableArrayList();

@Override
public void start(Stage primaryStage) {
TabPane tabPane = new TabPane();

tabPane.getTabs().add(createRoomsTab());
tabPane.getTabs().add(createEventsTab());
tabPane.getTabs().add(createAttendeesTab());
tabPane.getTabs().add(createOrganizersTab());
tabPane.getTabs().add(createCategoriesTab());

Scene scene = new Scene(tabPane, 800, 600);
primaryStage.setTitle("Admin Dashboard");
primaryStage.setScene(scene);
primaryStage.show();
}

private Tab createRoomsTab() {
Tab tab = new Tab("Rooms");
VBox layout = new VBox(10);
layout.setPadding(new Insets(10));

TableView<Room> table = new TableView<>(rooms);
TableColumn<Room, String> idCol = new TableColumn<>("Room ID");
idCol.setCellValueFactory(new PropertyValueFactory<>("roomId"));
table.getColumns().add(idCol);

TextField roomIdField = new TextField();
roomIdField.setPromptText("Room ID");

Button add = new Button("Add");
add.setOnAction(e -> {
rooms.add(new Room(roomIdField.getText()));
roomIdField.clear();
});

Button remove = new Button("Remove");
remove.setOnAction(e -> {
Room selected = table.getSelectionModel().getSelectedItem();
if (selected != null) rooms.remove(selected);
});

layout.getChildren().addAll(table, roomIdField, new HBox(10, add, remove));
tab.setContent(layout);
return tab;
}

private Tab createEventsTab() {
Tab tab = new Tab("Events");
VBox layout = new VBox(10);
layout.setPadding(new Insets(10));

TableView<Event> table = new TableView<>(events);
TableColumn<Event, String> nameCol = new TableColumn<>("Event Name");
nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
table.getColumns().add(nameCol);

TextField eventNameField = new TextField();
eventNameField.setPromptText("Event Name");

Button add = new Button("Add");
add.setOnAction(e -> {
events.add(new Event(eventNameField.getText()));
eventNameField.clear();
});

Button remove = new Button("Remove");
remove.setOnAction(e -> {
Event selected = table.getSelectionModel().getSelectedItem();
if (selected != null) events.remove(selected);
});

layout.getChildren().addAll(table, eventNameField, new HBox(10, add, remove));
tab.setContent(layout);
return tab;
}

private Tab createAttendeesTab() {
Tab tab = new Tab("Attendees");
VBox layout = new VBox(10);
layout.setPadding(new Insets(10));

TableView<Attendee> table = new TableView<>(attendees);
TableColumn<Attendee, String> nameCol = new TableColumn<>("Username");
nameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
table.getColumns().add(nameCol);

TextField usernameField = new TextField();
usernameField.setPromptText("Username");

Button add = new Button("Add");
add.setOnAction(e -> {
attendees.add(new Attendee(usernameField.getText()));
usernameField.clear();
});

Button remove = new Button("Remove");
remove.setOnAction(e -> {
Attendee selected = table.getSelectionModel().getSelectedItem();
if (selected != null) attendees.remove(selected);
});

layout.getChildren().addAll(table, usernameField, new HBox(10, add, remove));
tab.setContent(layout);
return tab;
}

private Tab createOrganizersTab() {
Tab tab = new Tab("Organizers");
VBox layout = new VBox(10);
layout.setPadding(new Insets(10));

TableView<Organizer> table = new TableView<>(organizers);
TableColumn<Organizer, String> nameCol = new TableColumn<>("Username");
nameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
table.getColumns().add(nameCol);

TextField usernameField = new TextField();
usernameField.setPromptText("Username");

Button add = new Button("Add");
add.setOnAction(e -> {
organizers.add(new Organizer(usernameField.getText()));
usernameField.clear();
});

Button remove = new Button("Remove");
remove.setOnAction(e -> {
Organizer selected = table.getSelectionModel().getSelectedItem();
if (selected != null) organizers.remove(selected);
});

layout.getChildren().addAll(table, usernameField, new HBox(10, add, remove));
tab.setContent(layout);
return tab;
}

private Tab createCategoriesTab() {
Tab tab = new Tab("Categories");
VBox layout = new VBox(10);
layout.setPadding(new Insets(10));

TableView<Category> table = new TableView<>(categories);
TableColumn<Category, String> idCol = new TableColumn<>("ID");
idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
TableColumn<Category, String> nameCol = new TableColumn<>("Name");
nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
table.getColumns().addAll(idCol, nameCol);

TextField idField = new TextField();
idField.setPromptText("ID");
TextField nameField = new TextField();
nameField.setPromptText("Name");

Button add = new Button("Add");
add.setOnAction(e -> {
categories.add(new Category(idField.getText(), nameField.getText()));
idField.clear(); nameField.clear();
});

Button remove = new Button("Remove");
remove.setOnAction(e -> {
Category selected = table.getSelectionModel().getSelectedItem();
if (selected != null) categories.remove(selected);
});

layout.getChildren().addAll(table, new HBox(10, idField, nameField), new HBox(10, add, remove));
tab.setContent(layout);
return tab;
}

public static void main(String[] args) {
launch(args);
}

// Dummy classes for illustration
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

public static class Organizer {
private final String username;
public Organizer(String username) { this.username = username; }
public String getUsername() { return username; }
}

public static class Category {
private final String id;
private final String name;
public Category(String id, String name) {
this.id = id;
this.name = name;
}
public String getId() { return id; }
public String getName() { return name; }
}
}