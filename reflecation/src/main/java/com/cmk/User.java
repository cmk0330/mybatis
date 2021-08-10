package com.cmk;

@ITable("db_user")
public class User {

    @IField(columnName = "db_name", type="varchar", length = 10)
    private String name;
    @IField(columnName = "db_age", type = "int", length = 10)
    private int age;
    @IField(columnName = "db_id", type = "int", length = 10)
    private int id;

    public User() {
    }

    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
