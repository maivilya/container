package org.example.codeWars.serializer;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 43L;

    private final String firstName;
    private final String lastName;
    private final String middleName;
    private transient final String email;
    private transient final String password;
    private final int room;
    private final User manager;
    private final Gender gender;
    private final int age;
    private final int seniority;
    private final String post;

    private User(Builder builder) {
        this.firstName  = builder.firstName;
        this.lastName   = builder.lastName;
        this.middleName = builder.middleName;
        this.email      = builder.email;
        this.password   = builder.password;
        this.room       = builder.room;
        this.manager    = builder.manager;
        this.gender     = builder.gender;
        this.age        = builder.age;
        this.seniority  = builder.seniority;
        this.post       = builder.post;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String middleName;
        private String email;
        private String password;
        private int room;
        private User manager;
        private Gender gender;
        private int age;
        private int seniority;
        private String post;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder room(int room) {
            this.room = room;
            return this;
        }

        public Builder manager(User manager) {
            this.manager = manager;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder seniority(int seniority) {
            this.seniority = seniority;
            return this;
        }

        public Builder post(String post) {
            this.post = post;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", room=" + room +
                ", manager=" + manager +
                ", gender=" + gender +
                ", age=" + age +
                ", seniority=" + seniority +
                ", post='" + post + '\'' +
                '}';
    }
}