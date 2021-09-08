package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CategoryPage {
    WebDriver driver;
    Actions action;
    WebElement productMainElement, moreButtonElement, addToCart;

    public CategoryPage(WebDriver driver, Actions action){
        this.driver = driver;
        this.action = action;
    }

    public void find_product_main_element(){
        this.productMainElement = driver.findElement(By.className("ajax_block_product"));
    }

    public void hover_product_main_element(){
        action.moveToElement(this.productMainElement).perform();
    }

    public void find_more_button_element(){
        this.moreButtonElement = productMainElement.findElement(By.className("lnk_view"));
    }

    public void click_more_button_element(){
        this.moreButtonElement.click();
    }

    public void find_add_to_cart_button(){
        this.addToCart = this.driver.findElement(By.className("ajax_add_to_cart_button"));
    }

    public void click_add_to_cart_button() {
        this.addToCart.click();
    }
}
