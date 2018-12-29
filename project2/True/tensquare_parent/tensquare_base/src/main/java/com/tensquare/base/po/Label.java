package com.tensquare.base.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jeff Shen
 * 标签实体类
 */
@Data
@Entity
@Table(name = "tb_label")
public class Label {
    @Id
    private String id;//OID编号
    private String labelname;//标签名称
    private String state;//状态
    private Long count;//使用数量
    private Long fans;//关注数
    private String recommend;//是否推荐
}
