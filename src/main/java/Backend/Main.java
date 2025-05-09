
package Backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // === Dummy Data ===
        Admin admin = new Admin("admin", "adminpass", LocalDate.of(1990, 1, 1), "Manager", 8);
        admin.addCategory(new Category("C1", "Music"));
        admin.addCategory(new Category("C2", "Technology"));

        Room room1 = new Room(1, new String[]{"10AM", "12PM"});
        Room room2 = new Room(2, new String[]{"2PM", "4PM"});
        Room[] rooms = new Room[5];
        rooms[0] = room1;
        rooms[1] = room2;


        List<Organizer> organizers = new ArrayList<>();
        Organizer organizer = new Organizer("org1", "1234", LocalDate.of(1995, 5, 15));
        organizers.add(organizer);

        Event event1 = new Event("E1", "Jazz Night", admin.findCategoryById("C1"), room1, organizer, 100);
        Event event2 = new Event("E2", "AI Talk", admin.findCategoryById    ("C2"), room2, organizer, 200);

        organizer.addEvent(event1);
        organizer.addEvent(event2);

        List<Attendee> attendees = new ArrayList<>();
        Attendee attendee = new Attendee("user1", "4321", LocalDate.of(2000, 3, 20), 150, "Cairo", Gender.MALE, new String[]{"Music", "Tech"});
        attendees.add(attendee);

        int choice;
        do {
            System.out.println("\n===== Event Management System =====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = input.nextInt(); input.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("\n-- Login As --");
                    System.out.println("1. Admin");
                    System.out.println("2. Organizer");
                    System.out.println("3. Attendee");
                    System.out.print("Choice: ");
                    int loginChoice = input.nextInt(); input.nextLine();

                    switch (loginChoice) {
                        case 1 -> {
                            // Login as Admin
                            System.out.print("Enter username: ");
                            String user = input.nextLine();
                            System.out.print("Enter password: ");
                            String pass = input.nextLine();
                            if (admin.login(user, pass)) {
                                int adminOp;
                                do {
                                    System.out.println("\n-- Admin Menu --");
                                    System.out.println("1. Add Category\n2. List Categories\n3. Add Room\n4. Dashboard\n0. Logout");
                                    adminOp = input.nextInt(); input.nextLine();
                                    switch (adminOp) {
                                        case 1 -> {
                                            System.out.print("Category ID: ");
                                            String id = input.nextLine();
                                            System.out.print("Category Name: ");
                                            String name = input.nextLine();
                                            admin.addCategory(new Category(id, name));
                                        }
                                        case 2 -> admin.listCategories();
                                        case 3 -> {
                                            System.out.print("Enter Room ID: ");
                                            int rid = input.nextInt();
                                            input.nextLine();
                                            System.out.print("Enter available hours (comma separated): ");
                                            String[] hours = input.nextLine().split(",");
                                            Room newRoom = new Room(rid, hours);
                                            admin.addRoom(rooms, newRoom);
                                        }
                                        case 4 -> admin.dashboard(rooms, organizer.showMyEvents, attendees.toArray(new Attendee[0]), organizers.toArray(new Organizer[0]));
                                    }
                                } while (adminOp != 0);
                            }  else System.out.println("❌ Invalid login.");
                        }
                        case 2 -> {
                            // Login as Organizer
                            System.out.print("Enter username: ");
                            String user = input.nextLine();
                            System.out.print("Enter password: ");
                            String pass = input.nextLine();
                            Organizer found = null;
                            for (Organizer o : organizers) {
                                if (o.login(user, pass)) {
                                    found = o;
                                    break;
                                }
                            }
                            if (found != null) {
                                int orgOp;
                                do {
                                    System.out.println("\n-- Organizer Menu --");
                                    System.out.println("1. My Events\n2. Show Attendees\n3. Add Event\n0. Logout");
                                    orgOp = input.nextInt(); input.nextLine();
                                    switch (orgOp) {
                                        case 1 -> found.showMyEvents();
                                        case 2 -> found.showAttendeesForMyEvents();
                                        case 3 -> {
                                            System.out.print("Event ID: ");
                                            String eid = input.nextLine();
                                            System.out.print("Title: ");
                                            String title = input.nextLine();
                                            admin.listCategories();
                                            System.out.print("Choose category ID: ");
                                            Category cat = admin.findCategoryById(input.nextLine());
                                            System.out.print("Enter room index (0 or 1): ");
                                            int rIndex = input.nextInt();
                                            System.out.print("Price: ");
                                            double price = input.nextDouble(); input.nextLine();
                                            Event e = new Event(eid, title, cat, rooms[rIndex], found, price);
                                            found.addEvent(e);
                                        }
                                    }
                                } while (orgOp != 0);
                            } else System.out.println("❌ Invalid login.");
                        }
                        case 3 -> {
                            // Login as Attendee
                            System.out.print("Enter username: ");
                            String user = input.nextLine();
                            System.out.print("Enter password: ");
                            String pass = input.nextLine();
                            Attendee found = null;
                            for (Attendee a : attendees) {
                                if (a.login(user, pass)) {
                                    found = a;
                                    break;
                                }
                            }
                            if (found != null) {
                                System.out.println("\nWelcome " + found.getUsername());
                                System.out.println("Balance: $" + found.getBalance());
                                System.out.println("Available Events:");
                                Event[] allEvents = organizer.getAllEvents();
                                for (int i = 0; i < allEvents.length; i++) {
                                    if (allEvents[i] != null) System.out.println((i + 1) + ". " + allEvents[i]);
                                }
                                System.out.print("Enter event number to choose: ");
                                int idx = input.nextInt() - 1;
                                Event selected = found.chooseEvent(allEvents, idx);
                                input.nextLine();
                                System.out.print("Buy ticket? (yes/no): ");
                                if (input.nextLine().equalsIgnoreCase("yes")) {
                                    found.buyTicket(selected);
                                    System.out.println("New Balance: $" + found.getBalance());
                                }
                            } else System.out.println("❌ Invalid login.");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("\n-- Register As --");
                    System.out.println("1. Admin");
                    System.out.println("2. Organizer");
                    System.out.println("3. Attendee");
                    System.out.print("Choice: ");
                    int regChoice = input.nextInt(); input.nextLine();

                    switch (regChoice) {
                        case 1 -> {
                            System.out.print("Username: ");
                            String user = input.nextLine();
                            System.out.print("Password: ");
                            String pass = input.nextLine();
                            System.out.print("Date of Birth (yyyy-mm-dd): ");
                            LocalDate dob = LocalDate.parse(input.nextLine());
                            System.out.print("Role: ");
                            String role = input.nextLine();
                            System.out.print("Working Hours: ");
                            int hours = input.nextInt(); input.nextLine();
                            admin = new Admin(user, pass, dob, role, hours);
                            System.out.println("✅ Admin registered.");
                        }
                        case 2 -> {
                            System.out.print("Username: ");
                            String user = input.nextLine();
                            System.out.print("Password: ");
                            String pass = input.nextLine();
                            System.out.print("Date of Birth (yyyy-mm-dd): ");
                            LocalDate dob = LocalDate.parse(input.nextLine());
                            organizers.add(new Organizer(user, pass, dob));
                            System.out.println("✅ Organizer registered.");
                        }
                        case 3 -> {
                            System.out.print("Username: ");
                            String user = input.nextLine();
                            System.out.print("Password: ");
                            String pass = input.nextLine();
                            System.out.print("Date of Birth (yyyy-mm-dd): ");
                            LocalDate dob = LocalDate.parse(input.nextLine());
                            System.out.print("Balance: ");
                            double balance = input.nextDouble(); input.nextLine();
                            System.out.print("Address: ");
                            String address = input.nextLine();
                            System.out.print("Gender (MALE/FEMALE): ");
                            Gender gender = Gender.valueOf(input.nextLine().toUpperCase());
                            System.out.print("Interests (comma separated): ");
                            String[] interests = input.nextLine().split(",");
                            attendees.add(new Attendee(user, pass, dob, balance, address, gender, interests));
                            System.out.println("✅ Attendee registered.");
                        }
                    }
                }
            }
        } while (choice != 0);


        input.close();
        System.out.println("Exiting system. Goodbye!");
    }
}
