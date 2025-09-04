
package quizgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizGame {

    // ====== Base Class ======
    // A question with text, answer options and the correct answer number
    static class Question {
        private String questionText;     // the actual question
        private String[] options;        // the possible answers
        private int correctAnswer;       // the number of the correct option

        //  Here is the constructor to set up a question
        public Question(String questionText, String[] options, int correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        // Getters
        public String getQuestionText() { return questionText; }
        public String[] getOptions() { return options; }
        public int getCorrectAnswer() { return correctAnswer; }

        //  Here is the method to check if the answer of the player is correct
        public boolean checkAnswer(int choice) {
            return choice == correctAnswer;
        }
    }

    // ====== Subclass ======
    // A multiple-choice type of question
    static class MultipleChoiceQuestion extends Question {
        public MultipleChoiceQuestion(String questionText, String[] options, int correctAnswer) {
            super(questionText, options, correctAnswer);
        }
    }

    // ====== Player Class ======
    // Here the player name and score is stored
    static class Player {
        private String name;   //  is the name of the player
        private int score;     // is the score of the player

        public Player(String name) {
            this.name = name;
            this.score = 0;    // start with score 0
        }

        public String getName() { return name; }
        public int getScore() { return score; }
        public void incrementScore() { score++; } // increase score when correct
    }

    // ====== Quiz Manager ======
    //  Here it shows the handles  of the quiz questions, game flow and final report
    static class QuizManager {
        private List<Question> questions;   // list of quiz questions
        private Player player;              // the player who is playing
        private List<String> results;       // stores Correct/Wrong for each question

        public QuizManager(Player player) {
            this.player = player;
            this.questions = new ArrayList<>();
            this.results = new ArrayList<>();

            // Here is the questions asked
            questions.add(new MultipleChoiceQuestion("What is the capital of France?",
                    new String[]{"1. Paris", "2. Rome", "3. Madrid"}, 1));
            questions.add(new MultipleChoiceQuestion("When did South Africa gain independence?",
                    new String[]{"1. 1800", "2. 1910", "3. 2000"}, 2));
            questions.add(new MultipleChoiceQuestion("Who wrote 'The Tempest'?",
                    new String[]{"1. Charles Dickens", "2. William Shakespeare", "3. Mark Twain"}, 2));
            questions.add(new MultipleChoiceQuestion("Which ocean is the largest?",
                    new String[]{"1. Atlantic Ocean", "2. Pacific Ocean", "3. Indian Ocean"}, 2));
            questions.add(new MultipleChoiceQuestion("How many countries are in Africa?",
                    new String[]{"1. 51", "2. 60", "3. 54"}, 3));
            questions.add(new MultipleChoiceQuestion("What is the largest planet in our solar system?",
                    new String[]{"1. Jupiter", "2. Earth", "3. Mars"}, 1));
            questions.add(new MultipleChoiceQuestion("Which country is leading AI development?",
                    new String[]{"1. The U.S", "2. China", "3. Singapore"}, 1));
        }

        // This method show how the quiz is run
        public void startQuiz() {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nWelcome to the Quiz Game!");
            System.out.println("Answer the following questions:\n");

            int qNum = 1;
            for (Question q : questions) {
                // Print the question
                System.out.println("Q" + qNum + ": " + q.getQuestionText());
                // Print all the options
                for (String option : q.getOptions()) {
                    System.out.println(option);
                }

                //  Here we ask the user for input
                System.out.print("Enter your answer (number): ");
                int choice = sc.nextInt();

                // Here we check if correct or wrong
                if (q.checkAnswer(choice)) {
                    System.out.println("Correct\n");
                    player.incrementScore(); // increase score
                    results.add("Q" + qNum + ": Correct");
                } else {
                    System.out.println("Wrong. Correct answer was option " + q.getCorrectAnswer() + "\n");
                    results.add("Q" + qNum + ": Wrong");
                }
                qNum++;
            }
        }

        // Here the final results of the quiz are shown
        public void showReport() {
            System.out.println("\n--- Quiz Report ---");
            System.out.println("Player: " + player.getName());
            for (String r : results) {
                System.out.println(r);
            }
            System.out.println("Score: " + player.getScore() + "/" + questions.size());
            double percentage = ((double) player.getScore() / questions.size()) * 100;
            System.out.println("Percentage: " + percentage + "%");
        }
    }

    // ====== Main Method ======
    //The main program starts here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask player for their name
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // Create player and quiz
        Player player = new Player(name);
        QuizManager quiz = new QuizManager(player);

        // Start quiz and then show report
        quiz.startQuiz();
        quiz.showReport();

        sc.close();
    }
}
