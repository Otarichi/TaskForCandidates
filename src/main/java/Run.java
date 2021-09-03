
public class Run {
    public static String MainURL = "http://automationpractice.com/index.php";

    public static void main(String[] args) {
        Setup setup = new Setup(MainURL);
        setup.move_to_women_menu_and_select_tShirts();
        setup.click_on_the_button_more();
    }
}
