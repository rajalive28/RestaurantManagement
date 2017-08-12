package rest.bot.restbot.entities;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Abhishek Raj on 12-Aug-17.
 */
@Entity
@Table(name = "rest_person")
public class PersonEntity extends AbstractPersistable<Long>{
    @NotNull
    @NotBlank
    @Column(name="name")
    private String name;

    @Column(name="contact_no")
    private Long contactNo;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public RoomEntity getRoomEntity() {
        return roomEntity;
    }

    public void setRoomEntity(RoomEntity roomEntity) {
        this.roomEntity = roomEntity;
    }
}
