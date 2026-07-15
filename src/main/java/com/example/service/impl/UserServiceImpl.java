package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User Service Implementation
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    protected BaseDao<User, Long> getDao() {
        return userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findByStatus(Integer status) {
        return userDao.findByStatus(status);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> search(String keyword) {
        return userDao.search(keyword);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean login(String username, String password) {
        User user = findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
