package rest.bot.restbot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rest.bot.restbot.entities.PersonEntity;

import java.util.List;

/**
 * @author Abhishek Raj on 12-Aug-17.
 */
@Repository
public interface RestaurantRepository extends CrudRepository<PersonEntity,Long> {

    List<PersonEntity> findAll();
    PersonEntity findOneByName(String name);
   // List<PersonEntity> findOneByName();

}
