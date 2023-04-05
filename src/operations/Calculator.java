package operations;

import java.util.Scanner;

/**
 * This class will perform mathematical operations selected by user on given
 * numbers
 * 
 * @author Manjeet Singh
 * @since 30 March,2023
 * @version 1.0
 */
public class Calculator {
	private int number1;
	private int number2;
	private int menuChoice;
	private Scanner scanner = new Scanner(System.in);
	private int result;
	boolean exceptionCheck = false;

	public void getNumbersFromUser() {
		System.out.print("Enter number1: ");
		// Taking input from user
		int number1 = scanner.nextInt();

		System.out.print("Enter number2: ");
		// Taking input from user
		int number2 = scanner.nextInt();

		// Setting numbers
		setNumbers(number1, number2);
	}

	/**
	 * Method to get menu choice from user
	 */
	public void choiceSelection() {

		// Getting choice from user and keep trying if choice is not between 1-4
		// If user enters invalid input
		while (!getChoice()) {
			getChoice();
		}

	}

	/**
	 * Method to get choice from user
	 * 
	 * @return
	 */
	private boolean getChoice() {
		// Printing menu
		printMenu();

		System.out.print("Choose operation: ");
		int menuChoice = 0;
		// Taking menu input from user
		try {
			menuChoice = scanner.nextInt();
			this.exceptionCheck = false;
			// Setting menuChoice
			if (setChoice(menuChoice)) {
				// Executing Choice and returning value
				choiceExecution(this.menuChoice);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Please enter a valid choice from 1 - 4");
			return false;
		}
	}

	/**
	 * Method to set numbers
	 * 
	 * @param number1
	 * @param number2
	 */
	private void setNumbers(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}

	/**
	 * Method to set choice
	 * 
	 * @param choice operation selected by user
	 * @return boolean if selected choice is within 1 and 4
	 */
	private boolean setChoice(int choice) {
		// Checking if input was valid choice
		if (choice > 0 && choice < 5) {
			this.menuChoice = choice;
			return true;
		} else {
			System.out.println("Please enter a valid choice from 1 - 4");
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
	 * Method to print result
	 */
	public void printResult() {
		System.out.println("\nResult is: " + this.result);
	}

	/**
	 * Method to print menu options
	 */
	private void printMenu() {
		System.out.println("1 - Add");
		System.out.println("2 - Subtract");
		System.out.println("3 - Divide");
		System.out.println("4 - Multiply");
	}

	/**
	 * Method for execution according to user choice
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
	 * @return sum of number1 and number2
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
