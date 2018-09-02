package page;

import com.testautomationguru.ocular.snapshot.Snap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Snap("SeeThePlans.png")
public class SeeThePlans extends BasePage {

    @FindBy(css = "button.nf-btn-primary")
    private WebElement seeThePlansBtn;

    public SeeThePlans(WebDriver driver) {
        super(driver);
    }

    public PlanList clickToSeeThePlans() {
        this.seeThePlansBtn.click();
        return new PlanList(driver);
    }

}