package org.csu.sm.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ltaoj on 2017/8/7.
 */
@Entity
@Table(name = "award_record", schema = "studentmanagement", catalog = "")
@IdClass(AwardRecordPK.class)
public class AwardRecord {
    @Id
    @Column(name = "content")
    private String content;
    @Id
    @Column(name = "date")
    private Date date;
    @Id
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "degree")
    private String degree;
    @Column(name = "level")
    private String level;
    @Column(name = "rank")
    private int rank;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AwardRecord that = (AwardRecord) o;

        if (studentId != that.studentId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (degree != null ? degree.equals(that.degree) : that.degree != null) return false;
        if (level != null ? level.equals(that.level) : that.level != null) return false;
        if (rank != that.rank) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (int) (studentId ^ (studentId >>> 32));
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + rank;
        return result;
    }
}
