package Frais_universitaire;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

public class Statistics {
    public static List<Frais> getLateFees(List<Frais> fees, Instant t) {
        if (fees == null || t == null) return Collections.emptyList();
        return fees.stream()
                .filter(f -> f.getStatus(t) == FraiStatus.LATE)
                .toList();
    }

    public static double getTotalMissingFees(List<Frais> fees, Instant t) {
        if (fees == null || t == null) return 0.0;
        return fees.stream()
                .filter(f -> f.getStatus(t) == FraiStatus.LATE)
                .mapToDouble(f -> f.getAmountDue() - f.getTotalPaidUntil(t))
                .sum();
    }

    public static double getTotalPaidByStudent(Student student, List<Frais> fees, Instant t) {
        if (student == null || fees == null || t == null) return 0.0;
        return fees.stream()
                .filter(f -> f.getStudent().equals(student))
                .mapToDouble(f -> f.getTotalPaidUntil(t))
                .sum();
    }
}

