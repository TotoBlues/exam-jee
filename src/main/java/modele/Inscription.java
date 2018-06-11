package modele;

import java.util.Date;

public class Inscription {

    private String fname;
    private String lname;
    private String civility;
    private String urgent;
    private Date date;

    public Inscription(String fname, String lname, String civility, String urgent) {
        this.fname = fname;
        this.lname = lname;
        this.civility = civility;
        this.urgent = urgent;
        this.date = new Date();
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }
}
