package com.kayak.domain.helpers;

import com.kayak.domain.models.response.UserResponse;
import com.kayak.domain.models.response.UsersResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.kayak.domain.clients.UsersClient;
import com.kayak.domain.entities.User;
import com.kayak.domain.models.request.CreateUserRequest;
import com.kayak.domain.models.response.CreateUserResponse;

public class UserHelper {
    private UsersClient usersClient;


    public UserHelper(UsersClient usersClient) {
        super();
        this.usersClient = usersClient;
    }


    public CreateUserResponse createUser(User user) throws UnirestException {
        return usersClient.createUser(new CreateUserRequest(user));
    }

    public int createUserWithStatusCode(User user) throws UnirestException {
        return usersClient.createUserWithStatusCode(new CreateUserRequest(user));
    }

    public UserResponse getUser() throws UnirestException {
        return usersClient.getUser();
    }

    public int getUserWithStatusCode() throws UnirestException {
        return usersClient.getUserWithStatusCode();
    }

    public UsersResponse getUsers() throws UnirestException {
        return usersClient.getUsers();
    }

    public int getUsersWithStatusCode() throws UnirestException {
        return usersClient.getUsersWithStatusCode();
    }
}
