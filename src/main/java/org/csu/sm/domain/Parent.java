package org.csu.sm.domain;

import javax.persistence.*;

/**
 * Created by ltaoj on 2017/8/7.
 */
@Entity
@Table(name = "parent", schema = "studentmanagement", catalog = "")
@IdClass(ParentPK.class)
public class Parent {
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "relation")
    private int relation;
    @Id
    @Column(name = "student_id")
    private long studentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parent parent = (Parent) o;

        if (relation != parent.relation) return false;
        if (studentId != parent.studentId) return false;
        if (name != null ? !name.equals(parent.name) : parent.name != null) return false;
        if (phone != null ? !phone.equals(parent.phone) : parent.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + relation;
        result = 31 * result + (int) (studentId ^ (studentId >>> 32));
        return result;
    }
}
