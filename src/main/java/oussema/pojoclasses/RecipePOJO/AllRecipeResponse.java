package oussema.pojoclasses.RecipePOJO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllRecipeResponse {
    private List<Recipe> recipes;
    private int total;
    private int skip;
    private int limit;
}
