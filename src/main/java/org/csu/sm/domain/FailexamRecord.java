package org.csu.sm.domain;

import javax.persistence.*;

/**
 * Created by ltaoj on 2017/8/7.
 */
@Entity
@Table(name = "failexam_record", schema = "studentmanagement", catalog = "")
@IdClass(FailexamRecordPK.class)
public class FailexamRecord {
    @Column(name = "term")
    private String term;
    @Id
    @Column(name = "subject")
    private String subject;
    @Id
    @Column(name = "student_id")
    private long studentId;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

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

        FailexamRecord that = (FailexamRecord) o;

        if (studentId != that.studentId) return false;
        if (term != null ? !term.equals(that.term) : that.term != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = term != null ? term.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (int) (studentId ^ (studentId >>> 32));
        return result;
    }
}
