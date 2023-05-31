package entity.user;

// singleton: User này cũng chỉ cần 1 instance trong ứng dụng
public class User {
    
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;

    private static User user = new User(1, "name default", "email dèault", "address default", "phone default");

    public static User getUserInstance() {
        return this.user;
    }

    private User(int id, String name, String email, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public User cloneInformation() {
        return new User(this.id, this.name, this.email, this.address, this.phone);
    }
    
    // override toString method
    @Override
    public String toString() {
        return "{" +
            "  username='" + name + "'" +
            ", email='" + email + "'" +
            ", address='" + address + "'" +
            ", phone='" + phone + "'" +
            "}";
    }

    // getter and setter
    public String getName() {
        return this.user.name;
    }

    public void setusername(String name) {
        this.user.name = name;
    }

    public String getEmail() {
        return this.user.email;
    }

    public void setEmail(String email) {
        this.user.email = email;
    }

    public String getAddress() {
        return this.user.address;
    }

    public void setAddress(String address) {
        this.user.address = address;
    }

    public String getPhone() {
        return this.user.phone;
    }

    public void setPhone(String phone) {
        this.user.phone = phone;
    }

    public void setId(int id) {
        this.user.id = id;
    }

    public String getId() {
        return this.user.id;
    }
    
}
