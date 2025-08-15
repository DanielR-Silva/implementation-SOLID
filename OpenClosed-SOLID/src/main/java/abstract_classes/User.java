package abstract_classes;

public abstract class User {
    private final int id;
    private final String name;
    private String contactNumber;

    public User(String name, String contactNumber) {
        this.id = 0;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public User() {
        this.id = 0;
        this.name = "";
        this.contactNumber = "";
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
