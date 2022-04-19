package com.test.entity;


public class Student {
    private String student_id;
    private String name;
    private String gender;
    private Integer age;
    private String birthday;
    private String contact;
    private String email;
    private String classes;
    private String hobby;

    public Student(String student_id, String name, String gender, Integer age, String birthday,
                   String contact, String email, String classes, String hobby) {

        this.student_id = student_id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.contact = contact;
        this.email = email;
        this.classes = classes;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", student_id='" + student_id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", classes='" + classes + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = this.birthday;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
