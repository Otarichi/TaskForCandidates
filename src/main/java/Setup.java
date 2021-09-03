import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.TShirtsPage;

public class Setup {
    WebDriver driver;
    Actions action;
    String driverPath = "C:\\Users\\Oto\\Downloads\\chromedriver_win32\\chromedriver.exe";
    String mainURL;
    HomePage objectHomePage;
    TShirtsPage objectTShirtsPage;

    public Setup (String mainURL){
        this.mainURL = mainURL;
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.get(this.mainURL);
    }

    public void move_to_women_menu_and_select_tShirts() {
        objectHomePage = new HomePage(driver, action);
        objectHomePage.find_women_category();
        objectHomePage.hover_women_category();
        objectHomePage.find_t_shirts_sub_category();
        objectHomePage.click_t_shirts_sub_category();
    }

    public void click_on_the_button_more(){
        objectTShirtsPage = new TShirtsPage(driver, action);
        objectTShirtsPage.find_product_main_element();
        objectTShirtsPage.hover_product_main_element();
        objectTShirtsPage.find_more_button_element();
        objectTShirtsPage.click_more_button_element();
    }
}
