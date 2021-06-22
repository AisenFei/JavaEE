package org.example.dao;

import org.example.domain.Role;

import java.util.List;

public interface IRoleDao {

    List<Role> findAll();
}
