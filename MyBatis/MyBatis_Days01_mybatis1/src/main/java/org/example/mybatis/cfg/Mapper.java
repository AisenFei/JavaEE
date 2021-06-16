package org.example.mybatis.cfg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mapper {
    private String queryString;//sql
    private String resultType;//全限定类名
}
