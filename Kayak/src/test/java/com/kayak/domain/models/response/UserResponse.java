package com.kayak.domain.models.response;

public class UserResponse {
    public static class data {
        public int id;
        public String email;
        public String first_name;
        public String last_name;
        public String avatar;
    }

    public static class support {
        public String url;
        public String text;
    }

    public data data;
    public support support;
}
