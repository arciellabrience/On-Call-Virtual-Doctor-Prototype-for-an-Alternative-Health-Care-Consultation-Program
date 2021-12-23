package ph.edu.dlsu;

public class PPhysical {
    private double total1;
    private double total2;
    private double total3;

    public double overallTotal(double total1, double total2) {
        this.total1 = total1;
        this.total2 = total2;

        return total1 + total2;
    }

    public double overallTotal(double total1, double total2, double total3) {
        this.total1 = total1;
        this.total2 = total2;
        this.total3 = total3;

        return total1 + total2 + total3;
    }
}