package com.example.assessmentserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "user_info")
public class UserInfoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "about")
    private String about;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "user_id")
    private String userId;

    public UserInfoEntity() {
    }

    public UserInfoEntity(String about, String phoneNumber, String userId) {
        this.about = about;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoEntity that = (UserInfoEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getAbout(), that.getAbout()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAbout(), getPhoneNumber(), getUserId());
    }
}
