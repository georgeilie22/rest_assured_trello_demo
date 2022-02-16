import io.restassured.response.Response;
import operations.entities.BoardEntity;
import operations.requests.DeleteBoard;
import operations.requests.GetBoards;
import operations.requests.PostCreateBoard;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CreateBoardTest {

    public String id;
    public BoardEntity board;

    @Test
    public void createBoard() {
        board = new BoardEntity();

        board.postCreateBoardRequest(new PostCreateBoard("TestBoard"));
        board.getBoardValidator().boardHasId(0);
        id = board.getBoards().get(0).getId();

        board.getBoardsRequest(new GetBoards("name,url"));
        board.getBoardValidator().containsBoardName("TestBoard");
    }

    @AfterTest
    public void cleanData() {
        Response response = board.deleteBoardRequest(new DeleteBoard(id));
        System.out.println("Status code: " + response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);

        board.getBoardsRequest(new GetBoards("name,url"));
        board.getBoardValidator().notContainsName("TestBoard");

    }

}
