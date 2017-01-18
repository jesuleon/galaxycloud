package com.ml.bean;

/**
 * Created by JesusLeon on 18/01/2017.
 */
public class JobResponse {
    public enum Status {
        STARTED, RUNNING, FINISHED
    }

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
