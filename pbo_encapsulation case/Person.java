public class Person {
    // Private attributes (Encapsulation)
    private String name;
    private String address;

    // Constructor
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // Setter
    public void setAddress(String address) {
        this.address = address;
    }

    // toString sesuai diagram: "name(address)"
    @Override
    public String toString() {
        return name + "(" + address + ")";
    }
}
