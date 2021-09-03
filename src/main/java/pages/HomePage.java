package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class HomePage {

    WebDriver driver;
    Actions action;
    WebElement womenMenu;
    WebElement tShirtsMenu;

    public HomePage (WebDriver driver, Actions action) {
        this.action = action;
        this.driver = driver;
    }

    public void find_women_category() {
        this.womenMenu = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"));
    }

    public void hover_women_category() {
        action.moveToElement(this.womenMenu).perform();
    }

    public void find_t_shirts_sub_category() {
        this.tShirtsMenu = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
    }

    public void click_t_shirts_sub_category() {
        this.tShirtsMenu.click();
    }
}
