package de.ait.shop43.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<UserResponseDto> getUsers();
//    public UserResponseDto getUserById(Long id);
    public UserResponseDto createUser(UserRequestDto dto);
    public UserResponseDto setAdminRole(String username);
}
