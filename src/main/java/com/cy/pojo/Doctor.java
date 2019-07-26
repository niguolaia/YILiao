package com.cy.pojo;

import java.io.Serializable;


import lombok.Data;
@Data
public class Doctor implements Serializable{
private static final long serialVersionUID = -7281489642715101011L;
private String id;
private String name;
private String gender;
private String tel;
//@DateTimeFormat(pattern = "yyyy-MM-dd")
private String entrydate;
private String email;
private String job;






}
