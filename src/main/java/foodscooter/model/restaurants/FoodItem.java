package foodscooter.model.restaurants;

import java.math.BigDecimal;

public class FoodItem {
  private int id;
  private String name;
  private String category;
  private BigDecimal price;
  private int availability;

  public FoodItem(int id, String name, String category, BigDecimal price, int availability) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.price = price;
    this.availability = availability;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public int getAvailability() {
    return availability;
  }

  public void setAvailability(int availability) {
    this.availability = availability;
  }
}
