package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }
}