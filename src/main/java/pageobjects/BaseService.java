package pageobjects;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class BaseService {
    protected RequestSpecBuilder getBaseRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://api.thefeedfeed.com/api")
                .setContentType(ContentType.JSON);
    }
}
