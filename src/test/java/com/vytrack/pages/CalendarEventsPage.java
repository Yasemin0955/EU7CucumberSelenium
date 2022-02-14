package com.vytrack.pages;


import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@href='#']")
    public WebElement options;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[2]/input")
    public WebElement selectAllButton;

    @FindBy(xpath = "//td[text()='Testers meeting']")
    public WebElement testersMeeting;
    @FindBy(css = "div.section-content")
    public WebElement testersmeetingContent;

    @FindBy(xpath = "//input[@tabindex='-1']")
    public WebElement numOfRows;
    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']")
    public WebElement viewPageButton;




    public int pageNumber(){
      int pageNumber=Integer.valueOf(Driver.get().findElement(By.xpath("//input[@type='number']")).getAttribute("value")) ;
      return pageNumber;
    }
    public int viewPerPageValue(){
        int value=Integer.parseInt(Driver.get().findElement(By.xpath("(//span[@class='caret'])[9]/..")).getText());
        return value;
    }
    public int noOfTotalRecordings(){
        String numOfRecordings=Driver.get().findElement(By.xpath("//label[text()='Total of 45 records']")).getText();
        String[] recordingsArray=numOfRecordings.split(" ");
        int numOfTotalRecordings=Integer.parseInt(recordingsArray[2]);
        return numOfTotalRecordings;
    }
   public int noOfCalendarEvents() throws InterruptedException {
       BrowserUtils.waitFor(2);
       viewPageButton.click();
       List<WebElement> options = Driver.get().findElements(By.xpath("//a[@class='dropdown-item']"));
       options.get(2).click();
       BrowserUtils.waitFor(2);
       List<WebElement> numOfRows = Driver.get().findElements(By.xpath("//input[@data-role='select-row-cell']"));
       return numOfRows.size();




   }

}
