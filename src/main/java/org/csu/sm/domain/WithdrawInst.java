package org.csu.sm.domain;

import javax.persistence.*;

/**
 * Created by ltaoj on 2017/8/7.
 */
@Entity
@Table(name = "withdraw_inst", schema = "studentmanagement", catalog = "")
public class WithdrawInst {
    @Id
    @Column(name = "inst_id")
    private int instId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "describe")
    private String describe;
    @Column(name = "student_id")
    private long studentId;

    public int getInstId() {
        return instId;
    }

    public void setInstId(int instId) {
        this.instId = instId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
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

        WithdrawInst that = (WithdrawInst) o;

        if (instId != that.instId) return false;
        if (studentId != that.studentId) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (describe != null ? !describe.equals(that.describe) : that.describe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = instId;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (describe != null ? describe.hashCode() : 0);
        result = 31 * result + (int) (studentId ^ (studentId >>> 32));
        return result;
    }
}
