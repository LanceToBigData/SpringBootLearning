package com.lance.learn.springbootswagger.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author lance(ZYH)
 * @function Book实体类
 * @date 2018-07-09 21:37
 */
@Data
public class Book {
    private Long id;
    private String name;
    private Integer price;
    private String author;
    private Date publishDate;
}
