import java.util.Scanner;

public class App {

    private static String assignmentName;
    private static int[] studentMarks = new int[30];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // F1: Input Assignment Name
        inputAssignmentName(scanner);

        // F2: Input Students' Marks
        inputStudentMarks(scanner);

        System.out.println("Assignment Name" + assignmentName);
        // Close the scanner when done
        scanner.close();
    }


    // Helper function to check if a mark is valid (between 0 and 30)
    public static boolean isValidMark(int mark) {
        return mark >= 0 && mark <= 30;
    }

    // Helper function to read integer input
    public static int readIntegerInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer mark.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    // F1: Input Assignment Name
    public static void inputAssignmentName(Scanner scanner) {
        System.out.print("Enter the assignment name: ");
        assignmentName = scanner.nextLine();
    }

    // F2: Input Students' Marks
    public static void inputStudentMarks(Scanner scanner) {
        for (int i = 0; i < studentMarks.length; i++) {
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Enter marks for student " + (i + 1) + ": ");
                int mark = readIntegerInput(scanner);

                if (isValidMark(mark)) {
                    studentMarks[i] = mark;
                    validInput = true;
                } else {
                    // F3: Report Invalid Input
                    reportInvalidInput(mark);
                }
            }
        }
    }

    // F3: Report Invalid Input
    public static void reportInvalidInput(int mark) {
        System.out.println("Invalid mark: " + mark + ". Please enter a mark between 0 and 30.");
    }


}