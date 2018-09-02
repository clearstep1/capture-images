package page;

import com.testautomationguru.ocular.snapshot.Snap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Snap("PlanList.png")
public class PlanList extends BasePage {

    @FindBy(css = "h1.stepTitle")
    WebElement header;

    public PlanList(WebDriver driver) {
        super(driver);
        super.waitForPageLoad();
    }
}