package com.kayak.domain.models.response;

import java.util.List;

public class UsersResponse {
    public static class data{
        public int id;
        public String email;
        public String first_name;
        public String last_name;
        public String avatar;
    }

    public List<data> data;
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
}
