package rest.bot.restbot.model;

/**
 * @author Abhishek Raj on 12-Aug-17.
 */
public class RestaurantStatusResponse {
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
