package com.EMSI.medicalPlantes.services.impl;

import com.EMSI.medicalPlantes.dto.UserDTO;
import com.EMSI.medicalPlantes.models.User;
import com.EMSI.medicalPlantes.repositories.UserRepository;
import com.EMSI.medicalPlantes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setFullName(userDTO.getFullName());
        user.setRole(userDTO.getRole());

        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getUsername().equals(userDTO.getUsername()) &&
                userRepository.existsByUsername(userDTO.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (!user.getEmail().equals(userDTO.getEmail()) &&
                userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        user.setUsername(userDTO.getUsername());
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        user.setEmail(userDTO.getEmail());
        user.setFullName(userDTO.getFullName());
        user.setRole(userDTO.getRole());

        User updatedUser = userRepository.save(user);
        return convertToDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setRole(user.getRole());
        return dto;
    }
} 