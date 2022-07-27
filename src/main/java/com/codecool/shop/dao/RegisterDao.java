package com.codecool.shop.dao;

public interface RegisterDao {

    void registerUser(String name, String email, String password);

    void deleterUser(int id);

    void updateUser(int id, String newName, String newEmail, String newPassword);

}
