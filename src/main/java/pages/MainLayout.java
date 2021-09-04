package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class MainLayout {

    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    WebElement womenCategory, tShirtsCategory, dressesCategory, casualDressesCategory, wElement, cartElement, checkoutElement;

    public MainLayout (WebDriver driver, Actions action, WebDriverWait wait) {
        this.action = action;
        this.driver = driver;
        this.wait = wait;
    }

    public void find_women_category() {
        this.womenCategory = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"));
    }

    public void hover_women_category() {
        action.moveToElement(this.womenCategory).perform();
    }

    public void find_t_shirts_sub_category() {
        this.tShirtsCategory = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
    }

    public void click_t_shirts_sub_category() {
        this.tShirtsCategory.click();
    }

    public void go_to_main_page(){
        this.driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).click();
    }

    public void find_dresses_category() {
        this.dressesCategory = this.driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"));
    }

    public void hover_dresses_category() {
        action.moveToElement(this.dressesCategory).build().perform();
    }

    public void find_casual_dresses_sub_category(){
//        this.wElement = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("submenu-container")));
        this.casualDressesCategory = this.driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]"));
    }

    public void click_casual_dresses_category(){
        this.casualDressesCategory.click();
    }

    public void find_cart_element(){
        this.cartElement = this.driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
    }

    public void hover_cart_element(){
        action.moveToElement(this.cartElement).perform();
    }

    public void find_checkout_element(){
       // this.wElement = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button_order_cart")));
        this.checkoutElement = driver.findElement(By.id("button_order_cart"));
    }

    public void click_checkout_element(){
      //  this.wElement = this.wait.until(ExpectedConditions.elementToBeClickable(By.id("button_order_cart")));
        this.checkoutElement.click();
    }
}
