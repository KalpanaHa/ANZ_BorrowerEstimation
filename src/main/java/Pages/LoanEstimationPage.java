package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoanEstimationPage {
	private WebDriver driver;

	public By single = By.xpath("//*[@for='application_type_single']");

	public By dependents = By.xpath("//*[@title='Number of dependants']");
	public By propertyType = By.xpath("//*[@for='borrow_type_home']");
	public By incomeAmount = By.xpath("//*[@aria-labelledby='q2q1']");
	public By otherIcome = By.xpath("//*[@aria-labelledby='q2q2']");

	public By monthlyLivng = By.xpath("//*[@aria-labelledby='q3q1']");
	public By homeLoanRepay = By.xpath("//*[@aria-labelledby='q3q2']");
	public By otherLoan = By.xpath("//*[@aria-labelledby='q3q3']");
	public By monthlyComm = By.xpath("//*[@aria-labelledby='q3q3']");
	public By TotalCredit = By.xpath("//*[@aria-labelledby='q3q5']");
	public By Submit = By.xpath("//*[@id='btnBorrowCalculater']");
	public By reset = By.xpath("//*[@class='icon icon_restart']");
	public By borrowerErrorText = By.xpath("//*[@class='borrow__error__text']");
	public By borrowerResult = By.xpath("//*[@id='borrowResultTextAmount']");

}
