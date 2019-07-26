package com.cy.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	private static final long serialVersionUID = -6957194402755032142L;
private Integer id;
private String username;
private String password;
private String salt;
private String email;
private Integer valid=1;
private String createdTime;
private String moble;
}
