import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args ){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Student Grade calculator ! ");
        System.out.print("Enter the number of subjects :");
        int numSubjects = scanner.nextInt();

        double totalMarks=0;

        for (int i=1;i<=numSubjects;i++){
            System.out.print("Enter marks obtained in subject" +i+":");
            double marks = scanner.nextDouble();
            totalMarks+=marks;
        }

        double totalMarksOutOf= numSubjects*100;
        double averagePercentage=(totalMarks/totalMarksOutOf)*100;

        char grade;
        if(averagePercentage>=90){
            grade='A';
        }
        else if (averagePercentage>=80){
            grade='B';
        }
        else if (averagePercentage>=70){
            grade='C';
        }
        else if (averagePercentage>=60){
            grade='D';
        }
        else{
            grade='F';
        }
        System.out.println("Total Marks Obtained:"+totalMarks);
        System.out.println("Average Percentage :"+averagePercentage+"%");
        System.out.println("Grade:"+grade);

        scanner.close();
    }
}
