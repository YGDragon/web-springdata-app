package web.ygdragon.appspringdata.model;

public enum TaskStatus {

    NOT_STARTED("task not started"),
    IN_PROGRESS("task in progress"),
    COMPLETED("task completed");

    private final String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
