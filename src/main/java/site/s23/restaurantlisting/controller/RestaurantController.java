package site.s23.restaurantlisting.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.s23.restaurantlisting.dto.RestaurantDTO;
import site.s23.restaurantlisting.service.RestaurantService;

@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {

	@Autowired
	RestaurantService service;
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants() {
		List<RestaurantDTO> restaurants = service.fetchAllRestaurants();
		return new ResponseEntity<List<RestaurantDTO>>(restaurants, HttpStatusCode.valueOf(HttpStatus.SC_OK));
	}
	
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable("id") String restaurantId) {
		RestaurantDTO restaurant = service.fetchRestaurantById(restaurantId);
		return new ResponseEntity<>(restaurant, HttpStatusCode.valueOf(HttpStatus.SC_OK));
	}
	
	@PostMapping("/save")
	public ResponseEntity<RestaurantDTO> addNewRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
		return new ResponseEntity<RestaurantDTO>( service.addNewRestaurant(restaurantDTO), HttpStatusCode.valueOf(HttpStatus.SC_CREATED));
	}
	
}
