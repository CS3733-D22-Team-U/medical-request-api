package edu.wpi.cs3733.D22.teamU.Location;

public class DefaultLocation {
    private String ID;
    public DefaultLocation(String ID){
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString(){
        return ID;
    }
}
