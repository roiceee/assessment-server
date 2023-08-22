package com.example.assessmentserver.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class UserInfoDTO {

        private String about;

        private String phoneNumber;

        public UserInfoDTO() {
        }

        public UserInfoDTO(String about, String phoneNumber) {
            this.about = about;
            this.phoneNumber = phoneNumber;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoDTO that = (UserInfoDTO) o;
        return Objects.equals(getAbout(), that.getAbout()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAbout(), getPhoneNumber());
    }
}
