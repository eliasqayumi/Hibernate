package com.Hibernate.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @Column(name = "faculty_id")
    private int facultyId;

    @Column(name = "faculty_name")
    private String facultyName;

    public Faculty(int facultyID, String facultyName) {
        this.facultyId = facultyID;
        this.facultyName = facultyName;
    }

    public Faculty() {
    }


    @Basic
    @Column(name = "faculty_name")
    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Column(name = "faculty_id")
    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return facultyId == faculty.facultyId && Objects.equals(facultyName, faculty.facultyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, facultyName);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }
}
