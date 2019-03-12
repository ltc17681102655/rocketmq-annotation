package com.yang.springbootrocketmq.rest;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author yym
 * @Date 2019/2/23 16:58
 * @Description
 */
@Data
@Accessors(chain = true)
public class AAA implements Serializable {
    private static final long serialVersionUID = -5942492306459434617L;

    private String userId;

    private String threeOrderId;

    private Integer status;


}
