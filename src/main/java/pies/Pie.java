package pies;

import lombok.Data;

import java.util.List;

@Data(staticConstructor = "of")
public class Pie {
  private String name;
  private List<Ingredient> ingredients;
}
