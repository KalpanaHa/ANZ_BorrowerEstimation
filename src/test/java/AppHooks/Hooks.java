package AppHooks;

import Pages.LoanEstimationPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Base;

public class Hooks {

	Base base = new Base();

	@Before()
	public void opeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		base.init_driver();
	}

}
