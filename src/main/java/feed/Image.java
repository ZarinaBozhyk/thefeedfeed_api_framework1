package feed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {
    @JsonProperty("created_at")
    private String createdAt;
    private String extension;
    private String id;
    private String path;
    private Integer server;
    private String type;
    @JsonProperty("updated_at")
    private String updatedAt;
    private String url;
}
