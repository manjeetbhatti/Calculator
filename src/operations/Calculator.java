package operations;

import java.util.Scanner;

/**
 * This class will perform mathematical operations selected by user on given
 * numbers
 * 
 * @author Manjeet Singh
 * @since 30 March,2023
 * @version 1.0.1
 */
public class Calculator {
	private int number1;
	private int number2;
	private int menuChoice;
	private int result;
	boolean exceptionCheck;
	boolean validChoiceCheck;

	public void getNumbersFromUser() {
		int number1 = 0;
		int number2 = 0;
		System.out.print("Enter number1: ");
		// Taking first number from user
		number1 = numberInput();
		// Keep trying to get a valid number if invalid character was entered
		while (this.exceptionCheck) {
			System.out.print("Please Enter a valid number1: ");
			// Taking input from user again
			number1 = numberInput();
		}

		System.out.print("Enter number2: ");
		// Taking second number from user
		number2 = numberInput();
		// Keep trying to get a valid number if invalid character was entered
		while (this.exceptionCheck) {
			System.out.print("Please Enter a valid number2: ");
			// Taking input from user again
			number2 = numberInput();
		}
		// Setting numbers
		setNumbers(number1, number2);
	}

	/**
	 * Method to get menu choice from user
	 */
	public void choiceSelection() {
		// Checking if an exception was thrown while getting numbers from user
		if (!this.exceptionCheck) {
			// If user enters invalid input
			this.validChoiceCheck = getChoice();
			if (this.exceptionCheck && !this.validChoiceCheck) {
				// Invalid character or option was entered and an exception was thrown
				while (!this.validChoiceCheck) {
					System.out.println("Please enter valid option from 1-4 only");
					this.validChoiceCheck = getChoice();
				}
			}
		}
	}

	/**
	 * Method to get choice from user
	 * 
	 * @return true for valid choice and false for invalid choice
	 */
	private boolean getChoice() {
		// Printing menu
		printMenu();

		System.out.print("Choose operation: ");
		int menuChoice = 0;
		// Taking menu input from user
		menuChoice = numberInput();

		// Checking if an exception was thrown
		if (!this.exceptionCheck) {
			if (setChoice(menuChoice)) {
				// Executing Choice and returning value
				choiceExecution(this.menuChoice);
				return true;
			}
		} else {
			return false; // Returning false because an exception was thrown
		}
		return false;
	}

	/**
	 * This method gets number input from user
	 * 
	 * @return number input from user
	 */
	private int numberInput() {
		int numberInput = 0;

		try {
			Scanner scanner = new Scanner(System.in);
			// Getting number input from user
			numberInput = scanner.nextInt();
			// No exception was thrown
			this.exceptionCheck = false;
		} catch (Exception e) {
			// An exception was thrown
			this.exceptionCheck = true;
		}
		// Returning user input
		return numberInput;
	}

	/**
	 * Method to set numbers, will only set numbers if no exception was thrown
	 * 
	 * @param number1
	 * @param number2
	 */
	private void setNumbers(int number1, int number2) {
		// Checking if an exception was thrown
		if (!this.exceptionCheck) {
			this.number1 = number1;
			this.number2 = number2;
		}
	}

	/**
	 * Method to set choice only if it is valid
	 * 
	 * @param choice operation selected by user
	 * @return true if selected choice is within 1-4 and false it not within 1-4
	 */
	private boolean setChoice(int choice) {
		// Checking if input was valid choice
		if (choice > 0 && choice < 5) {
			this.menuChoice = choice;
			return true;
		} else {
			// Invalid choice was selected
			return false;
		}
	}

	/**
	 * Method to set result
	 * 
	 * @param result of selected operation
	 */
	private void setResult(int result) {
		this.result = result;
	}

	/**
	 * Method to print result, only if valid choice was selected
	 */
	public void printResult() {
		// Only print result if valid choice was selected
		if (this.validChoiceCheck && !this.exceptionCheck) {
			System.out.println("\nResult is: " + this.result);
		}
	}

	/**
	 * Method to print available choices for mathematical operations
	 */
	private void printMenu() {
		System.out.println("1 - Add");
		System.out.println("2 - Subtract");
		System.out.println("3 - Divide");
		System.out.println("4 - Multiply");
	}

	/**
	 * Method for operation execution according to user choice
	 * 
	 * @param choice operation selected by user
	 */
	private void choiceExecution(int choice) {
		if (choice == 1) {
			setResult(addition());
		} else if (choice == 2) {
			setResult(subtraction());
		} else if (choice == 3) {
			setResult(division());
		} else {
			setResult(multiplication());
		}
	}

	/**
	 * Method for adding two numbers
	 * 
	 * @return sum of first and second number given by user
	 */
	private int addition() {
		int addedNumbers = number1 + number2;
		return addedNumbers;
	}

	/**
	 * Method for subtraction
	 * 
	 * @return value after subtraction
	 */
	private int subtraction() {
		int subtractedNumber = number1 - number2;
		return subtractedNumber;
	}

	/**
	 * Method for division
	 * 
	 * @return value after division
	 */
	private int division() {
		int afterDivide = number1 / number2;
		return afterDivide;
	}

	/**
	 * Method for multiplication
	 * 
	 * @return value after multiplying given numbers
	 */
	private int multiplication() {
		int multipliedNumber = number1 * number2;
		return multipliedNumber;
	}
}
