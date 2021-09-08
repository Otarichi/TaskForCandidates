package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    WebDriverWait wait;
    WebDriver driver;
    WebElement product1Title, product2Title, procCheckout, emailAddressField, accountCreateButton,
            errorWindowCloseButton, agreementCheckbox, payByCheckButton, totalAmount, confirmOrder, customerService;

    public OrderPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
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
        this.procCheckout = this.driver.findElements(By.xpath("//*[text()[contains(., 'Proceed to checkout')]]")).get(1).findElement(By.xpath(".."));
    }

    public void click_proceed_to_checkout(){
        wait.until(ExpectedConditions.visibilityOf(this.procCheckout));
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

    public void find_error_window_close_button(){
        this.errorWindowCloseButton = this.driver.findElement(By.className("fancybox-close"));
    }

    public void click_error_window_close_button(){
        this.errorWindowCloseButton.click();
    }

    public void find_agreement_checkbox(){
        this.agreementCheckbox = this.driver.findElement(By.id("cgv"));
    }

    public void click_agreement_checkbox(){
        this.agreementCheckbox.click();
    }

    public void find_pay_by_check_button(){
        this.payByCheckButton = this.driver.findElement(By.className("cheque"));
    }

    public void click_pay_by_check_button(){
        this.payByCheckButton.click();
    }

    public void find_total_amount_element(){
        this.totalAmount = this.driver.findElement(By.id("amount"));
    }

    public void check_total_amount(Double amountArg){
        Double amount = Double.parseDouble(this.totalAmount.getAttribute("innerHTML").strip().substring(1));
        System.out.println(amount);
        if (amount.equals(amountArg)){
            System.out.println("amount is correct");
        } else {
            System.out.println("amount is not correct");
        }
    }

    public void find_confirm_order(){
        this.confirmOrder = this.driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button"));
    }

    public void click_confirm_order(){
        this.confirmOrder.click();
    }

    public void find_contact_customer_service_element(){
        this.customerService = this.driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/a"));
    }

    public void click_contact_customer_service_element(){
        this.customerService.click();
    }
}
