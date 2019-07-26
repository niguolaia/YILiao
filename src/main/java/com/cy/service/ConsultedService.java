package com.cy.service;

import com.cy.common.PageObject;
import com.cy.pojo.Consulted;

public interface ConsultedService {
PageObject<Consulted>findObject(String name,Integer pageCurrent);
int delectObject(Integer...ids);
int saveObject(Consulted consulted);
Consulted findById(Integer id);
}
