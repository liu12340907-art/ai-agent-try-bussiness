package com.example.service;

import com.example.model.User;

import java.util.List;

/**
 * User Service Interface
 */
public interface UserService extends BaseService<User, Long> {

    /**
     * Find user by username
     */
    User findByUsername(String username);

    /**
     * Find users by status
     */
    List<User> findByStatus(Integer status);

    /**
     * Search users by keyword
     */
    List<User> search(String keyword);

    /**
     * Validate login
     */
    boolean login(String username, String password);
}
