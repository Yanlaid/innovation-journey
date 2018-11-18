package cn.shen.springdemo2.pojo;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "sp_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sp_id")
    private Long spId;
    @Column(name = "sp_username")
    private String spUsername;
    @Column(name = "sp_password")
    private Long spPassword;
    @Column(name = "sp_address")
    private String spAddress;

}
