package rest.bot.restbot.domain;

/**
 * Created by Abhishek Raj on 12-Aug-17.
 */
public class PersonVO {

    private String exists;
    private String name;
    private Integer roomNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getExists() {
        return exists;
    }

    public void setExists(String exists) {
        this.exists = exists;
    }
}
