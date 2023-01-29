package edu.javacourse.studentorder.domain.register;

public class CityRegisterResponse {
    private boolean registered;
    private boolean temporal;

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public Boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }
}
