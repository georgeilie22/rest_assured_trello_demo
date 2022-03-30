package operations.validators;

import models.Board;
import org.testng.Assert;

import java.util.List;

public class BoardValidator {

    private List<Board> boardsList;

    public BoardValidator() {
    }

    public void setBoardsList(List<Board> boardsList) {
        this.boardsList = boardsList;
    }

    public void containBoardName(String expectedValue) {
        boolean temp = false;
        for (Board board : boardsList) {
            if (board.getName().equals(expectedValue)) {
                temp = true;
                break;
            }
        }
        Assert.assertTrue(temp, "Could not find the expected value: " + expectedValue);
    }

    public void notContainBoardName(String name) {
        for (Board board : boardsList) {
            Assert.assertNotEquals(board.getName(), name,"The list of boards still containg a board with the following name: "+name);
        }
    }
}
