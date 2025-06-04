public enum CommissionRate {
    LOW(0.0,30000.0,0.07),
    MEDIUM(30000.0,50000.0,0.95),
    HIGH(50000.0, Double.MAX_VALUE,0.12);

    private final double min;
    private final double max;
    private final double rate;

    CommissionRate(double min, double max, double rate) {
        this.min = min;
        this.max = max;
        this.rate = rate;
    }

    public static  double getRateFor(double value) {
        for (CommissionRate rate : values()) {
            if (value >= rate.min && value <= rate.max) {
                return rate.rate;
            }
        }
        return 0;
    }
}