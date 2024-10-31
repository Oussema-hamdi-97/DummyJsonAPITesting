package oussema.pojoclasses.RecipePOJO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recipe {
    private int id;
    private String name;
    private List<String> ingredients;
    private List<String> instructions;
    private int prepTimeMinutes;
    private int cookTimeMinutes;
    private int servings;
    private String difficulty;
    private String cuisine;
    private int caloriesPerServing;
    private List<String> tags;
    private int userId;
    private String image;
    private double rating;
    private int reviewCount;
    private List<String> mealType;
}
