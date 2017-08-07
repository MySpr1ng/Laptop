package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Spring on 25.07.2017.
 */

@Entity
@Table (name = "LAPTOPS")
public class Laptop {

    @Id
    @Column(name = "LAPTOP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SERIAL")
    private String serial;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    @Temporal(TemporalType.DATE)
    private Date manufactureDate;

    @Column(name = "PRICE")
    private Double price;
// serial, vendor, model, manufactureDate, price;
    public Laptop() {
    }

    public Laptop(String serial, String vendor, String model, Date manufactureDate, Double price) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" + "laptopID =" + id + " SERIAL= " + serial + " Vendor= " + vendor + " Model= " + model + " ManfDate= " + manufactureDate + " Price= " + price+ "}";
    }
}
