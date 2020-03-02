package pageobjects;

import feed.Feeds;

import static io.restassured.RestAssured.given;

public class HomepageService extends BaseService {
    public Feeds getFeeds() {
        return given().
                spec(getBaseRequestSpec().build()).
                queryParam("fields", "*").
                when().
                get("/homepage").
                then().
                statusCode(200)
                .extract()
                .as(Feeds.class);
    }
}
