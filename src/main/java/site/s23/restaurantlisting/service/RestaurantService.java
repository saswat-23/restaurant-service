package site.s23.restaurantlisting.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.s23.restaurantlisting.dto.RestaurantDTO;
import site.s23.restaurantlisting.entity.Restaurant;
import site.s23.restaurantlisting.repo.RestaurantRepo;
import site.s23.restaurantlisting.utility.RestaurantUtility;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepo restaurantRepo;

	public List<RestaurantDTO> fetchAllRestaurants() {

		List<RestaurantDTO>  restaurantDTOList = null;
		List<Restaurant> restaurantList = restaurantRepo.findAll();
		
		restaurantDTOList = restaurantList.stream().map(restaurant -> {
			RestaurantDTO restaurantDTO = new RestaurantDTO(restaurant.getId(), restaurant.getName(), 
								restaurant.getAddress(), restaurant.getCity(), restaurant.getDescription());
			return restaurantDTO;
		}).collect(Collectors.toList());
		
		return restaurantDTOList;
	}

	public RestaurantDTO fetchRestaurantById(String restaurantId) {
		Restaurant restaurant = restaurantRepo.findById(Integer.parseInt(restaurantId)).get();
		RestaurantDTO restaurantDTO = new RestaurantDTO(restaurant.getId(), restaurant.getName(), 
				restaurant.getAddress(), restaurant.getCity(), restaurant.getDescription());
		return restaurantDTO;
	}

	public RestaurantDTO addNewRestaurant(RestaurantDTO restaurantDTO) {
		Restaurant restaurant = restaurantRepo.save(RestaurantUtility.getRestaurantEntityFromRestaurantDTO(restaurantDTO, new Restaurant()));
		return RestaurantUtility.getRestaurantDTOFromRestaurantEntity(restaurant, new RestaurantDTO());
	}
	
}
