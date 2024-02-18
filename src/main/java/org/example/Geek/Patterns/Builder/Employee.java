package org.example.Geek.Patterns.Builder;

public class Employee {

    private final String firstname;
    private final String lastname;
    private final String middlename;
    private final String phoneNumber;
    private final String email;
    private final String room;
    private final String department;
    private final int    age;
    private final int    salary;
    private final int    seniority;

    private Employee(Builder builder) {
        this.firstname   = builder.firstname;
        this.lastname    = builder.lastname;
        this.middlename  = builder.middlename;
        this.phoneNumber = builder.phoneNumber;
        this.email       = builder.email;
        this.room        = builder.room;
        this.department  = builder.department;
        this.age         = builder.age;
        this.salary      = builder.salary;
        this.seniority   = builder.seniority;
    }

    public static class Builder {
        private String firstname;
        private String lastname;
        private String middlename;
        private String phoneNumber;
        private String email;
        private String room;
        private String department;
        private int    age;
        private int    salary;
        private int    seniority;

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder middlename(String middlename) {
            this.middlename = middlename;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder room(String room) {
            this.room = room;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder salary(int salary) {
            this.salary = salary;
            return this;
        }

        public Builder seniority(int seniority) {
            this.seniority = seniority;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

        @Override
        public String toString() {
            return "Employee " +
                    "firstname: " + firstname +
                    ", lastname: " + lastname +
                    ", middlename: " + middlename +
                    ", phoneNumber: " + phoneNumber +
                    ", email: " + email +
                    ", room: " + room +
                    ", department: " + department +
                    ", age: " + age +
                    ", salary: " + salary +
                    ", seniority: " + seniority;
        }
    }
}
