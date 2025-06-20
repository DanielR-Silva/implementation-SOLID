import java.util.*;

public class Main {
    static Scanner scannerNum = new Scanner(System.in);
    static Scanner scannerText = new Scanner(System.in);
    static Agency agency = new Agency();

    public static void main(String[] args) {
        agency.registerBroker(List.of(
                new Broker("David", 30, "Sales"),
                new Broker("Robert", 33, "Sales"),
                new Broker("Miguel", 27, "Sales"),
                new Broker("Jhonny", 25, "Sales"),
                new Broker("Paul",36,"Sales")
        ));
        showMenuOptions();
    }

    static void showMenuOptions() {
        Map<String, Runnable> options = new LinkedHashMap<>();
        options.put("Register a new broker", Main::registerBroker);
        options.put("Register a new sale", Main::registerSale);
        options.put("List all brokers", () -> {
            FormattedMessages.formattedOutputAllBrokers(agency.getBrokers());
            Utils.delay(1000);
            showMenuOptions();
            });
        options.put("Check sales", () -> {
            FormattedMessages.formattedOutputAllSales(agency.getSales());
        });
        options.put("Check total sales value", () -> {
            FormattedMessages.formattedOutputTotalSalesValue(agency.getTotalSalesValue());
        });
        options.put("Check commission for all sales by broker", Main::CheckCommissionForAllSalesByBroker);
        options.put("Clear all sales records", agency::clearSalesRecords);

        List<String> optionsList = options.keySet().stream().toList();

        int chooseOption = 0;
        do {
            FormattedMessages.menuOptions(options);
            chooseOption = scannerNum.nextInt();


            if (chooseOption < 1 || chooseOption > options.size()) {
                FormattedMessages.invalidInput();
            } else {
                options.get(optionsList.get(chooseOption - 1)).run();
            }
        } while (chooseOption == 0);
    }

    static void registerBroker() {
        boolean registered = false;

        System.out.println("""
                Register a new broker
                Enter name:
                """);
        String brokerName = scannerText.nextLine();

        System.out.println("Enter age:");
        int brokerAge = scannerNum.nextInt();

        System.out.println("Enter sector:");
        String brokerSector = scannerText.nextLine();

        registered = agency.registerBroker(new Broker(brokerName,brokerAge,brokerSector));
        if(registered) System.out.println("Broker registered!");
        Main.showMenuOptions();
    }

    static void registerSale() {
        boolean registered = false;

        while (!registered) {
            try {
                System.out.println("""
                Register a new sale
                Enter value:
                """);
                double saleValue = scannerNum.nextDouble();

                System.out.println("Enter broker name:");
                Broker broker = agency.getBroker(scannerText.nextLine());

                System.out.println("Enter date:");
                String saleDate = scannerText.nextLine();

                registered = agency.registerSale(new Sale(saleValue,broker,saleDate));
                if (registered) System.out.println("Registered sale successfully!");

            } catch (NoSuchElementException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.print("Do you want to try again? (y/n): ");
                String answer = scannerText.nextLine().trim().toLowerCase();
                registered = !answer.equals("y");
            }
        }
        Main.showMenuOptions();
    }

    static void CheckCommissionForAllSalesByBroker() {
        boolean found = false;
        while (!found) {
            try {
                System.out.println("Enter broker name:");
                Broker broker = agency.getBroker(scannerText.nextLine());

                double totalSaleValue = agency.totalSalesValueByBroker(broker.getName());

                double totalCommission = agency.calculateTotalCommission(broker.getName());

                FormattedMessages.formattedOutputBrokerTotalSalesAndTotalCommission(broker.getName(),totalSaleValue,totalCommission);
                found = true;

            }catch (NoSuchElementException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.print("Do you want to try again? (y/n): ");
                String answer = scannerText.nextLine().trim().toLowerCase();
                found = !answer.equals("y");
            }
        }
        Main.showMenuOptions();
    }
}