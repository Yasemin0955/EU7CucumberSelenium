package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationMenuStepDefs {
    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_Fleet_Vehicles() {
        System.out.println("navigates to vehicles");
    }

    @Then("the title should be Vehicles")
    public void the_title_should_be_Vehicles() {
        System.out.println("Title matching");
    }
    @When("the user navigates to Marketing, Campaigns")
    public void the_user_navigates_to_Marketing_Campaigns() {
        System.out.println("Navigates to Campaign");
    }
    @Then("the title should be Campaigns")
    public void the_title_should_be_Campaigns() {
        System.out.println("Title is matching");
    }


    @When("the user navigates to Activities, Calendar Events")
    public void the_user_navigates_to_Activities_Calendar_Events() {
        System.out.println("Navigates to Calendar events");
    }

    @Then("the title should be Calendar Events")
    public void the_title_should_be_Calendar_Events() {
        System.out.println("Title is matching");

    }
    @When("the user navigates to {string} ,{string}")
    public void the_user_navigates_to(String tab, String module) {
        new DashboardPage().navigateToModule(tab, module);

    }
    @Then("default page should be {int}")
    public void default_page_should_be(Integer expectedPageNum) {

        ContactsPage contactsPage=new ContactsPage();
       BrowserUtils.waitForVisibility(contactsPage.pageNumber,5);
        Integer actualPageNum=Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));
        Assert.assertEquals(expectedPageNum,actualPageNum);

    }



}
