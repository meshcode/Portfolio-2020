package Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;


public class MyStepDefs {
    @Given("I am {int} step")
    public void iAmFirstStep(int value) {
        assertEquals(1, value);
    }

    @When("I am second step")
    public void iAmSecondStep() {
    }

    @Then("I am third step")
    public void iAmThirdStep() {
        int value = 5;

        assertEquals(5, value);
    }
}
