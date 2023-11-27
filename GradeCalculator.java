import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Grade Calculator!");
        System.out.print("Enter your name: ");
        String studentName = scanner.nextLine();

        System.out.println("\nHello, " + studentName + "!");
        System.out.println("Let's calculate your grades.");

        System.out.print("\nEnter the number of subjects you have: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;

        System.out.println("\nEnter the marks obtained (out of 100) in each subject:");

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Subject " + i + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\n--------------------------------------------");
        System.out.println("Results for " + studentName + ":");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("--------------------------------------------");

        String message = "";
        switch (grade) {
            case "A+":
                message = "Excellent job, " + studentName + "! Keep up the great work!";
                break;
            case "A":
                message = "Well done, " + studentName + "! You've performed admirably.";
                break;
            case "B":
                message = "Good work, " + studentName + "! Keep striving for improvement.";
                break;
            case "C":
                message = "Not bad, " + studentName + "! You're on the right track.";
                break;
            case "D":
                message = "Keep working hard, " + studentName + "! You can do better.";
                break;
            case "F":
                message = "Don't worry, " + studentName + ". Failure is just the first step to success.";
                break;
        }

        System.out.println("\n" + message);
        System.out.println("Thank you for using the Grade Calculator!");

        scanner.close();
    }
}
