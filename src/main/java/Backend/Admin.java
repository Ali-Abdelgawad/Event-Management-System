
package Backend;

import java.time.LocalDate;
    
public class Admin extends User {
    private String role;
    private int workingHours;
    private Category[] categories = new Category[10];
    private int categoryCount = 0;

    public Admin(String username, String password, LocalDate dob, String role, int hours) {
        super(username, password, dob);
        this.role = role;
        this.workingHours = hours;
    }

    public String getRole() {
        return role;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void addRoom(Room[] rooms, Room newRoom) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null) {
                rooms[i] = newRoom;
                System.out.println("✅ Room added: " + newRoom.getRoomId());
                return;
            }
        }
        System.out.println("❌ No space to add more rooms.");
    }

    public void showAllRooms(Room[] rooms) {
        System.out.println("\n🏢 Rooms:");
        for (Room room : rooms) {
            if (room != null) {
                System.out.println("- Room ID: " + room.getRoomId());
            }
        }
    }

    public void showAllEvents(Event[] events) {
        System.out.println("\n📅 Events:");
        for (Event event : events) {
            if (event != null) {
                System.out.println("- " + event);
            }
        }
    }

    public void showAllAttendees(Attendee[] attendees) {
        System.out.println("\n👥 Attendees:");
        for (Attendee attendee : attendees) {
            if (attendee != null) {
                System.out.println("- " + attendee.getUsername());
            }
        }
    }

    public void showAllOrganizers(Organizer[] organizers) {
        System.out.println("\n🎙️ Organizers:");
        for (Organizer organizer : organizers) {
            if (organizer != null) {
                System.out.println("- " + organizer.getUsername());
            }
        }
    }

    public void dashboard(Room[] rooms, Event[] events, Attendee[] attendees, Organizer[] organizers) {
        showAllRooms(rooms);
        showAllEvents(events);
        showAllAttendees(attendees);
        showAllOrganizers(organizers);
    }

    public void addCategory(Category category) {
        if (categoryCount < categories.length) {
            categories[categoryCount++] = category;
            System.out.println("✅ Category added: " + category.getName());
        } else {
            System.out.println("❌ Cannot add more categories.");
        }
    }

    public void updateCategory(String id, String newName) {
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].getId().equals(id)) {
                categories[i].setName(newName);
                System.out.println("✅ Category updated.");
                return;
            }
        }
        System.out.println("❌ Category not found.");
    }
public Category findCategoryById(String id) {
    for (int i = 0; i < categoryCount; i++) {
        if (categories[i].getId().equals(id)) {
            return categories[i];
        }
    }
    System.out.println("❌ Category not found.");
    return null;
}

    public void deleteCategory(String id) {
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].getId().equals(id)) {
                categories[i] = categories[categoryCount - 1];
                categories[--categoryCount] = null;
                System.out.println("✅ Category deleted.");
                return;
            }
        }
        System.out.println("❌ Category not found.");
    }

    public void listCategories() {
        System.out.println("\n📂 Categories:");
        for (int i = 0; i < categoryCount; i++) {
            System.out.println("- " + categories[i].getName());
            
        }
        
    }

    
}
