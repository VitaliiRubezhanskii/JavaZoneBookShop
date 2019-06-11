package ua.rubezhanskii.javabookshop.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="customer")
public class Customer implements Serializable {

    private static final long serial_UID=5L;

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String country;
    private String phoneHome;
    private String phoneMobile;
    private String email;
    private Set<Order> orders;
    private Set<Cart> carts;

    public Customer() {

    }

    public Customer(Integer customerId, String firstName, String lastName, String address, String city, String zip, String country, String phoneHome, String phoneMobile, String email) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.phoneHome = phoneHome;
        this.phoneMobile = phoneMobile;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="customerId" )
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Column(name ="firstName" )
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name ="lastName" )
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name ="address" )
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name ="city" )
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Column(name ="zip" )
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Column(name ="country" )
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name ="phoneHome" )
    public String getPhoneHome() {
        return phoneHome;
    }
    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    @Column(name ="phoneMobile" )
    public String getPhoneMobile() {
        return phoneMobile;
    }
    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    @Column(name ="email" )
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", phoneHome='" + phoneHome + '\'' +
                ", phoneMobile='" + phoneMobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
