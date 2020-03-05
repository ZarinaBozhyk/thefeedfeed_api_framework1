package stepsdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import feed.Feeds;
import feed.ImageInformation;
import feed.Profiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageobjects.FeedsService;
import pageobjects.HomepageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MyStepdefs {
    private List<ImageInformation> imageInformations;
    private Feeds feeds;
    private FeedsService feedsService = new FeedsService();
    private HomepageService homepageService = new HomepageService();

    private final static Logger logger = LoggerFactory.getLogger(MyStepdefs.class);

    //<editor-fold desc="When">
    @When("^I get pies recipe information and save it$")
    public void iGetPiesRecipeInformationAndSaveIt() {
        imageInformations = new ArrayList<>(Objects.requireNonNull(feedsService.getImageInformation()));
    }

    @When("^I get My FeedFeed block info and save it$")
    public void iGetMyFeedFeedBlockInfoAndSaveIt() {
        feeds = homepageService.getFeeds();
    }
    //</editor-fold>


    //<editor-fold desc="Then">
    @Then("^I check at least one recipe has rating more than \"([^\"]*)\"$")
    public void iCheckAtLeastOneRecipeHasRatingMoreThan(int rating) {
        ImageInformation imageInformation;
        Assert.assertFalse(imageInformations.isEmpty(), "There is no item found.");
        imageInformation = imageInformations.stream()
                .filter(element -> Double.parseDouble(element.getRating()) > rating)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("There is no item with rating more than '%s'", rating)));
        Assert.assertTrue(Double.parseDouble(imageInformation.getRating()) > rating);
        logger.error("Test error log");
    }

    @Then("^I check at least one recipe has pies:$")
    public void iCheckAtLeastOneRecipeHasPies(List<String> listPies) {
        Assert.assertFalse(imageInformations.isEmpty(), "There is no item found.");
        SoftAssert softAssert = new SoftAssert();
        imageInformations.stream()
                .map(ImageInformation::getName)
                .map(String::trim)
                .forEach(actualName ->
                        softAssert.assertTrue(listPies.contains(actualName), String.format("List does not contain element %s", actualName))
                );
        softAssert.assertAll();
        logger.info(String.format("Got the list of recipes: %s", listPies));
    }

    @Then("^I check username is equal to main url$")
    public void iCheckUsernameIsEqualToMainUrl() {
        List<Profiles> list = feeds.getMyFeedFeedBlock().getProfiles();
        List<String> usernameList = list.stream()
                .map(Profiles::getUsername)
                .collect(Collectors.toList());
        List<String> urlList = list.stream()
                .map(element -> element.getUrls().getMain())
                .collect(Collectors.toList());
        Assert.assertTrue(usernameList.containsAll(urlList), String.format("UsernameList '%s' is not equal to urlList'%s'", usernameList, urlList));
    }

    @Then("^I check date of updated image is equal to created date$")
    public void iCheckDateOfUpdatedImageIsEqualToCreatedDate() {
        List<Profiles> list = feeds.getMyFeedFeedBlock().getProfiles();
        List<String> createdData = list.stream()
                .map(element -> element.getImage().getCreatedAt())
                .collect(Collectors.toList());
        List<String> updatedData = list.stream()
                .map(element -> element.getImage().getUpdatedAt())
                .collect(Collectors.toList());
        Assert.assertTrue(createdData.containsAll(updatedData), String.format("CreatedData '%s' is not equal to createdData'%s'", createdData, updatedData));
        logger.warn("Test warn log");
    }

    @When("^I ask it to say add$")
    public void iAskItToSayAdd() {
    }

    @Given("^I have a calc with numbers$")
    public void iHaveACalcWithNumbers() {
    }

    @Then("^it should answer with add result$")
    public void itShouldAnswerWithAddResult() {
    }

    int a, b,sum;
    @Given("^I have variable a$")
    public void i_have_variable_a()  {
        a = 3;
    }
    @Given("^I have variable b$")
    public void i_have_variable_b()  {
        b = 4;
    }
    @When("^I add a and b$")
    public void i_add_a_and_b() {
        sum = a + b;
    }
    @Then("^I display the sum$")
    public void i_display_the_sum()  {
        System.out.println("Sum is "+sum);
    }
    //</editor-fold>
}