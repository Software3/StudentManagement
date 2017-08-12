package org.csu.sm.domain;

import javax.persistence.*;

/**
 * Created by ltaoj on 2017/8/7.
 */
@Entity
@Table(name = "teacher", schema = "studentmanagement", catalog = "")
public class Teacher {
    @Column(name = "name")
    private String name;
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "majors")
    private String majors;
    @Column(name = "role")
    private int role;

    public Teacher() {
    }

    public Teacher(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        if (username != null ? !username.equals(teacher.username) : teacher.username != null) return false;
        if (password != null ? !password.equals(teacher.password) : teacher.password != null) return false;
        if (phone != null ? !phone.equals(teacher.phone) : teacher.phone != null) return false;
        if (email != null ? !email.equals(teacher.email) : teacher.email != null) return false;
        if (majors != null ? !majors.equals(teacher.majors) : teacher.majors != null) return false;
        if (role != teacher.role) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (majors != null ? majors.hashCode() : 0);
        result = 31 * result + role;
        return result;
    }
}
