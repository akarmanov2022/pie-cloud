package pies;

import lombok.Data;

import java.util.List;

@Data
public final class Pie {
  private String name;
  private List<Ingredient> ingredients;
}
