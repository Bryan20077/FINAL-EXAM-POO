package Frais_universitaire;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Frais {
    private int id;
    private String label;
    private double amountDue;
    private Instant deadline;
    private Student student;
    private List<Payment> payments = new ArrayList<>();

    public Frais(int id, String label, double amountDue, Instant deadline, Student student) {
        this.id = id;
        this.label = label;
        this.amountDue = amountDue;
        this.deadline = deadline;
        this.student = student;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public double getTotalPaidUntil(Instant t) {
        return payments.stream()
                .filter(p -> p.getDateTime().isBefore(t) || p.getDateTime().equals(t))
                .mapToDouble(Payment::getAmount)
                .sum();
    }

    public FraiStatus getStatus(Instant t) {
        double totalPaid = getTotalPaidUntil(t);

        if (totalPaid == 0) return FraiStatus.NULL;
        if (totalPaid == amountDue) return FraiStatus.PAID;
        if (totalPaid > amountDue) return FraiStatus.OVERPAID;
        if (totalPaid < amountDue && t.isBefore(deadline)) return FraiStatus.IN_PROGRESS;
        if (totalPaid < amountDue && t.isAfter(deadline)) return FraiStatus.LATE;

        return FraiStatus.NULL;
    }

    public double getAmountDue() { return amountDue; }
    public Instant getDeadline() { return deadline; }
    public Student getStudent() { return student; }
}

