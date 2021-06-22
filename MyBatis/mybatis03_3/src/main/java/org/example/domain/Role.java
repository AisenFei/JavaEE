package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Role {

    private Integer roleId;
    private String roleName;
    private String roleDesc;

    //多对多的关系映射，一个角色可以赋予多个用户
    private List<User> users;
}
