package pageobjects;

import feed.ImageInformation;
import io.restassured.response.ValidatableResponse;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class FeedsService extends BaseService {
    public List<ImageInformation> getImageInformation() {
        ValidatableResponse pieslist = given().
                spec(getBaseRequestSpec().build()).
                queryParam("fields", "*").
                queryParam("fields", "image.*").
                when().
                get("/feeds/child-feeds/33").
                then().
                statusCode(200);
        return Arrays.asList(pieslist.extract().as(ImageInformation[].class));
    }
}
