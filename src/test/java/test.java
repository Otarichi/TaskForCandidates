public class test {
    public static void main(String[] args) {
        Setup setup = new Setup("http://automationpractice.com/index.php?controller=order&step=1&multi-shipping=0");
        setup.proceed_to_checkout();
    }
}
