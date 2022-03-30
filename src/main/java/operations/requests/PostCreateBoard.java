package operations.requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.CredentialsDTO;

import static io.restassured.RestAssured.given;

public class PostCreateBoard {

    private String name;

    public PostCreateBoard(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Response postCreateBoard() {
        return given().
                contentType(ContentType.JSON).
                queryParam("key", CredentialsDTO.getKey()).
                queryParam("token", CredentialsDTO.getToken()).
                queryParam("name", name).
                when().
                post("https://api.trello.com/1/boards");
    }
}
