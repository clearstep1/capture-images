package page;
import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public boolean waitForPageLoad(){
        return wait.until(driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
    }

    public OcularResult compare() {
        return Ocular.snapshot()
                .from(this)
                .sample()
//                .similarity(95)
                .using(driver)
                .compare();
    }

}