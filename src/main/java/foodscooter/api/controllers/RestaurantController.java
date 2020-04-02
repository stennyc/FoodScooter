package foodscooter.api.controllers;

import foodscooter.model.FoodItem;
import foodscooter.model.Restaurant;
import foodscooter.repositories.JdbcRestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController extends BaseController {
  private JdbcRestaurantsRepository restaurantsRepository;

  @Autowired
  public RestaurantController(JdbcRestaurantsRepository restaurantsRepository) {
    this.restaurantsRepository = restaurantsRepository;
  }

  @GetMapping("/restaurants")
  public List<Restaurant> getAllRestaurants() {
    return restaurantsRepository.getAll();
  }

  @GetMapping("/restaurants/{restaurantId}/menu")
  public List<FoodItem> getMenu(@PathVariable int restaurantId) {
    return restaurantsRepository.getMenu(restaurantId);
  }
}
