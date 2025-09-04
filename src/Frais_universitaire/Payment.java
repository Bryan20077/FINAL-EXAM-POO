package Frais_universitaire;

import java.time.Instant;

public abstract class Payment {
    private final int id;
    private final double amount;
    private final Instant dateTime;

    public Payment(int id, double amount, Instant dateTime) {
        this.id = id;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public int getId() { return id; }
    public double getAmount() { return amount; }
    public Instant getDateTime() { return dateTime; }
}

