package operations;

/**
 * This class will launch the calculator application
 * 
 * @author Manjeet Singh
 * @since 30 March,2023
 * @version 1.0
 */
public class CalculatorRunner {

	public static void main(String[] args) {

		Calculator calculator = new Calculator();

		// Getting number input
		calculator.getNumbersFromUser();

		// Getting choice from user
		calculator.choiceSelection();

		// Getting results
		calculator.printResult();

	}

}
