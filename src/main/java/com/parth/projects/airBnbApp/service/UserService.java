package com.parth.projects.airBnbApp.service;

import com.parth.projects.airBnbApp.dto.ProfileUpdateRequestDto;
import com.parth.projects.airBnbApp.dto.UserDto;
import com.parth.projects.airBnbApp.entity.User;

public interface UserService {

    User getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);

    UserDto getMyProfile();
}
