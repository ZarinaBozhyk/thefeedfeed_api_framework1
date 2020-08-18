package stepsdef;

import cucumber.api.java.Before;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

/**
 * #Summary:
 * #Author: Zarina_Bozhyk
 * #Author’s Email:
 * #Creation Date: 8/18/2020
 * #Comments:
 */
public class Hooks {
    private boolean isFirstTest=true;

    @Before
    public void before(){
        if(isFirstTest){
            RestAssured.filters(new AllureRestAssured());
            isFirstTest=false;
        }
    }
}
