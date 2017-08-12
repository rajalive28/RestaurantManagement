package rest.bot.restbot.services;

import org.springframework.stereotype.Service;
import rest.bot.restbot.domain.PersonVO;
import rest.bot.restbot.model.RestaurantStatusResponse;

import java.util.List;

/**
 * @author Abhishek Raj
 */
@Service
public interface RestaurantService {

    List<PersonVO> getAllPersonsIntheRestaurant();

    PersonVO getRoomNoForThePerson(String personName);

    RestaurantStatusResponse createRoomForThePerson(PersonVO personVO);


}
