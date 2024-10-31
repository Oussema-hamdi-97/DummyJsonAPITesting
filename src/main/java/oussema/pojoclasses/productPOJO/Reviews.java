package oussema.pojoclasses.productPOJO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reviews {
    private int rating;
    private String comment;
    private String date;
    private String reviewerName;
    private String reviewerEmail;
}
