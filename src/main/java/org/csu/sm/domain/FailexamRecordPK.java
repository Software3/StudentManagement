package org.csu.sm.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ltaoj on 2017/8/7.
 */
public class FailexamRecordPK implements Serializable {
    @Id
    @Column(name = "subject")
    private String subject;
    @Id
    @Column(name = "student_id")
    private long studentId;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

        FailexamRecordPK that = (FailexamRecordPK) o;

        if (studentId != that.studentId) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (int) (studentId ^ (studentId >>> 32));
        return result;
    }
}
