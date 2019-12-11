package com.jsonplaceholder.core.client;

import com.jsonplaceholder.domain.response.CommentResponse;
import com.jsonplaceholder.domain.response.PostResponse;
import com.jsonplaceholder.domain.response.UserResponse;

import static io.restassured.RestAssured.given;

public class JsonHolderClient {


    public JsonHolderClient() {

    }

    protected UserResponse get(String url) {
        return given().accept("application/json").contentType("application/json").when().get(url).getBody().as(UserResponse.class);
    }

    public UserResponse[] getAllUsers(String url){
        return given().accept("application/json").contentType("application/json").when().get(url).getBody().as(UserResponse[].class);
    }

    public PostResponse[] getPosts(String url, String userId){
        return given().contentType("application/json").queryParam("userId", userId).when().get(url).getBody().as(PostResponse[].class);
    }

    protected CommentResponse[] getComments(String url, String postId) {
        return given().contentType("application/json").queryParam("postId", postId).when().get(url).getBody().as(CommentResponse[].class);
    }
}
