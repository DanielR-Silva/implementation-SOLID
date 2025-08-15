import abstract_classes.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private final HashMap<Integer,String> mappedAccounts;
    private final List<User> users;
    private final List<Account> accounts;
    private final Scanner scanner = new Scanner(System.in);
    private final Scanner scannerNum = new Scanner(System.in);

    public Bank() {
        this.mappedAccounts = new HashMap<>();
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public void createAccount(User user) {
        int codeAccount = (int) (Math.random() * 10000);

        System.out.println("enter new password: ");
        String password = scanner.nextLine();

        System.out.println("confirm password: ");
        String confirmPassword = scanner.nextLine();

        if (password.equals(confirmPassword)) {
            Account newAccounts = new Account(String.valueOf(codeAccount), password);
            this.accounts.add(newAccounts);
        }else {
            throw new IllegalArgumentException("Passwords do not match");
        }
    }

    public void createUser() {
        int option = 0;
        System.out.println("""
                What kind of person are you? 
                
                1 - Natural Person
                2 - Legal Person
                """);
        option = scannerNum.nextInt();

        User newUser = null;
        switch (option) {
            case 1 : {
                newUser = new NaturalPerson();
                break;
            }
            case 2: {
                newUser = new LegalPerson();
                break;
            }
            default: throw new IllegalArgumentException("Invalid option");
        }
        this.users.add(newUser);
        createAccount(newUser);
    }

    public List<User> getUsers() {
        return this.users;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public HashMap<Integer,String> getMappedAccounts() {
        return this.mappedAccounts;
    }
}