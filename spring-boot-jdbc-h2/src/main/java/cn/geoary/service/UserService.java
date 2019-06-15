package cn.geoary.service;

import cn.geoary.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getOneById(Integer id);
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(Integer id);
}
