package foodscooter.model.users;

import foodscooter.model.UserType;

import java.util.List;

public class Customer extends User {
  private String creditCardNumber;
  private int rewardPoints;
  private List<String> recentPlaces;

  public Customer(int id, String creditCardNumber, int rewardPoints, List<String> recentPlaces) {
    super(id, UserType.CUSTOMER);
    this.creditCardNumber = creditCardNumber;
    this.rewardPoints = rewardPoints;
    this.recentPlaces = recentPlaces;
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public int getRewardPoints() {
    return rewardPoints;
  }

  public void setRewardPoints(int rewardPoints) {
    this.rewardPoints = rewardPoints;
  }

  public List<String> getRecentPlaces() {
    return recentPlaces;
  }

  public void setRecentPlaces(List<String> recentPlaces) {
    this.recentPlaces = recentPlaces;
  }
}
