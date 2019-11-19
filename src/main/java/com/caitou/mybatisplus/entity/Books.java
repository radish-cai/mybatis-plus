package com.caitou.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Mr.caitou
 * @since 2019-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("BNO")
    private Integer bno;

    @TableField("BNAME")
    private String bname;

    @TableField("AUTHOR")
    private String author;

    @TableField("PRICE")
    private Integer price;

    @TableField("QUANTITY")
    private Integer quantity;


}
