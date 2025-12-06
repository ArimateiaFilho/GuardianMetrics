package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return repository.save(user);
    }

    public List<User> list() {
        return repository.findAll();
    }

    public User get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User update(Long id, User request) {
        User u = get(id);
        u.setLogin(request.getLogin());
        u.setPassword(request.getPassword());
        return repository.save(u);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
