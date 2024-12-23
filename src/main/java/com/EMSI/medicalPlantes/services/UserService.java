package com.EMSI.medicalPlantes.services;

import com.EMSI.medicalPlantes.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
} 