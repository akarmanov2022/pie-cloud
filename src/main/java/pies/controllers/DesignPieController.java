package pies.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pies.Ingredient;
import pies.Pie;
import pies.PieOrder;

import java.util.List;

import static pies.Ingredient.*;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("pieOrder")
public class DesignPieController {

  @ModelAttribute
  public void addIngredientToModel(Model model) {
    List<Ingredient> ingredients = List.of(
        new Ingredient("FLTO", "ingr1", Type.WRAP),
        new Ingredient("COTO", "ingr2", Type.WRAP),
        new Ingredient("GRBF", "ingr3", Type.PROTEIN),
        new Ingredient("TMTO", "ingr4", Type.PROTEIN),
        new Ingredient("CARN", "ingr5", Type.VEGGIES),
        new Ingredient("LETC", "ingr6", Type.VEGGIES),
        new Ingredient("CHED", "ingr7", Type.CHEESE),
        new Ingredient("JACK", "ingr8", Type.CHEESE),
        new Ingredient("SLSA", "ingr9", Type.SAUCE),
        new Ingredient("SRCR", "ingr10", Type.SAUCE)
    );
    Type[] types = Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(),
          filterByType(ingredients, type));
    }
  }

  @ModelAttribute
  public PieOrder order() {
    return new PieOrder();
  }

  @ModelAttribute
  public Pie pie() {
    return Pie.of();
  }

  @GetMapping
  public String showDesignForm() {
    return "design";
  }

  @PostMapping
  public String processPie(Pie pie,
                           @ModelAttribute PieOrder order) {
    order.addPie(pie);
    log.info("Processing pie: {}", pie);
    return "design";
  }

  private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
    return ingredients.stream()
        .filter(ingredient -> ingredient.type().equals(type))
        .toList();
  }
}
