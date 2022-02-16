package operations.requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.CredentialsDTO;

import static io.restassured.RestAssured.given;

public class DeleteBoard {

    private String id;

    public DeleteBoard(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Response deleteBoard() {
        return given().
                contentType(ContentType.JSON).
                pathParam("boardId", id).
                queryParam("key", CredentialsDTO.getKey()).
                queryParam("token", CredentialsDTO.getToken()).
                when().
                delete("https://api.trello.com/1/boards/{boardId}").then().extract().response();
    }
}
