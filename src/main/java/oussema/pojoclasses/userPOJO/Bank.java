package oussema.pojoclasses.userPOJO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Bank {
    private String cardExpire;
    private String cardNumber;
    private String cardType;
    private String currency;
    private String iban;

}
