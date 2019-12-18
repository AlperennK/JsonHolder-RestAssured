package com.jsonplaceholder.domain.helper;

import com.jsonplaceholder.domain.client.JsonHolderPostandUserClient;
import com.jsonplaceholder.domain.response.UserResponse;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.ArrayList;


public class JsonHolderService{
    private JsonHolderPostandUserClient jsonHolderPostandUserClient;
    private boolean emailVerifyValue;

    public JsonHolderService(JsonHolderPostandUserClient jsonHolderPostandUserClient){
        this.jsonHolderPostandUserClient=jsonHolderPostandUserClient;
    }

    public UserResponse getUserWithId(int id){
        return jsonHolderPostandUserClient.getUserById(id);
    }


    public UserResponse findUserWithUserName(String username){
        UserResponse user=new UserResponse();
        int i=1;
        while(i<=getNumberofUsers()){
            user=getUserWithId(i);
            if(user.getUsername().equals(username)){
                break;
            }
            i++;
        }
        return user;
    }

    public ArrayList<String> fetchAllPostIdsForUser(String userId){
        return jsonHolderPostandUserClient.getPostsForAUser(userId);
    }


    public boolean verifyEmailFormat(String email){
        return EmailValidator.getInstance().isValid(email);
    }

    public int getNumberofUsers(){
        return jsonHolderPostandUserClient.numberOfUsers();
    }

    public ArrayList<String> fetchAllEmailsForAllCommentsForAUser(String userId) {
        return jsonHolderPostandUserClient.getEmailsForAllCommentsForAUser(userId);
    }


    public boolean verifyAllEmails(ArrayList<String> emailArr){
        emailVerifyValue=true;
        for(String email : emailArr){
            if(!verifyEmailFormat(email)){
                return false;
            }
        }
        return emailVerifyValue;
    }



}
