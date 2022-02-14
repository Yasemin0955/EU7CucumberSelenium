package com.vytrack.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    //no need to explicitly write the constructor it will use from basepage
    @FindBy(xpath = "//a[@href='/calendar/event']/span")
    public WebElement calendarEventUnderActivities;


}
