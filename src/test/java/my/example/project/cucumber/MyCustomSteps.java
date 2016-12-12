package my.example.project.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import de.abas.acceptanceTests.support.ERPTestContext;

public class MyCustomSteps {

	private ERPTestContext context;

	public MyCustomSteps(ERPTestContext context) {
		this.context = context;
	}

	@Given("^I execute a custom step that alters the searchword$")
	public void i_execute_a_custom_step() throws Throwable {
		this.context.currentEditor.setFieldVal("such", "ALTERED");
	}

}
