package com.example.splash_learn;

import java.util.HashMap;
import java.util.Map;

public class UserProfile {
    private String name;
    private String email;
    private String password;
    private String collegeName;

    private UserProfile(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.collegeName = builder.collegeName;
    }

    public static class Builder {
        private String name;
        private String email;
        private String password;
        private String collegeName;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setCollegeName(String collegeName) {
            this.collegeName = collegeName;
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this);
        }
    }

    public Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("email", email);
        result.put("password", password);
        result.put("college_name", collegeName);
        return result;
    }
}