package operations.entities;

import io.restassured.response.Response;
import models.Board;
import operations.requests.DeleteBoard;
import operations.requests.GetBoards;
import operations.requests.PostCreateBoard;
import operations.validators.BoardValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardEntity {

    private List<Board> boards = new ArrayList<>();
    private final BoardValidator boardValidator = new BoardValidator();

    public BoardEntity() {
    }

    public List<Board> getBoards() {
        return boards;
    }

    public BoardValidator getBoardValidator() {
        boardValidator.setBoards(boards);
        return boardValidator;
    }

    public void getBoardsRequest(GetBoards getBoards) {
        Board[] tempBoards = getBoards.getBoardsRequest();
        boards = Arrays.asList(tempBoards);
        System.out.println(boards.toString());
        boardValidator.setBoards(boards);
    }

    public void postCreateBoardRequest(PostCreateBoard postCreateBoard) {
        boards.add(postCreateBoard.postCreateBoard());
        System.out.println(boards.toString());
    }

    public Response deleteBoardRequest(DeleteBoard deleteBoard) {
        return deleteBoard.deleteBoard();
    }

}
