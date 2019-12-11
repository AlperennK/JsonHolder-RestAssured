package com.jsonplaceholder.domain.client;

import com.jsonplaceholder.core.client.EndPoint;
import com.jsonplaceholder.core.client.JsonHolderClient;
import com.jsonplaceholder.core.configuration.ConfigParser;
import com.jsonplaceholder.domain.response.CommentResponse;
import com.jsonplaceholder.domain.response.PostResponse;
import com.jsonplaceholder.domain.response.UserResponse;
import gherkin.lexer.En;

import java.util.ArrayList;

public class JsonHolderPostandUserClient extends JsonHolderClient {
    private String url;
    private PostResponse[] postsArrResponse;
    private CommentResponse[] commentsArrResponse;
    private ArrayList<CommentResponse> commentResponseArrayList;
    private ArrayList<String> emailsForAPost;
    private ArrayList<String> emailsForAllCommentsForAUser;
    private ArrayList<String> postIdsArr;


    public  JsonHolderPostandUserClient(){
        this.url= ConfigParser.getValue("BaseUrl");

    }
    public UserResponse getUserById(int id){
        return get(url + EndPoint.GET_USERS + Integer.toString(id));

    }
    //Try taking off new declaration and change for loop
    public ArrayList<String> getPostsForAUser(String userId){
        postIdsArr=new ArrayList<String>();
        postsArrResponse =getPosts(url + EndPoint.GET_POSTS, userId);
        for(PostResponse postResponse : postsArrResponse){
            postIdsArr.add(postResponse.getId());
        }
        return postIdsArr;
    }
    // Use getAllCommentsForAPost
    public ArrayList<String> getEmailsForAPost(String postId){
        emailsForAPost=new ArrayList<String>();
        commentsArrResponse =getComments(url+EndPoint.GET_COMMENTS, postId);

        for(CommentResponse commentResponse : commentsArrResponse){
            emailsForAPost.add(commentResponse.getEmail());
        }
        return emailsForAPost;
    }


//    public ArrayList<CommentResponse> getAllCommentsForAPost(String postId){
//        commentResponseArrayList= Arrays.asList(getComments(url+EndPoint.GET_COMMENTS, postId));
//        return commentResponseArrayList;
//    }



    //This returns all the email addresses for all the comments made for a user's posts

    public int numberOfUsers(){
        return getAllUsers(url+ EndPoint.GET_USERS).length;
    }
    public ArrayList<String> getEmailsForAllCommentsForAUser(String userId){
        postIdsArr=getPostsForAUser(userId);
        emailsForAllCommentsForAUser=new ArrayList<String>();
        //Might need to change
        for(String postId : postIdsArr){
            emailsForAllCommentsForAUser.addAll(getEmailsForAPost(postId));
        }
        return emailsForAllCommentsForAUser;

    }



}

