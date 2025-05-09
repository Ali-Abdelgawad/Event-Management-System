
package Backend;
import java.time.LocalDate;

class Attendee extends User {
    private double balance;
    private String address;
    private Gender gender;
    private String[] interests;

    public Attendee(String username, String password, LocalDate dob, double balance, String address, Gender gender, String[] interests) {
        super(username, password, dob);
        this.balance = balance;
        this.address = address;
        this.gender = gender;
        this.interests = interests;
    }


    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public boolean deductBalance(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    public String[] getInterests() {
        return interests;
    }
public Event chooseEvent(Event[] events, int index) {
        if (index >= 0 && index < events.length && events[index] != null) {
            Event selected = events[index];
            System.out.println("📌 You have chosen: " + selected.getTitle());
            return selected;
        } else {
            System.out.println("❌ Invalid event selection.");
            return null;
        }
    }
    public void buyTicket(Event event) {
        double price = event.getPrice();
        if (deductBalance(price)) {
            event.addAttendee(this);
            System.out.println("🎟️ Ticket purchased successfully for " + event.getTitle());
        } else {
            System.out.println("❌ Not enough balance to buy the ticket.");
        }
    }

    Event chooseEvent(Event allEvents, int idx) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

