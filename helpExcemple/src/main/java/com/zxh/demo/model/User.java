package com.zxh.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

//import javax.persistence.Column;
//import javax.persistence.Table;

//import org.hibernate.validator.constraints.Length;

/**
 * @author: znn
 * @date: 2020/08/2020/8/5
 * @description
 */
@Data
@Entity
//@Table(name = "T_B_USER")
public class User implements Serializable {
    private static final long serialVersionUID = 6348405580193443868L;
    /**
     * 手机号
     */
    @Id
    //@Length
    //@Column(name = "USER_ID", unique = true, nullable = false, columnDefinition = "VARCHAR(32)")
    private String userId;
    /**
     * 用户姓名
     */

    private String loginName;
}
