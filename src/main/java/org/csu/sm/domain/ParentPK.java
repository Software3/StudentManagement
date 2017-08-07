package org.csu.sm.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ltaoj on 2017/8/7.
 */
public class ParentPK implements Serializable {
    @Id
    @Column(name = "name")
    private String name;
    @Id
    @Column(name = "student_id")
    private long studentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        ParentPK parentPK = (ParentPK) o;

        if (studentId != parentPK.studentId) return false;
        if (name != null ? !name.equals(parentPK.name) : parentPK.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (int) (studentId ^ (studentId >>> 32));
        return result;
    }
}
