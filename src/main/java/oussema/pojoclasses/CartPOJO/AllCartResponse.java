package oussema.pojoclasses.CartPOJO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllCartResponse {
    private List<Cart> carts;
    private int total;
    private int skip;
    private int limit;
}
