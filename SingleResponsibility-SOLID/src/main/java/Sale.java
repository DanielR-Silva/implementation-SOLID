public class Sale {
    private final double value;

    private final Broker broker;

    private final String saleDate;

    public Sale(double value, Broker broker, String saleDate) {
        this.value = value;
        this.broker = broker;
        this.saleDate = saleDate;
    }

    public Sale() {
        this.value = 0;
        this.broker = null;
        this.saleDate = "";
    }

    public double getValue() {
        return value;
    }

    public Broker getBroker() {
        return broker;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public double getCommission() {
        return this.value * CommissionRate.getRateFor(this.value);
    }
}