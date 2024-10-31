package oussema.pojoclasses.productPOJO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllProductResponse {
    private List<Products> products;
    private int total;
    private int skip;
    private int limit;

}
