package oussema.pojoclasses.LoginPOJO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private int id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String image;
}
