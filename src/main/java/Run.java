
public class Run {
    public static String MainURL = "http://automationpractice.com/index.php";

    public static void main(String[] args) {
        // Open the Chrome browser
        // Navigate to the http://automationpractice.com/index.php
        Setup setup = new Setup(MainURL);

        // Move to 'Women' and select 'T-shirts'
        setup.move_to_women_menu_and_select_tShirts();

        // Click on the button 'More', which is visible on mouse hover on the returned card image
        setup.click_on_the_button_more();

        // In the opened page move to the all small images and check that big image changes
        setup.check_big_image_changes();

        // Add two M size to the cart and click on 'Continue Shopping' button
        setup.change_product_size();
        setup.change_product_quantity();
        setup.add_product_to_cart_from_product_page();
        setup.open_cart_layer_and_continue();

        // Move to the main page and select 'Casual Dresses' from the 'Dresses'
        setup.navigate_to_casual_dresses_category();

        // Move to the returned element and Add to cart and click on 'Continue Shopping' button
        setup.add_product_to_cart_from_category_page();
        setup.open_cart_layer_and_continue();

        // Move to the Cart and Check out
        setup.move_to_cart_and_checkout();

        // Check by description that all items are added in cart
        setup.check_all_items_is_in_cart();

        // Click on 'Proceed to checkout' and sign up for a new account
        setup.proceed_to_checkout();
        setup.start_proceed_to_create_account();
        setup.fill_registration_form();

        // Click on 'Proceed to checkout' and leave Address data the default
        setup.proceed_to_checkout();

        // Click on 'Proceed to checkout' and try to click to 'Proceed to checkout' button in Shipping tab without
        // accepting 'Terms of service'
        setup.proceed_to_checkout();

        // Catch error window and accept 'Terms of service'
        setup.close_error_window_and_agree();
        setup.proceed_to_checkout();

        // In 'Payment' Tab choose 'Pay by check'
        setup.select_pay_by_check_option();

        // Check that total amount is correct and click on 'Confirm my order'
        setup.find_and_check_total_amount();
        setup.confirm_order();

        // Choose heading and order reference, upload file, add message text and Send
        setup.navigate_to_customer_service();
        setup.send_message_to_customer_service();
    }
}
