package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    Select sizeInput;
    WebElement bigPic, thumb1, thumb2, thumb3, thumb4, quantityPlus, addToCart;

    public ProductPage(WebDriver driver, Actions action, WebDriverWait wait){
        this.driver = driver;
        this.action = action;
        this.wait = wait;
    }

    public void find_all_images_elements(){
        this.bigPic = driver.findElement(By.id("bigpic"));
        this.thumb1 = driver.findElement(By.id("thumb_1"));
        this.thumb2 = driver.findElement(By.id("thumb_2"));
        this.thumb3 = driver.findElement(By.id("thumb_3"));
        this.thumb4 = driver.findElement(By.id("thumb_4"));
    }

    private void check_thumb_and_big_image_src(WebElement thumb, WebElement bigPic){
        String thumbImageName = thumb.getAttribute("src").split("/")[thumb.getAttribute("src").split("/").length - 1];
        String bigPicImageName = bigPic.getAttribute("src").split("/")[thumb.getAttribute("src").split("/").length - 1];
        if (thumbImageName.charAt(0) == bigPicImageName.charAt(0)) {
            System.out.println("image changed successfully");
        } else {
            System.out.println("image changed unsuccessfully");
        }
    }

    public void hover_small_image_and_check_big_image_change(){
        action.moveToElement(this.thumb1).perform();
        this.check_thumb_and_big_image_src(thumb1, bigPic);

        action.moveToElement(this.thumb2).perform();
        this.check_thumb_and_big_image_src(thumb2, bigPic);

        action.moveToElement(this.thumb3).perform();
        this.check_thumb_and_big_image_src(thumb3, bigPic);

        action.moveToElement(this.thumb4).perform();
        this.check_thumb_and_big_image_src(thumb4, bigPic);
    }

    public void find_size_input_element(){
        this.sizeInput = new Select(driver.findElement(By.name("group_1")));
    }

    public void select_m_size(String size_value){
        this.sizeInput.selectByValue(String.valueOf(size_value));
    }

    public void find_quantity_plus_element(){
        this.quantityPlus = driver.findElement(By.className("product_quantity_up"));
    }

    public void click_quantity_plus_element(){
        this.quantityPlus.click();
    }

    public void find_add_to_cart_element(){
        this.addToCart = driver.findElement(By.xpath("//*[@id = 'add_to_cart']/button"));
    }

    public void click_add_to_cart_element(){
        this.addToCart.click();
    }
}
