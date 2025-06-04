public class Broker {
    private final String name;

    private int age;

    private String sector;

    public Broker(String name, int age, String sector) {
        this.name = name;
        this.age = age;
        this.sector = sector;
    }

    public Broker() {
        this.name = "";
        this.age = 0;
        this.sector = "";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}