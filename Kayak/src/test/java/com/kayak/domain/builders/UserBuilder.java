package com.kayak.domain.builders;

import com.kayak.domain.entities.User;

public class UserBuilder {
    private String _name = null;
    private String _job = null;

    public UserBuilder setName(String value) {
        _name = value;
        return this;
    }

    public UserBuilder setJob(String value) {
        _job = value;
        return this;
    }

    public User build() {
        return new User()   {{
            this.name = _name;
            this.job = _job;
        }};
    }
}
