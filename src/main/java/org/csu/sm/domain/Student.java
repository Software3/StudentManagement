package org.csu.sm.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ltaoj on 2017/8/7.
 */
@Entity
@Table(name = "student", schema = "studentmanagement", catalog = "")
public class Student {
    @Id
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private int sex;
    @Column(name = "residence")
    private String residence;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "native_place")
    private String nativePlace;
    @Column(name = "major")
    private String major;
    @Column(name = "employment_unit")
    private String employmentUnit;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "counselor_name")
    private String counselorName;
    @Column(name = "counselor_phone")
    private String counselorPhone;
    @Column(name = "student_type")
    private String studentType;
    @Column(name = "verify_state")
    private int verifyState;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmploymentUnit() {
        return employmentUnit;
    }

    public void setEmploymentUnit(String employmentUnit) {
        this.employmentUnit = employmentUnit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCounselorName() {
        return counselorName;
    }

    public void setCounselorName(String counselorName) {
        this.counselorName = counselorName;
    }

    public String getCounselorPhone() {
        return counselorPhone;
    }

    public void setCounselorPhone(String counselorPhone) {
        this.counselorPhone = counselorPhone;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public int getVerifyState() {
        return verifyState;
    }

    public void setVerifyState(int verifyState) {
        this.verifyState = verifyState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != student.studentId) return false;
        if (sex != student.sex) return false;
        if (verifyState != student.verifyState) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (residence != null ? !residence.equals(student.residence) : student.residence != null) return false;
        if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null) return false;
        if (nativePlace != null ? !nativePlace.equals(student.nativePlace) : student.nativePlace != null) return false;
        if (major != null ? !major.equals(student.major) : student.major != null) return false;
        if (employmentUnit != null ? !employmentUnit.equals(student.employmentUnit) : student.employmentUnit != null)
            return false;
        if (remarks != null ? !remarks.equals(student.remarks) : student.remarks != null) return false;
        if (counselorName != null ? !counselorName.equals(student.counselorName) : student.counselorName != null)
            return false;
        if (counselorPhone != null ? !counselorPhone.equals(student.counselorPhone) : student.counselorPhone != null)
            return false;
        if (studentType != null ? !studentType.equals(student.studentType) : student.studentType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (studentId ^ (studentId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + sex;
        result = 31 * result + (residence != null ? residence.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (nativePlace != null ? nativePlace.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (employmentUnit != null ? employmentUnit.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (counselorName != null ? counselorName.hashCode() : 0);
        result = 31 * result + (counselorPhone != null ? counselorPhone.hashCode() : 0);
        result = 31 * result + (studentType != null ? studentType.hashCode() : 0);
        result = 31 * result + verifyState;
        return result;
    }
}
