import io.restassured.response.Response;
import models.Board;
import operations.entities.BoardEntity;
import operations.requests.DeleteBoard;
import operations.requests.GetBoards;
import operations.requests.PostCreateBoard;
import operations.validators.BoardValidator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class CreateBoardTest {

    public BoardEntity boardEntity;
    public Board createdBoard;
    public List<Board> boardsList;
    public BoardValidator boardValidator= new BoardValidator();


    @Test
    public void createBoard() {
        boardEntity = new BoardEntity();

        createdBoard = boardEntity.postCreateBoardRequest(new PostCreateBoard("TestBoard"));
        Assert.assertEquals(boardEntity.getRawResponse().statusCode(), 200);

        boardsList = boardEntity.getBoardsRequest(new GetBoards("name,url"));
        Assert.assertEquals(boardEntity.getRawResponse().statusCode(), 200);

        boardValidator.setBoardsList(boardsList);
        boardValidator.containBoardName(createdBoard.getName());
    }

    @AfterTest
    public void cleanData() {
        boardEntity = new BoardEntity();
        Response response = boardEntity.deleteBoardRequest(new DeleteBoard(createdBoard.getId()));
        Assert.assertEquals(response.statusCode(), 200);

        boardsList = boardEntity.getBoardsRequest(new GetBoards("name,url"));
        boardValidator.setBoardsList(boardsList);
        boardValidator.notContainBoardName(createdBoard.getName());
    }

}
