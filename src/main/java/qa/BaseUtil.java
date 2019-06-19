package qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUtil {

     public static WebDriver driver;

     public static void initialize_driver() {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().deleteAllCookies();
         driver.manage().window().maximize();
         driver.get("https://www.starwars.com/");
     }
}
