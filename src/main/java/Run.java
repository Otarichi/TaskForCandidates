
public class Run {
    public static String MainURL = "http://automationpractice.com/index.php";

    public static void main(String[] args) {
        Setup setup = new Setup(MainURL);
        setup.move_to_women_menu_and_select_tShirts();
        setup.click_on_the_button_more();
        setup.check_big_image_changes();
        setup.change_product_size();
        setup.change_product_quantity();
        setup.add_product_to_cart_and_continue();
        setup.navigate_to_casual_dresses_category();
        setup.click_on_the_button_more();
        setup.add_product_to_cart_and_continue();
        setup.move_to_cart_and_checkout();
        setup.check_all_items_is_in_cart();
        setup.proceed_to_checkout();
        setup.start_proceed_to_create_account();
        setup.fill_registration_form();
    }
}
