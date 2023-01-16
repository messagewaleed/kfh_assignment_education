package com.waleed.training.students;

import com.waleed.training.courses.Course;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@ApiModel
public class Student {

    @Id
    @ApiModelProperty(notes = "id of the Student")
    private Integer id;

    @ApiModelProperty(notes = "english name of teh Student")
    private String nameInEnglish;

    @ApiModelProperty(notes = "arabic name of the Student")
    private String nameInArabic;

    @ApiModelProperty(notes = "email of the Student")
    private String email;

    @ApiModelProperty(notes = "phone number of the Student")
    private String phone;

    @ApiModelProperty(notes = "address of the Student")
    private String address;

    @ApiModelProperty(notes = "course of the Student")
    @ManyToOne // A Foriegn Key - Primary Key relationship
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student(Integer id, String nameInEnglish, String nameInArabic, String email, String phone, String address, Integer courseId) {
        this.id = id;
        this.nameInEnglish = nameInEnglish;
        this.nameInArabic = nameInArabic;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.course = new Course(courseId, "", "");
    }

    Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + nameInArabic + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameInEnglish() {
        return nameInEnglish;
    }

    public void setNameInEnglish(String nameInEnglish) {
        this.nameInEnglish = nameInEnglish;
    }

    public String getNameInArabic() {
        return nameInArabic;
    }

    public void setNameInArabic(String nameInArabic) {
        this.nameInArabic = nameInArabic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
