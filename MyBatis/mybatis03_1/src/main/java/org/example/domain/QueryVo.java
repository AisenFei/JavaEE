package org.example.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class QueryVo {
    //假如我们需要使用到user中的一些属性，还有List集合，现在将它们俩一起封装起来
    private User user;
    private List<Integer> ids;

}
