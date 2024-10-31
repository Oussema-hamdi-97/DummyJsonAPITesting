package oussema.pojoclasses.cartPOJO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllCartResponse {
    private List<Carts> carts;
    private int total;
    private int skip;
    private int limit;
}
