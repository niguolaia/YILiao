package com.cy.common;

import java.io.Serializable;

import lombok.Data;
@Data
public class Node implements Serializable{
	private static final long serialVersionUID = -7113860169775232693L;
private Integer id;
private String name;
private Integer parentid;
}
