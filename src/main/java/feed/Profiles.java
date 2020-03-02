package feed;

        import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profiles {
    private String bio;
    @JsonProperty("first_name")
    private String firstName;
    private Integer id;
    private Image image;
    @JsonProperty("last_name")
    private String lastName;
    private Urls urls;
    private String username;
}