package StepDef;

import static org.junit.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.LoanEstimationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Base;

public class Stepdef {
	WebDriver driver;
	LoanEstimationPage le = new LoanEstimationPage();

	@Given("user is on loan estimation page")
	public void user_is_on_loan_estimation_page() {
		driver = Base.init_driver();
		if (driver.getTitle().equalsIgnoreCase("Home loan borrowing power calculator | ANZ")) {
			System.out.println("User is on Loan estimation page");
		} else {
			fail("User is not in Loan estimation page");
		}

	}

	@Given("user Enters the eligibility data {string} {string} {string}{string} {string} {string}{string}{string} {string} {string}")
	public void user_enters_the_eligibility_data(String ApplicatonType, String numberOfDependent, String propertyBuy,
			String income, String otherincome, String livingExpense, String currentHomeLoan, String otherLoan,
			String otherCommitment, String totalCreditCardLimit) {

		if (ApplicatonType.equalsIgnoreCase("Single")) {
			driver.findElement(le.single).click();
		}

		WebElement ele = driver.findElement(le.dependents);
		Select select = new Select(ele);
		select.selectByVisibleText(numberOfDependent);

		if (propertyBuy.equalsIgnoreCase("Home to live in")) {
			driver.findElement(le.propertyType).click();
		}
		driver.findElement(le.incomeAmount).sendKeys(income);
		driver.findElement(le.otherIcome).sendKeys(otherincome);

		driver.findElement(le.monthlyLivng).sendKeys(livingExpense);
		driver.findElement(le.homeLoanRepay).sendKeys(currentHomeLoan);
		driver.findElement(le.otherLoan).sendKeys(otherLoan);
		driver.findElement(le.monthlyComm).sendKeys(otherCommitment);
		driver.findElement(le.TotalCredit).sendKeys(totalCreditCardLimit);

	}

	@When("user clicks how much borrow button")
	public void user_clicks_how_much_borrow_button() {
		driver.findElement(le.Submit).click();
	}

	@Then("user validate the borrowing estimation as {string}")
	public void user_validate_the_borrowing_estimation_as(String ExpectedAmount) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String ActualBorrowAmount = wait.until(ExpectedConditions.presenceOfElementLocated(le.borrowerResult))
				.getText();
		System.out.println("Estimation amount is " + ActualBorrowAmount);
		if (ActualBorrowAmount.equalsIgnoreCase(ExpectedAmount)) {
			System.out.println("Estimation borrow amount is passed");
		} else {
			fail("Estimated borrow amount is not matched with actual");
		}

		driver.close();
	}

	@Then("user clicks on Start over button to clear the form")
	public void user_clicks_on_start_over_button_to_clear_the_form() throws InterruptedException {
		driver.findElement(le.reset).click();
		Thread.sleep(3000);
		driver.close();
	}

	@Then("user validate the error message")
	public void user_validate_the_error_message() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String error = wait.until(ExpectedConditions.presenceOfElementLocated(le.borrowerErrorText)).getText();
		String Expectederror = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
		if (error.equals(Expectederror)) {
			System.out.println("Error is expected");
		} else {
			System.out.println("Acutal error is not same as expected");
		}
		Thread.sleep(3000);
		driver.close();

	}

}
