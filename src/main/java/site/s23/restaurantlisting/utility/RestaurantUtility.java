package site.s23.restaurantlisting.utility;

import site.s23.restaurantlisting.dto.RestaurantDTO;
import site.s23.restaurantlisting.entity.Restaurant;

public class RestaurantUtility {

	
		public static Restaurant getRestaurantEntityFromRestaurantDTO(final RestaurantDTO restaurantDTO, Restaurant restaurantEntity) {
			restaurantEntity = new Restaurant(restaurantDTO.getId(), restaurantDTO.getName(), 
					restaurantDTO.getAddress(), restaurantDTO.getCity(), restaurantDTO.getDescription());
			return restaurantEntity; 
		}
	
		public static RestaurantDTO getRestaurantDTOFromRestaurantEntity(final Restaurant restaurant, RestaurantDTO restaurantDTO) {
			restaurantDTO = new RestaurantDTO(restaurant.getId(), restaurant.getName(), 
					restaurant.getAddress(), restaurant.getCity(), restaurant.getDescription());
			return restaurantDTO; 
		}
		
}
