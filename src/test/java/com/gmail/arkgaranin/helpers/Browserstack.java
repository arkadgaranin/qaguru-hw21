package com.gmail.arkgaranin.helpers;

import com.gmail.arkgaranin.config.Credentials;

import static io.restassured.RestAssured.given;

public class Browserstack {

  public static String videoUrl(String sessionId) {
    return given()
        .auth().basic(Credentials.config.getUser(), Credentials.config.getKey())
        .when()
        .get(Credentials.config.getApi() + sessionId + ".json")
        .then()
        .statusCode(200)
        .extract()
        .response()
        .path("automation_session.video_url");
  }
}
