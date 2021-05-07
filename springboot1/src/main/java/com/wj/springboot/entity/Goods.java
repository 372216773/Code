package com.wj.springboot.entity;

import java.io.Serializable;
import lombok.Data;
import java.util.Date;

@Data
public class Goods  implements Serializable {

	private static final long serialVersionUID =  8029784836099318506L;

	/**
	 * 商品ID
	 */
   
	private String id;

	/**
	 * 商品名称
	 */
	private String title;

	/**
	 * 商品描述表
	 */
	private String description;

	/**
	 * 商品价格(分)
	 */
	private Long price;

	/**
	 * 商品图片
	 */
	private String image;

	/**
	 * 商品规格
	 */
	private String spec;

	/**
	 * 商品详情
	 */
	private String detail;

	/**
	 * 分类id
	 */
	private String categoryId;

	/**
	 * 商品创建时间
	 */
	private Date gmtCreate;

}
