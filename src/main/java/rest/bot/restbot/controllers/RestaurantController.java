package rest.bot.restbot.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rest.bot.restbot.domain.PersonVO;
import rest.bot.restbot.model.RestaurantResponse;
import rest.bot.restbot.model.RestaurantStatusResponse;
import rest.bot.restbot.services.RestaurantService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
/**
 * Created by Abhishek Raj on 12-Aug-17.
 */

/**
 * This creates REST APIS
 */
@RestController
public class RestaurantController
{


    @Autowired
    RestaurantService restaurantService;


    @ApiOperation(value = "Get All Persons in the Restaurant",
            notes = "List All Persons in the Hotel with their room no", response = RestaurantResponse.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/allPersons", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE})
    public RestaurantResponse getAllPersonsInTheHotel() {
       RestaurantResponse restaurantResponse = new RestaurantResponse();
        List<PersonVO> personVOList = new ArrayList<>();
       try {
           personVOList=
                   restaurantService.getAllPersonsIntheRestaurant();
       }catch (Exception e){
           restaurantResponse.setStatus("failed");
           restaurantResponse.setMessage("Unable to retrieve data");
       }

       restaurantResponse.setMessage("success");
       restaurantResponse.setStatus("success");
       restaurantResponse.setPersonsList(personVOList);
       return restaurantResponse;
    }

    @ApiOperation(value = "Get All Persons in the Restaurant",
            notes = "List All Persons in the Hotel with their room no", response = PersonVO.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/roomNo/{personName}", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE})
    public PersonVO getRoomNoForThePerson(@PathVariable("personName") String personName){
        PersonVO personVO;
            personVO=
                    restaurantService.getRoomNoForThePerson(personName);
        return personVO;
    }


    @ApiOperation(value = "Book Room for the Person",
            notes = "Book Room for the person", response = RestaurantStatusResponse.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/bookRoom", method = RequestMethod.POST, produces = {APPLICATION_JSON_VALUE})
    public RestaurantStatusResponse createRoomForThePerson(@RequestBody PersonVO personVO){
        RestaurantStatusResponse restaurantStatusResponse;
        restaurantStatusResponse= restaurantService.createRoomForThePerson(personVO);
        return restaurantStatusResponse;
    }






}
