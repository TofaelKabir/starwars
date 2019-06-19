package qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseUtil {

    public static final String HOME_PAGE_TITLE = "StarWars.com | The Official Star Wars Website";

    @FindBy(xpath = "//span[@class='section-icon video-icon']")
    WebElement videoTab;
    @FindBy(xpath = "//span[@class='section-icon films-icon']")
    WebElement filmsTab;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageTitle(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleContains(HomePage.HOME_PAGE_TITLE));
        return driver.getTitle();
    }
    public VideoPage navigateToVideoPage(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(videoTab));
        videoTab.click();
        return new VideoPage();
    }
    public FilmsPage navigateToFilmsPage(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(filmsTab));
        filmsTab.click();
        return new FilmsPage();
    }

}
