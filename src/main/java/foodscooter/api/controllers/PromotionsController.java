package foodscooter.api.controllers;

import foodscooter.model.Promotion;
import foodscooter.repositories.JdbcPromotionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class PromotionsController extends BaseController{
  private final JdbcPromotionsRepository promotionsRepository;

  @Autowired
  public PromotionsController(JdbcPromotionsRepository promotionsRepository) {
    this.promotionsRepository = promotionsRepository;
  }

  @GetMapping("/promotions")
  public Collection<Promotion> getPromotions() {
    return promotionsRepository.getPromotions();
  }

  @PostMapping("/promotions")
  public ResponseEntity<?> addPromotion(@RequestBody Promotion promotion) {
    System.out.println("Add");
    promotionsRepository.addPromotion(promotion);
    return ResponseEntity.ok().build();
  }

  @PatchMapping("/promotions/{promotionId}")
  public ResponseEntity<?> updatePromotion(
    @PathVariable int promotionId,
    @RequestBody Promotion promotion
  ) {
    promotionsRepository.updatePromotion(promotionId, promotion);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/promotions/batch-removal")
  public ResponseEntity<?> removePromotions(@RequestBody List<Integer> promotionIds) {
    promotionsRepository.removePromotions(promotionIds);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/restaurants/{restaurantId}/promotions")
  public Collection<Promotion> getRestaurantPromotions(
    @PathVariable int restaurantId
  ) {
    return promotionsRepository.getPromotionsForRestaurant(restaurantId);
  }

  @PostMapping("/restaurants/{restaurantId}/promotions")
  public ResponseEntity<?> addRestaurantPromotion(
    @PathVariable int restaurantId,
    @RequestBody Promotion promotion
  ) {
    promotionsRepository.addRestaurantPromotion(restaurantId, promotion);
    System.out.println("adding");
    return ResponseEntity.ok().build();
  }

  @PatchMapping("/restaurants/{restaurantId}/promotions/{promotionId}")
  public ResponseEntity<?> updateRestaurantPromotion(
    @PathVariable int restaurantId,
    @PathVariable int promotionId,
    @RequestBody Promotion promotion
  ) {
    promotionsRepository.updateRestaurantPromotion(restaurantId, promotionId, promotion);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/restaurants/{restaurantId}/promotions/batch-removal")
  public ResponseEntity<?> removeRestaurantPromotions(
    @PathVariable int restaurantId,
    @RequestBody List<Integer> promotionIds
  ) {
    promotionsRepository.removeRestaurantPromotions(restaurantId, promotionIds);
    return ResponseEntity.ok().build();
  }
}
