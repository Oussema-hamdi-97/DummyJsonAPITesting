package oussema.pojoclasses.CartPOJO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProduct {
    private int id;
    private String title;
    private double price;
    private int quantity;
    private double total;
    private double discountPercentage;
    private double discountedTotal;
    private String thumbnail;
}
