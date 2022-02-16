package operations.validators;

import models.Board;
import org.testng.Assert;

import java.util.List;

public class BoardValidator {

    private List<Board> boards;

    public BoardValidator() {
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public void boardNameIs(String expectedValue, int boardIndex) {
        Assert.assertEquals(boards.get(boardIndex).getName(), expectedValue);
    }

    public void containsBoardName(String expectedValue) {
        boolean temp = false;
        for (Board board : boards) {
            if (board.getName().equals(expectedValue)) {
                temp = true;
                break;
            }
        }
        Assert.assertTrue(temp, "Could not find the expected value: " + expectedValue);
    }

    public void boardHasId(int boardIndex) {
        Assert.assertNotNull(boards.get(boardIndex).getId());
    }

    public void notContainsName(String name) {
        for (Board board : boards) {
            Assert.assertNotEquals(board.getName(), name);
        }
    }
}
