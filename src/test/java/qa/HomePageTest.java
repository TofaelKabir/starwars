package qa;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseUtil {

    public WebDriver driver;
    public HomePage homePage;
    public VideoPage videoPage;
    public FilmsPage filmsPage;

    @BeforeMethod
    public void setUp() {
        initialize_driver();
        homePage = new HomePage(driver);
    }
    @Test
    public void verifyHomePageTitleTest(){
        String title1 = homePage.getHomePageTitle();
        System.out.println("the home page title is: "+ title1);
        Assert.assertEquals(title1, HomePage.HOME_PAGE_TITLE);
    }
    @Test
    public void verifyVideoLinkTest(){
        homePage.navigateToVideoPage();
        Assert.assertEquals(driver.getCurrentUrl(), "http://starwars.com/video/");
    }
    @Test
    public void verifyFilmsLinkTest(){
        homePage.navigateToFilmsPage();
        Assert.assertEquals(driver.getCurrentUrl(), "http://starwars.com/films/");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
