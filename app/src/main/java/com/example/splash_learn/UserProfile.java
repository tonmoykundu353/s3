package com.example.splash_learn;

import java.util.HashMap;
import java.util.Map;

/**
 * This is UserProfile class
 */

public class UserProfile {
    private String name;
    private String email;
    private String password;
    private String collegeName;

    /**
     * This is a private constructor of UserProfile
     * @param builder
     */

    private UserProfile(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.collegeName = builder.collegeName;
    }

    /**
     * This is the helping Builder Class
     */
    public static class Builder {
        private String name;
        private String email;
        private String password;
        private String collegeName;

        /**
         *
         * @param name
         * @return
         */
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         *
         * @param email
         * @return
         */
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        /**
         *
         * @param password
         * @return
         */
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        /**
         *
         * @param collegeName
         * @return
         */
        public Builder setCollegeName(String collegeName) {
            this.collegeName = collegeName;
            return this;
        }

        /**
         * 
         * @return
         */
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