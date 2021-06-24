package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;

    //多对一(mybatis中称之为一对一)的映射，一个账户只能属于一个用户
    private User user;
}
