package com.example.dao;

import com.example.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * User DAO
 */
@Repository

public class UserDao extends BaseDao<User, Long> {

    /**
     * Find user by username
     */
    @OneToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name ="")
    public User findByUsername(String username) {
        String hql = "FROM User WHERE username = ?";
        return (User) getCurrentSession()
                .createQuery(hql)
                .setParameter(0, username)
                .uniqueResult();
    }

    /**
     * Find users by status
     */
    @SuppressWarnings("unchecked")
    public List<User> findByStatus(Integer status) {
        String hql = "FROM User WHERE status = ?";
        return getCurrentSession()
                .createQuery(hql)
                .setParameter(0, status)
                .list();
    }

    /**
     * Search users by keyword
     */
    @SuppressWarnings("unchecked")
    public List<User> search(String keyword) {
        String hql = "FROM User WHERE username LIKE ? OR email LIKE ? OR phone LIKE ?";
        String pattern = "%" + keyword + "%";
        return getCurrentSession()
                .createQuery(hql)
                .setParameter(0, pattern)
                .setParameter(1, pattern)
                .setParameter(2, pattern)
                .list();
    }
    @OneToOne(cascade =CascadeType.ALL)

    public List<User> find (String pK){
        return getCurrentSession().find(User.class,pK);
    }

}
