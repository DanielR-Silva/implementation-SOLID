import java.util.List;
import java.util.Map;

public class FormattedMessages {
    public static void menuOptions(Map<String, Runnable> options) {
        int i = 1;
        System.out.print("Choose an option:");
        for (String optionText : options.keySet()) {
            System.out.printf("%d - %s\n", i++, optionText);
        }
    }

    public static void formattedOutputAllBrokers(List<Broker> brokers) {
        System.out.printf("|%-6S|%-6S|%-6S|", "Name", "Age", "Sector");
        brokers.forEach(broker -> {
            System.out.printf("\n|%-6S|%-6D|%-6S|", broker.getName(), broker.getAge(), broker.getSector());
        });
    }

    public static void formattedOutputAllSales(List<Sale> sales) {
        System.out.printf("|%-6S|%-6S|%-12S|","Value","Date","Responsible Broker");
        sales.forEach(sale -> {
            System.out.printf("\n|%-6.2f|%-6S|%-12S|",sale.getValue(),sale.getValue(),sale.getValue(),sale.getBroker().getName());
        });
    }

    public static void formattedOutputTotalSalesValue(Double salesValue) {
        System.out.printf("\nThe total sales value is: %.2f%", salesValue);
    }

    public static void formattedOutputBrokerTotalSalesAndTotalCommission(String brokerName, Double totalSales, Double commission) {
        System.out.printf("The broker %s, had a total of $%.2f in sales so your total commission is $%.2f", brokerName, totalSales, commission);
    }

    public static void invalidInput() {
        System.out.println("Invalid input!");
    }
}