import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Agency {
    private List<Broker> brokers;

    private List<Sale> sales;

   public Agency() {
       this.brokers = new ArrayList<>();
       this.sales = new ArrayList<>();
   }

   public double totalSalesValueByBroker(String brokerName) {
       return sales.stream()
               .filter(sale -> sale.getBroker().getName().equals(brokerName))
               .mapToDouble(Sale::getValue)
               .sum();
   }

   public double calculateTotalCommission(String brokerName) {
       return  sales.stream()
               .filter(sale -> sale.getBroker().getName().equals(brokerName))
               .mapToDouble(Sale::getCommission)
               .sum();
   }

    public void clearSalesRecords() {
        this.sales.clear();
    }

    public void clearBrokersRecords() {
        this.brokers.clear();
    }

   public boolean registerBroker(Broker broker) {
       this.brokers.add(broker);
       return true;
   }

    public boolean registerBroker(List<Broker> brokers) {
        this.brokers.addAll(brokers);
        return true;
    }

   public boolean registerSale(Sale sale) {
       this.sales.add(sale);
       return true;
   }

   public boolean registerSale(List<Sale> sales) {
       this.sales.addAll(sales);
       return true;
   }

   public List<Broker> getBrokers() {
       return this.brokers;
   }

   public Broker getBroker(String brokerName) {
       return brokers.stream()
               .filter(broker -> broker.getName().equals(brokerName))
               .findFirst()
               .orElseThrow(() -> new NoSuchElementException("Broker %s not found".formatted(brokerName)));
   }

   public List<Sale> getSales() {
       return this.sales;
   }

    public double getTotalSalesValue() {
        return sales.stream().mapToDouble(Sale::getValue).sum();
    }
}