package seleniumSessions;

import java.util.Scanner;

public class DayOfWeek {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number (1-7) to select a day of the week: ");
        int weekNum = scanner.nextInt();
        String day;
        
        switch (weekNum) {
		case 1:
			day="Monday-weekday";
			break;
		case 2:
			day="Tuesday-weekday";
			break;
		case 3:
			day="Wednesday-weekday";
			break;	
		case 4:
			day="Thursday-weekday";
			break;
		case 5:
			day="Friday-weekday";
			break;
		case 6:
			day="Saturday-weekend";
			break;
		case 7:
			day="Sunday-weekday";
			break;
		default:
			day="invalid selection";
			break;
		}
        
        System.out.println("You selected: " + day);

        scanner.close();
	}

}
