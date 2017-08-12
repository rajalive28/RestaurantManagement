package rest.bot.restbot.entities;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Abhishek Raj on 12-Aug-17.
 */
@Entity
@Table(name = "rest_room")
public class RoomEntity extends AbstractPersistable<Long> {

    @NotNull
    @Column(name = "room_no")
    private  Integer roomNo;

    @Column(name="floor")
    private  String  floor;

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
