/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

public class Wallet {
    private double balance;
    private double amount;

    public Wallet() {
        this.balance = 0;
        this.amount = 0;
    }

    public Wallet(double balance) {
        this.balance = balance;
        this.amount = 0;
    }

    public void addAmount() {
        balance += amount;
    }

    public boolean deductAmount() {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}