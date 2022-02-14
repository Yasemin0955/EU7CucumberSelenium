package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ContactsStepsDefs {
    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));

        String username=null;
        String password=null;

        if(userType.equals("driver")){
            username=ConfigurationReader.get("driver_username");
            password=ConfigurationReader.get("driver_password");
        }else if(userType.equals("sales manager")){
            username=ConfigurationReader.get("salesmanager_username");
            password=ConfigurationReader.get("salesmanager_password");
        }else if(userType.equals("store manager")){
            username=ConfigurationReader.get("storemanager_username");
            password=ConfigurationReader.get("storemanager_password");
        }
        new LoginPage().login(username,password);

    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        BrowserUtils.waitFor(2);
       List<String> actualMenuOptions= BrowserUtils.getElementsText(new DashboardPage().menuOptions);
        Assert.assertEquals(menuOptions,actualMenuOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualMenuOptions = " + actualMenuOptions);

    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userInfo) {
        BrowserUtils.waitFor(5);
        new LoginPage().login(userInfo.get("username"), userInfo.get("password"));

        String actualName=new DashboardPage().getUserName();
        String expectedName= userInfo.get("firstname")+" "+userInfo.get("lastname");
        Assert.assertEquals(expectedName,actualName);

    }



}
