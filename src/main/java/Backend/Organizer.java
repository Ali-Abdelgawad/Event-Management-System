
package Backend;
import java.time.LocalDate;
class Organizer extends User {
    private Event[] events = new Event[10];
    private int eventCount = 0;
    Event[] showMyEvents;
    

    public Organizer(String username, String password, LocalDate dob) {
        super(username, password, dob);
    }

    public void showAvailableRooms(Room[] rooms) {
        System.out.println("\n🕒 Available Rooms:");
        for (Room room : rooms) {
            if (room != null && room.hasAvailableHours()) {
                System.out.println("- " + room.getRoomId());
            }
        }
    }
 public Event[] getAllEvents() {
        Event[] currentEvents = new Event[eventCount];
        for (int i = 0; i < eventCount; i++) {
            currentEvents[i] = events[i];
        }
        return currentEvents;
    }
    public Event showMyEvents() {
        System.out.println("\n📋 My Events:");
        for (int i = 0; i < eventCount; i++) {
            System.out.println("- " + events[i]);
        }
        return null;
    }

    public void showAttendeesForMyEvents() {
        System.out.println("\n👥 Attendees for My Events:");
        for (int i = 0; i < eventCount; i++) {
            System.out.println("Event: " + events[i].getTitle());
            events[i].printAttendees();
        }
    }

    public void addEvent(Event event) {
        if (eventCount < events.length) {
            events[eventCount++] = event;
            System.out.println("✅ Event added: " + event.getTitle());
        } else {
            System.out.println("❌ Cannot add more events.");
        }
    }

    public void updateEvent(String id, Event updatedEvent) {
        for (int i = 0; i < eventCount; i++) {
            if (events[i].getId().equals(id)) {
                events[i] = updatedEvent;
                System.out.println("✅ Event updated.");
                return;
            }
        }
        System.out.println("❌ Event not found.");
    }

    public void deleteEvent(String id) {
        for (int i = 0; i < eventCount; i++) {
            if (events[i].getId().equals(id)) {
                events[i] = events[eventCount - 1];
                events[--eventCount] = null;
                System.out.println("✅ Event deleted.");
                return;
            }
        }
        System.out.println("❌ Event not found.");
    }
}

