package oussema.pojoclasses.ProductPOJO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {
    private int id;
    private String title;
    private String description;
    private String category;
    private double price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private List<String> tags;
    private String brand;
    private String sku;
    private int weight;
    private Dimensions dimensions;
    private String warrantyInformation;
    private String shippingInformation;
    private String availabilityStatus;
    private List<Reviews> reviews;
    private String returnPolicy;
    private String minimumOrderQuantity;
    private Meta meta;
    private List<String> images;
    private String thumbnail;

}