import java.security.InvalidParameterException;

public class Account {
    private final String code;
    private String password;
    private Double sale;

    public Account(String code, String password) {
        this.code = code;
        this.sale = 0.0;
        this.password = password;
    }

    public Account() {
        this.code = "";
        this.sale = 0.0;
        this.password = "";
    }

    public String getCode() {
        return this.code;
    }

    public String getPassword() {
        return this.password;
    }

    public Double checkExtract() {
        return this.sale;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void deposit(Double value) {
        if (sale > 0.0) {
            this.sale += value;
        }else {
            throw new InvalidParameterException("Sale must be greater than 0.0");
        }
    }
}