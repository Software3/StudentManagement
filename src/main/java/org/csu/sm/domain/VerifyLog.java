package org.csu.sm.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ltaoj on 2017/8/7.
 */
@Entity
@Table(name = "verify_log", schema = "studentmanagement", catalog = "")
public class VerifyLog {
    @Id
    @Column(name = "log_id")
    private long logId;
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "counselor_name")
    private String counselorName;
    @Column(name = "verify_operate")
    private int verifyOperate;
    @Column(name = "date")
    private Date date;

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCounselorName() {
        return counselorName;
    }

    public void setCounselorName(String counselorName) {
        this.counselorName = counselorName;
    }

    public int getVerifyOperate() {
        return verifyOperate;
    }

    public void setVerifyOperate(int verifyOperate) {
        this.verifyOperate = verifyOperate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerifyLog verifyLog = (VerifyLog) o;

        if (logId != verifyLog.logId) return false;
        if (studentId != verifyLog.studentId) return false;
        if (verifyOperate != verifyLog.verifyOperate) return false;
        if (studentName != null ? !studentName.equals(verifyLog.studentName) : verifyLog.studentName != null)
            return false;
        if (counselorName != null ? !counselorName.equals(verifyLog.counselorName) : verifyLog.counselorName != null)
            return false;
        if (date != null ? !date.equals(verifyLog.date) : verifyLog.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (logId ^ (logId >>> 32));
        result = 31 * result + (int) (studentId ^ (studentId >>> 32));
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (counselorName != null ? counselorName.hashCode() : 0);
        result = 31 * result + verifyOperate;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
