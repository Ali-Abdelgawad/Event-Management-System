/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;



public class Room {
    private int roomNumber;
    private String[] availableHours;

    public Room(int roomNumber, String[] availableHours) {
        this.roomNumber = roomNumber;
        this.availableHours = new String[] {
            "10:00", "11:00", "12:00", "13:00",
            "14:00", "15:00", "16:00", "17:00",
            "18:00", "19:00", "20:00"
        };
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomId() {
        return "Room-" + roomNumber;
    }

    public boolean hasAvailableHours() {
        for (String hour : availableHours) {
            if (hour != null) return true;
        }
        return false;
    }

    public void showAvailableHours() {
        System.out.println("Available hours for Room " + roomNumber + ":");
        for (String hour : availableHours) {
            if (hour != null) {
                System.out.println("- " + hour);
            }
        }
    }

    public boolean reserveHour(String time) {
        for (int i = 0; i < availableHours.length; i++) {
            if (availableHours[i] != null && availableHours[i].equals(time)) {
                availableHours[i] = null;
                System.out.println("✅ Hour " + time + " reserved successfully.");
                return true;
            }
        }
        System.out.println("❌ Hour " + time + " is not available.");
        return false;
    }
}
