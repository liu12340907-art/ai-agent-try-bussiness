package com.example.action;

import com.example.model.User;
import com.example.service.UserService;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User Action
 */
@Controller
@Scope("prototype")
@ParentPackage("default")
public class UserAction {

    @Autowired
    private UserService userService;

    // Request parameters
    private User user;
    private Long id;
    private String keyword;
    private Integer page = 1;
    private Integer pageSize = 10;

    // Response data
    private List<User> userList;
    private Map<String, Object> dataMap = new HashMap<>();

    // ==================== Actions ====================

    /**
     * List all users
     */
    public String list() {
        if (keyword != null && !keyword.trim().isEmpty()) {
            userList = userService.search(keyword);
        } else {
            userList = userService.findAll();
        }
        return "list";
    }

    /**
     * Show add form
     */
    public String add() {
        return "add";
    }

    /**
     * Save user
     */
    public String save() {
        try {
            userService.save(user);
            dataMap.put("success", true);
            dataMap.put("message", "用户添加成功");
        } catch (Exception e) {
            dataMap.put("success", false);
            dataMap.put("message", "用户添加失败: " + e.getMessage());
        }
        return "json";
    }

    /**
     * Show edit form
     */
    public String edit() {
        user = userService.findById(id);
        return "edit";
    }

    /**
     * Update user
     */
    public String update() {
        try {
            userService.update(user);
            dataMap.put("success", true);
            dataMap.put("message", "用户更新成功");
        } catch (Exception e) {
            dataMap.put("success", false);
            dataMap.put("message", "用户更新失败: " + e.getMessage());
        }
        return "json";
    }

    /**
     * Delete user
     */
    public String delete() {
        try {
            userService.deleteById(id);
            dataMap.put("success", true);
            dataMap.put("message", "用户删除成功");
        } catch (Exception e) {
            dataMap.put("success", false);
            dataMap.put("message", "用户删除失败: " + e.getMessage());
        }
        return "json";
    }

    /**
     * User login
     */
    public String login() {
        boolean success = userService.login(user.getUsername(), user.getPassword());
        if (success) {
            dataMap.put("success", true);
            dataMap.put("message", "登录成功");
        } else {
            dataMap.put("success", false);
            dataMap.put("message", "用户名或密码错误");
        }
        return "json";
    }

    // ==================== Getters and Setters ====================

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }
}
