package oussema.pojoclasses.userPOJO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Address {
    private String address;
    private String city;
    private String state;
    private String stateCode;
    private String postalCode;
    private Coordinates coordinates;
    private String country;
}
