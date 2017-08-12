package rest.bot.restbot.model;

/**
 * Created by Abhishek Raj on 12-Aug-17.
 */

import rest.bot.restbot.domain.PersonVO;

import java.util.List;

/**
 * This is the Response class
 */
public class RestaurantResponse {

    String status;
    String message;
    List<PersonVO> personsList;

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

    public List<PersonVO> getPersonsList() {
        return personsList;
    }

    public void setPersonsList(List<PersonVO> personsList) {
        this.personsList = personsList;
    }
}
