package com.example.demo.domain.DTO;

import com.example.demo.domain.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
