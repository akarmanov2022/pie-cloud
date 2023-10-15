package pies;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PieOrder {
  private String deliveryName;
  private String deliveryStreet;
  private String deliveryCity;
  private String deliveryState;
  private String deliveryZip;
  private String ccNumber;
  private String ccExpiration;
  private String ccCVV;

  private List<Pie> pies = new ArrayList<>();

  public void addPie(Pie pie) {
    this.pies.add(pie);
  }
}
