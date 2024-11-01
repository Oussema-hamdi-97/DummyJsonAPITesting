package oussema.pojoclasses.CartPOJO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
    private int id;
    private List<CartProduct> products;
    private double total;
    private double discountedTotal;
    private int userId;
    private int totalProducts;
    private int totalQuantity;
}
