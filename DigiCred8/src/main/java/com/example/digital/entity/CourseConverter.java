package com.example.digital.entity;

import java.util.Objects;

public class CourseConverter {


    private String institute;
    private String course;
    private String subjectName;
    private String courseDuration;
    private String courseName;

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseConverter)) return false;
        CourseConverter that = (CourseConverter) o;
        return Objects.equals(getInstitute(), that.getInstitute()) &&
                Objects.equals(getCourse(), that.getCourse()) &&
                Objects.equals(getCourseDuration(), that.getCourseDuration());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getInstitute(), getCourse(), getCourseDuration());
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
