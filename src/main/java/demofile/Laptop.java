package demofile;

import javax.persistence.*;

@Entity
public class Laptop {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int lid;
    private  String brand;
    private int price;

    @ManyToOne
    private Alien alien;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Alien getAlien() {
        return alien;
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
    }
}
