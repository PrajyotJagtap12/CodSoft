import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private ArrayList<String> options;
    private int correctAnswerIndex;

    public QuizQuestion(String question , ArrayList<String> options, int correctAnswerIndex){
        this.question = question;
        this.options = options ;
        this.correctAnswerIndex = correctAnswerIndex;
    }
    public String getQuestion(){
        return question;
    }
    public ArrayList<String> getOptions(){
        return options;
    }
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
public class QuizApplication {
    private static final int TIME_LIMIT_SECONDS = 10;
    private static ArrayList<QuizQuestion> question = new ArrayList<>();
    private static int currentQuestionIndex = 0;
    private static int score = 0;
    private static Timer timer;

    public static void main(String[] args ){
        initializeQuestions();
        startQuiz();
    }
    public static void initializeQuestions(){
        question.add(new QuizQuestion("What  is 2 + 2?", new ArrayList<>(List.of("A.3","B.4","C.5","D.6")),1));
        question.add(new QuizQuestion("What  is  the capital of France ?", new ArrayList<>(List.of("A.London","B.Paris","C.Rome","D.Berlin")),1));
    }
    public static void startQuiz(){
        System.out.println("Welcome to the Quiz!");
        System.out.println("You have" + TIME_LIMIT_SECONDS + "seconds to answer each question.");
        askQuestion();

    }

    public static void askQuestion(){
        if(currentQuestionIndex < question.size()){
            QuizQuestion currentQuestion = question.get(currentQuestionIndex);
            System.out.println("Question "+ (currentQuestionIndex + 1)+":"+ currentQuestion.getQuestion());
            for (String option : currentQuestion.getOptions()){
                System.out.println(option);
            }
            timer = new Timer();
            timer.schedule(new TimerTask(){
                public void run(){
                    System.out.println("\nTime's up! Moving to the next question.");
                    evaluateAnswer(-1);
                    
                }
            }, TIME_LIMIT_SECONDS*1000);
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your answer (Enter option letter):");
            String userAnswer = scanner.nextLine().toUpperCase();
            char userChoice = userAnswer.charAt(0);

            if(userChoice <'A'|| userChoice > 'D'){
                System.out.println("Invalid choice. Please choose between A,B,C, or D.");
                timer.cancel();
                askQuestion();
                return;
            }

            int answerIndex = userChoice -'A';
            evaluateAnswer(answerIndex);
        }
        else {
            endQuiz();
        }
    }
    public static void evaluateAnswer(int userAnswerIndex){
        QuizQuestion currentQuestion= question.get(currentQuestionIndex);
        int correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();

        if(userAnswerIndex== correctAnswerIndex){
            System.out.println("Correct!");
            score++;
        }else{
            System.out.println("Incorrect!");
            System.out.println("Correct answer:"+currentQuestion.getOptions().get(correctAnswerIndex));
        }
        timer.cancel();

        currentQuestionIndex++;
        askQuestion();

    }
    public static void endQuiz(){
        System.out.println("Quiz ended!");
        System.out.println("Your score:" + score + "/" +question.size());
        
    }
}