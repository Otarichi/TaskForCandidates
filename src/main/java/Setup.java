import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.Random;
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
    RegistrationPage objectRegistrationPage;
    WebDriverWait wait;
    CustomerServicePage objectCustomerServicePage;

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
        objectOrderPage = new OrderPage(driver, wait);
        objectRegistrationPage = new RegistrationPage(driver, wait, action);
        objectCustomerServicePage = new CustomerServicePage(driver);
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
        objectProductPage.select_m_size("2");
    }

    public void change_product_quantity(){
        objectProductPage.find_quantity_plus_element();
        objectProductPage.click_quantity_plus_element();
    }

    public void add_product_to_cart_from_product_page(){
        objectProductPage.find_add_to_cart_element();
        objectProductPage.click_add_to_cart_element();
    }

    public void open_cart_layer_and_continue(){
        objectMainLayout.wait_until_cart_layer_display();
        objectMainLayout.find_continue_shopping_element();
        objectMainLayout.click_continue_shopping_element();
        objectMainLayout.wait_until_cart_layer_display_none();
    };

    public void navigate_to_casual_dresses_category(){
        objectMainLayout.go_to_main_page();
        objectMainLayout.find_dresses_category();
        objectMainLayout.hover_dresses_category();
        objectMainLayout.find_casual_dresses_sub_category();
        objectMainLayout.click_casual_dresses_category();
    }

    public void add_product_to_cart_from_category_page(){
        objectCategoryPage.find_product_main_element();
        objectCategoryPage.hover_product_main_element();
        objectCategoryPage.find_add_to_cart_button();
        objectCategoryPage.click_add_to_cart_button();
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
        objectOrderPage.input_value_in_email_address_field("mbjdss@gmail.com");
        objectOrderPage.find_create_an_account_button();
        objectOrderPage.click_create_account_button();
    }

    public void fill_registration_form(){
        objectRegistrationPage.find_gender_input_and_select(1);
        objectRegistrationPage.find_first_name_field_and_input("oto");
        objectRegistrationPage.find_last_name_field_and_input("gvazava");
        objectRegistrationPage.find_password_field_and_input("Paroli123");
        objectRegistrationPage.find_date_of_birth_fields_and_input(29, 7, 2000);
        objectRegistrationPage.find_address_field_and_input("Vadja Pshavela");
        objectRegistrationPage.find_city_field_and_input("Tbilisi");
        objectRegistrationPage.find_state_field_and_input(10);
        objectRegistrationPage.find_zip_code_field_and_input("01000");
        objectRegistrationPage.find_phone_field_and_input("599000000");
        objectRegistrationPage.find_register_button_and_click();
    }

    public void close_error_window_and_agree(){
        objectOrderPage.find_error_window_close_button();
        objectOrderPage.click_error_window_close_button();
        objectOrderPage.find_agreement_checkbox();
        objectOrderPage.click_agreement_checkbox();
    }

    public void select_pay_by_check_option(){
        objectOrderPage.find_pay_by_check_button();
        objectOrderPage.click_pay_by_check_button();
    }

    public void find_and_check_total_amount(){
        objectOrderPage.find_total_amount_element();
        objectOrderPage.check_total_amount(61.02);
    }

    public void confirm_order(){
        objectOrderPage.find_confirm_order();
        objectOrderPage.click_confirm_order();
    }

    public void navigate_to_customer_service(){
        objectOrderPage.find_contact_customer_service_element();
        objectOrderPage.click_contact_customer_service_element();
    }

    public void send_message_to_customer_service(){
        objectCustomerServicePage.find_subject_heading_and_select(1);
        objectCustomerServicePage.find_order_reference_and_select(1);
        objectCustomerServicePage.find_choose_file_element_and_choose();
        objectCustomerServicePage.find_message_text_area_and_input("Web site tested successfully");
        objectCustomerServicePage.find_send_button_and_click();
    }
}
