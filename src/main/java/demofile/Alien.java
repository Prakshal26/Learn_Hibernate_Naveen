package demofile;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Alien {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

   // @Transient
   //String color // @Transient //If we do not want to create this field in table. Just for coding we want this and do not
     //want in table then use Transint.


     /*
        Suppose my name is big and have fname,mname and last name. So wither i need to create the seperate
        feild in my main table for fname,mname & lastname.
        To avoid this i can create a class which will have these 3 fields. Then in my main entity table class
        i will have the object of that class.
        So point here is we just want table of main Alien class which has id name and color, we do not want
        seperate table for AlienName class which will have f,m,lname. We just want that AlienName table to be
        embedded in Alien table. So in AlienName table we have used @Embeddable.
         */

    //AlienName name;

    private String aname;

    /*
    We know one Alien has many laptop associated with it. So when we will fetch one alien passing it id it
    will not show the laptops associated with it. If we want to show the laptop associated with alien then
    we need to set fetch type as eager. By default fetch type is LAZY i.e it will not show laptop
    associated with Alien.
     */

    @OneToMany(mappedBy = "alien", fetch = FetchType.EAGER)
    private Collection<Laptop> laps = new ArrayList<Laptop>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return aname;
    }

    public void setName(String aname) {
        this.aname = aname;
    }

    public Collection<Laptop> getLaps() {
        return laps;
    }

    public void setLaps(Collection<Laptop> laps) {
        this.laps = laps;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + aname + '\'' +
                '}';
    }
}
