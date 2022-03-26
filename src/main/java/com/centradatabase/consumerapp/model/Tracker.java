package com.centradatabase.consumerapp.model;

//import javax.persistence.*;
import org.springframework.data.annotation.Id;

//@Entity
//@Table(name = "Tracker")
public class Tracker {
    @Id
    private String datimCode;
    private String lastUploadDate;

    public Tracker() {
    }

    public String getDatimCode() {
        return datimCode;
    }

    public void setDatimCode(String datimCode) {
        this.datimCode = datimCode;
    }

    public String getLastUploadDate() {
        return lastUploadDate;
    }

    public void setLastUploadDate(String lastUpload) {
        this.lastUploadDate = lastUpload;
    }
}
