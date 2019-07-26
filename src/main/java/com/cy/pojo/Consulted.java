package com.cy.pojo;

import java.io.Serializable;
import lombok.Data;

@Data
public class Consulted implements Serializable{
	private static final long serialVersionUID = -7329067314747282407L;
private Integer id;
private String name;
private String gender;
private String age;
private String tel;
//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
private String querytime;
private String remark;
}
