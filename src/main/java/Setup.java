import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainLayout;
import pages.CategoryPage;
import pages.OrderPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

public class Setup {
    WebDriver driver;
    Actions action;
    String driverPath = "C:\\Users\\Oto\\Downloads\\chromedriver_win32\\chromedriver.exe";
    String mainURL;
    MainLayout objectMainLayout;
    CategoryPage objectCategoryPage;
    ProductPage objectProductPage;
    OrderPage objectOrderPage;
    WebDriverWait wait;

    public Setup (String mainURL){
        this.mainURL = mainURL;
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action = new Actions(driver);
        driver.get(this.mainURL);
        wait = new WebDriverWait(this.driver, 10);
        objectMainLayout = new MainLayout(driver, action, wait);
        objectCategoryPage = new CategoryPage(driver, action);
        objectProductPage = new ProductPage(driver, action, wait);
        objectOrderPage = new OrderPage(driver);
    }

    public void move_to_women_menu_and_select_tShirts() {
        objectMainLayout.find_women_category();
        objectMainLayout.hover_women_category();
        objectMainLayout.find_t_shirts_sub_category();
        objectMainLayout.click_t_shirts_sub_category();
    }

    public void click_on_the_button_more(){
        objectCategoryPage.find_product_main_element();
        objectCategoryPage.hover_product_main_element();
        objectCategoryPage.find_more_button_element();
        objectCategoryPage.click_more_button_element();
    }

    public void check_big_image_changes(){
        objectProductPage.find_all_images_elements();
        objectProductPage.hover_small_image_and_check_big_image_change();
    }

    public void change_product_size(){
        objectProductPage.find_size_input_element();
        objectProductPage.click_size_input_and_select_m();
    }

    public void change_product_quantity(){
        objectProductPage.find_quantity_plus_element();
        objectProductPage.click_quantity_plus_element();
    }

    public void add_product_to_cart_and_continue(){
        objectProductPage.find_add_to_cart_element();
        objectProductPage.click_add_to_cart_element();
        objectProductPage.wait_until_cart_layer_display();
        objectProductPage.find_continue_shopping_element();
        objectProductPage.click_continue_shopping_element();
    }

    public void navigate_to_casual_dresses_category(){
        objectMainLayout.go_to_main_page();
        objectMainLayout.find_dresses_category();
        objectMainLayout.hover_dresses_category();
        objectMainLayout.find_casual_dresses_sub_category();
        objectMainLayout.click_casual_dresses_category();
    }

    public void move_to_cart_and_checkout(){
        objectMainLayout.find_cart_element();
        objectMainLayout.hover_cart_element();
        objectMainLayout.find_checkout_element();
        objectMainLayout.click_checkout_element();
    }

    public void check_all_items_is_in_cart(){
        objectOrderPage.find_products_description_titles_and_check("Faded Short Sleeve T-shirts", "Printed Dress");
    }

    public void proceed_to_checkout() {
        objectOrderPage.find_proceed_to_checkout_element();
        objectOrderPage.click_proceed_to_checkout();
    }

    public void start_proceed_to_create_account(){
        objectOrderPage.find_email_address_field();
        objectOrderPage.input_value_in_email_address_field("gvazava911@gmail.com");
        objectOrderPage.find_create_an_account_button();
        objectOrderPage.click_create_account_button();
    }
}
