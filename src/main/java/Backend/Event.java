
package Backend;



public class Event {
    private String id;
    private String title;
    private Category category;
    private Room room;
    private Organizer organizer;
    private double price;
    private Attendee[] attendees = new Attendee[20];
    private int attendeeCount = 0;
    int length;

    public Event(String id, String title, Category category, Room room, Organizer organizer, double price) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.room = room;
        this.organizer = organizer;
        this.price = price;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public Category getCategory() { return category; }
    public Room getRoom() { return room; }
    public Organizer getOrganizer() { return organizer; }
    public double getPrice() { return price; }

    public void setTitle(String title) { this.title = title; }
    public void setCategory(Category category) { this.category = category; }
    public void setRoom(Room room) { this.room = room; }
    public void setPrice(double price) { this.price = price; }

    public boolean addAttendee(Attendee a) {
        if (attendeeCount < attendees.length) {
            attendees[attendeeCount++] = a;
            return true;
        }
        return false;
    }

    public void printAttendees() {
        if (attendeeCount == 0) {
            System.out.println("No attendees yet.");
        } else {
            for (int i = 0; i < attendeeCount; i++) {
                System.out.println("- " + attendees[i].getUsername());
            }
        }
    }

    @Override
    public String toString() {
        return title + " Category: " + category.getName() + "  Room: " + room.getRoomId() + " | Price: $" + price;
    }
}
