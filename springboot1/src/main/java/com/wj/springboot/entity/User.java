package com.wj.springboot.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class User  implements Serializable {

	private static final long serialVersionUID =  2500630822646188094L;

	/**
	 * 用户id
	 */
   
	private Long id;

	/**
	 * 用户名称
	 */
	private String name;

	/**
	 * 用户年龄
	 */
	private Long age;

}
