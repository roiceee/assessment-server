package com.example.assessmentserver.service;

import com.example.assessmentserver.dto.UserInfoDTO;
import com.example.assessmentserver.entity.UserInfoEntity;
import com.example.assessmentserver.exception.InfoNotFoundException;
import com.example.assessmentserver.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserInfoService {
    private UserInfoRepository userInfoRepository;
    private ModelMapper modelMapper;

    public UserInfoDTO saveUserInfo(String userId, UserInfoDTO userInfoDTO) {

        UserInfoEntity userInfoEntity = userInfoRepository.findByUserId(userId).orElse(null);

        if (userInfoEntity == null) {
            userInfoEntity = new UserInfoEntity();
            userInfoEntity.setUserId(userId);
        }

        userInfoEntity.setAbout(userInfoDTO.getAbout());
        userInfoEntity.setPhoneNumber(userInfoDTO.getPhoneNumber());
        userInfoEntity = userInfoRepository.save(userInfoEntity);

        return convertToDto(userInfoEntity);
    }

    public UserInfoDTO getUserInfo(String userId) {
        UserInfoEntity userInfoEntity = userInfoRepository.findByUserId(userId).orElse(null);
        if (userInfoEntity == null) {
            throw new InfoNotFoundException();
        }
        return convertToDto(userInfoEntity);
    }

    private UserInfoDTO convertToDto(UserInfoEntity userInfoEntity) {
        return modelMapper.map(userInfoEntity, UserInfoDTO.class);
    }

}
