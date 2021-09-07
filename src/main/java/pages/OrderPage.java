package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderPage {
    WebDriver driver;
    WebElement product1Title, product2Title, procCheckout, emailAddressField, accountCreateButton;

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void find_products_description_titles_and_check(String ...productNames){
        this.product1Title = driver.findElements(By.xpath("//p[@class = 'product-name']/a")).get(0);
        this.product2Title = driver.findElements(By.xpath("//p[@class = 'product-name']/a")).get(1);

        if (product1Title.getAttribute("innerHTML").strip().equals(productNames[1]) && product2Title.getAttribute("innerHTML").strip().equals(productNames[0])){
            System.out.println("all product is in order");
        } else {
            System.out.println("all product is not in order");
        };
    }

    public void find_proceed_to_checkout_element(){
        try {
            this.procCheckout = this.driver.findElement(By.className("standard-checkout"));
            System.out.println("1");
        } catch (NoSuchElementException e) {
            this.procCheckout = this.driver.findElement(By.xpath("//button[@name = 'processAddress']"));
            System.out.println("2");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("3");
        }

    }

    public void click_proceed_to_checkout(){
        this.procCheckout.click();
    }

    public void find_email_address_field(){
        this.emailAddressField = this.driver.findElement(By.id("email_create"));
    }

    public void input_value_in_email_address_field(String email){
        this.emailAddressField.sendKeys(email);
    }

    public void find_create_an_account_button(){
        this.accountCreateButton = driver.findElement(By.id("SubmitCreate"));
    }

    public void click_create_account_button(){
        this.accountCreateButton.click();
    }
}
