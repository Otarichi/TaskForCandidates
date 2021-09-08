package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class CustomerServicePage {
    WebDriver driver;
    WebElement chooseFile, messageField, sendButton;
    Select subjectHeading, orderReference;
    File testImage = new File("src/main/resources/test.png");

    public CustomerServicePage(WebDriver driver) {
        this.driver = driver;
    }

    public void find_subject_heading_and_select(int headingValue){
        this.subjectHeading = new Select(this.driver.findElement(By.id("id_contact")));
        this.subjectHeading.selectByValue(String.valueOf(headingValue));
    }

    public void find_order_reference_and_select(int referenceIndex){
        this.orderReference = new Select(this.driver.findElement(By.name("id_order")));
        this.orderReference.selectByIndex(referenceIndex);
    }

    public void find_choose_file_element_and_choose(){
        this.chooseFile = this.driver.findElement(By.id("fileUpload"));
        this.chooseFile.sendKeys(testImage.getAbsolutePath());
    }

    public void find_message_text_area_and_input(String message){
        this.messageField = this.driver.findElement(By.id("message"));
        this.messageField.sendKeys(message);
    }

    public void find_send_button_and_click(){
        this.sendButton = this.driver.findElement(By.id("submitMessage"));
        this.sendButton.click();
    }
}
