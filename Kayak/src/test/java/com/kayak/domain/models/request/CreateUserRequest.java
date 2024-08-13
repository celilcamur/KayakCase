package com.kayak.domain.models.request;

import com.kayak.domain.entities.User;

public class CreateUserRequest {
    public String name;
    public String job;

    public CreateUserRequest(User user) {
        this.name = user.name;
        this.job = user.job;
    }
}
