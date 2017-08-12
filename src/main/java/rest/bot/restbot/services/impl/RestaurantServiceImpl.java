package rest.bot.restbot.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.bot.restbot.domain.PersonVO;
import rest.bot.restbot.entities.PersonEntity;
import rest.bot.restbot.entities.RoomEntity;
import rest.bot.restbot.model.RestaurantStatusResponse;
import rest.bot.restbot.repository.RestaurantRepository;
import rest.bot.restbot.services.RestaurantService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abhishek Raj on 12-Aug-17.
 */
@Component
public class RestaurantServiceImpl implements RestaurantService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantServiceImpl.class);
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<PersonVO> getAllPersonsIntheRestaurant() {
        /**
         * Here I am trying to set the response from entity to the VO I need to send
         */
        /**
         * The conventional method
         */
//        List<PersonEntity> personEntities =restaurantRepository.findAll();
//        List<PersonVO> personVOS =new ArrayList<>();
//        for (PersonEntity personEntity: personEntities) {
//            PersonVO personVO = new PersonVO();
//            personVO.setName(personEntity.getName());
//            personVO.setRoomNo(personEntity.getRoomEntity().getRoomNo());
//            personVOS.add(personVO);
//        }
        /**
         * The Java8 way
         */
        List<PersonVO> personVOS=
        restaurantRepository.findAll().stream().map(personEntity -> {
            PersonVO personVO = new PersonVO();
            personVO.setName(personEntity.getName());
            personVO.setRoomNo(personEntity.getRoomEntity().getRoomNo());
            personVO.setExists("IN");
            return personVO;
        }).collect(Collectors.toList());

        return personVOS;
    }

    @Override
    public PersonVO getRoomNoForThePerson(String personName) {
        PersonVO personVO= new PersonVO();
        PersonEntity personEntity=restaurantRepository.findOneByName(personName);
        if(null==personEntity){
            personVO.setExists("NA");
            return personVO;
        }
        personVO.setName(personEntity.getName());
        personVO.setRoomNo(personEntity.getRoomEntity().getRoomNo());
        personVO.setExists("IN");
        return personVO;
    }

    @Override
    public RestaurantStatusResponse createRoomForThePerson(PersonVO personVO) {

        RestaurantStatusResponse  restaurantStatusResponse=
                new RestaurantStatusResponse();
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personVO.getName());
        RoomEntity roomEntity  = new RoomEntity();
        roomEntity.setRoomNo(personVO.getRoomNo());
        personEntity.setRoomEntity(roomEntity);
        try {
            restaurantRepository.save(personEntity);
            restaurantStatusResponse.setMessage("success");
            restaurantStatusResponse.setStatus("success");
        }catch (Exception e){
            LOGGER.error("Error in booking"+ e);
            restaurantStatusResponse.setStatus("failed");
            restaurantStatusResponse.setMessage("failed to create room booking");
        }

        return restaurantStatusResponse;
    }
}
