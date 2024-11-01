package oussema.pojoclasses.UserPOJO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllUserResponse {
    private List<User> users;
    private int total;
    private int skip;
    private int limit;

}
