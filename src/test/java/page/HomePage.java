package page;
import com.testautomationguru.ocular.snapshot.Snap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Snap("HomePage.png")
public class HomePage extends BasePage {

    @FindBy(css = "button.btn-large")
    private WebElement joinFreeForAMonth;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SeeThePlans clickOnJoinButton() {
        this.joinFreeForAMonth.click();
        return new SeeThePlans(driver);
    }
}