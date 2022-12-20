package entity;

import java.util.Date;

public class Vacation {
    private int id;
    private Personnel personnel;
    private String leaveDate;
    private boolean confirmed;


    public Vacation(int id, Personnel personnel, String leaveDate, boolean confirmed) {
        this.id = id;
        this.personnel = personnel;
        this.leaveDate = leaveDate;
        this.confirmed = confirmed;
    }

    public Vacation(Personnel person, String leaveDate) {
        this.personnel = person;
        this.leaveDate = leaveDate;
    }

    public Vacation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
