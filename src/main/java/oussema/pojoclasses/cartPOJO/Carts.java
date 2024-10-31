package oussema.pojoclasses.cartPOJO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Carts {
    private int id;
    private List<CartProducts> products;
    private double total;
    private double discountedTotal;
    private int userId;
    private int totalProducts;
    private int totalQuantity;
}
