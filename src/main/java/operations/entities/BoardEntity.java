package operations.entities;

import io.restassured.response.Response;
import models.Board;
import operations.requests.DeleteBoard;
import operations.requests.GetBoards;
import operations.requests.PostCreateBoard;

import java.util.Arrays;
import java.util.List;

public class BoardEntity {

    private Response response;

    public BoardEntity() {
    }

    public Response getRawResponse() {
        return response;
    }

    public List<Board> getBoardsRequest(GetBoards getBoards) {
        response = getBoards.getBoardsRequest();

        return Arrays.asList(response.as(Board[].class));
    }

    public Board postCreateBoardRequest(PostCreateBoard postCreateBoard) {
        response = postCreateBoard.postCreateBoard();

        return response.as(Board.class);
    }

    public Response deleteBoardRequest(DeleteBoard deleteBoard) {
        response = deleteBoard.deleteBoard();

        return response;
    }

}
