package org.csu.sm.domain;

import javax.persistence.*;

/**
 * Created by ltaoj on 2017/8/7.
 */
@Entity
@Table(name = "signon", schema = "studentmanagement", catalog = "")
public class Signon {
    @Id
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "password")
    private String password;

    public Signon(long studentId, String password) {
        this.studentId = studentId;
        this.password = password;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Signon signon = (Signon) o;

        if (studentId != signon.studentId) return false;
        if (password != null ? !password.equals(signon.password) : signon.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (studentId ^ (studentId >>> 32));
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
