package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegistrationPage {
    WebDriver driver;
    WebElement genderInput, firstName, lastName, password, address, city, zipCode,
    phone;
    Select dateMonth, dateDay, dateYear, state;
    Actions action;
    WebDriverWait wait;

    public RegistrationPage(WebDriver driver, WebDriverWait wait, Actions action){
        this.driver = driver;
        this.wait = wait;
        this.action = action;
    }

    public void find_gender_input_and_select(Integer gender){
        // input gender 1:Mr, 2:Mrs
        this.genderInput = this.driver.findElement(By.id("id_gender" + String.valueOf(gender)));
        this.genderInput.click();
    }

    public void find_first_name_field_and_input(String firstName){
        this.firstName = driver.findElement(By.id("customer_firstname"));
        this.firstName.sendKeys(firstName);
    }

    public void find_last_name_field_and_input(String lastName){
        this.lastName = driver.findElement(By.id("customer_lastname"));
        this.lastName.sendKeys(lastName);
    }

    public void find_password_field_and_input(String password){
        this.password = driver.findElement(By.id("passwd"));
        this.password.sendKeys(password);
    }

    public void find_date_of_birth_fields_and_input(int day, int month, int year) {
        this.dateDay = new Select(driver.findElement(By.id("days")));
        this.dateDay.selectByValue(String.valueOf(day));

        this.dateMonth = new Select(this.driver.findElement(By.id("months")));
        this.dateMonth.selectByValue(String.valueOf(month));

        this.dateYear = new Select(this.driver.findElement(By.id("years")));
        this.dateYear.selectByValue(String.valueOf(year));
    }

    public void find_address_field_and_input(String address){
        this.address = this.driver.findElement(By.id("address1"));
        this.address.sendKeys(address);
    }

    public void find_city_field_and_input(String city){
        this.city = this.driver.findElement(By.id("city"));
        this.city.sendKeys(city);
    }

    public void find_state_field_and_input(int state){
        this.state = new Select(this.driver.findElement(By.id("id_state")));
        this.state.selectByValue(String.valueOf(state));
    }

    public void find_zip_code_field_and_input(String zipCode){
        this.zipCode = this.driver.findElement(By.id("postcode"));
        this.zipCode.sendKeys(zipCode);
    }

    public void find_phone_field_and_input(String phone){
        this.phone = this.driver.findElement(By.id("phone_mobile"));
        this.phone.sendKeys(phone);
    }

    public void find_register_button_and_click(){
        this.driver.findElement(By.id("submitAccount")).click();
    }
}
