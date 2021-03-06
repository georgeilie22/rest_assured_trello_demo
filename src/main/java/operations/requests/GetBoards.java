package operations.requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.CredentialsDTO;

import static io.restassured.RestAssured.given;

public class GetBoards {

    private String fields;

    public GetBoards(String fields) {
        this.fields = fields;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public Response getBoardsRequest() {
        return given().
                contentType(ContentType.JSON).
                queryParam("key", CredentialsDTO.getKey()).
                queryParam("token", CredentialsDTO.getToken()).
                queryParam("fields", fields).
                when().
                get("https://api.trello.com/1/members/me/boards");
    }

}
