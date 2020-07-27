package demofile;

import javax.persistence.Embeddable;

/*
We do not want this table seperately. We just want to embbed this table in ALien table.
        Suppose my name is big and have fname,mname and last name. So wither i need to create the seperate
        feild in my main table for fname,mname & lastname.
        To avoid this i can create a class which will have these 3 fields. Then in my main entity table class
        i will have the object of that class.
        So point here is we just want table of main Alien class which has id name and color, we do not want
        seperate table for AlienName class which will have f,m,lname. We just want that AlienName table to be
        embedded in Alien table. So in AlienName table we have used @Embeddable.
         */

@Embeddable
public class AlienName {

    private String fname;
    private String lname;
    private String mname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Override
    public String toString() {
        return "AlienName{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", mname='" + mname + '\'' +
                '}';
    }
}
