package operations.validators;

import models.Board;
import org.testng.Assert;

import java.util.List;

public class BoardValidator {

    public static void listContainsName(List<Board> boardsList, String expectedValue) {
        boolean temp = false;
        for (Board board : boardsList) {
            if (board.getName().equals(expectedValue)) {
                temp = true;
                break;
            }
        }
        Assert.assertTrue(temp, "Could not find the expected value: " + expectedValue);
    }

    public static void listNotContainsName(List<Board> boardsList, String name) {
        for (Board board : boardsList) {
            Assert.assertNotEquals(board.getName(), name, "The list of boards still containg a board with the following name: " + name);
        }
    }
}
