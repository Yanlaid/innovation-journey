package cn.shen.domain;

import lombok.Data;

@Data
public class User {
    String username;
    Integer age;
    Boolean isMarry;
    Double income;
    String[] hobby;
}
