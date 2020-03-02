package feed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageInformation {
    @JsonProperty("created_at")
    private String createdAt;
    String description;
    String name;
    String rating;
    @JsonProperty("updated_at")
    private String updatedAt;
}