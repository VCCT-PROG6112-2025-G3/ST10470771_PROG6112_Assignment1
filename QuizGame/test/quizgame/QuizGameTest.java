
package quizgame;

import org.junit.Test;
import static org.junit.Assert.*;


public class QuizGameTest {

    @Test
    public void testCorrectAnswer() {
        String[] options = {"1. Paris", "2. Rome", "3. Madrid"};
        QuizGame.Question q = new QuizGame.Question("What is the capital of France?", options, 1);

        assertTrue(q.checkAnswer(1));  // correct
        assertFalse(q.checkAnswer(2)); // wrong
    }

    @Test
    public void testPlayerScoreIncrement() {
        QuizGame.Player player = new QuizGame.Player("Alice");
        assertEquals(0, player.getScore());

        player.incrementScore();
        assertEquals(1, player.getScore());

        player.incrementScore();
        assertEquals(2, player.getScore());
    }

    @Test
    public void testMultipleChoiceQuestionInheritsQuestion() {
        String[] options = {"1. Jupiter", "2. Earth", "3. Mars"};
        QuizGame.MultipleChoiceQuestion mcq =
                new QuizGame.MultipleChoiceQuestion("Largest planet?", options, 1);

        assertEquals("Largest planet?", mcq.getQuestionText());
        assertEquals(3, mcq.getOptions().length);
        assertTrue(mcq.checkAnswer(1));
    }

    @Test
    public void testQuizManagerInitialScoreIsZero() {
        QuizGame.Player player = new QuizGame.Player("Bob");
        QuizGame.QuizManager manager = new QuizGame.QuizManager(player);

        assertEquals(0, player.getScore());
    }

    @Test
    public void testQuizManagerIncrementScore() {
        QuizGame.Player player = new QuizGame.Player("Bob");
        QuizGame.QuizManager manager = new QuizGame.QuizManager(player);

        // Simulate answering two questions correctly
        player.incrementScore();
        player.incrementScore();

        assertEquals(2, player.getScore());
    }

}