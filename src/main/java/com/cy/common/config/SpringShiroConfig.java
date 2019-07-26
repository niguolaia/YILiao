package com.cy.common.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cy.service.realm.ShiroUserRealm;



@Configuration
public class SpringShiroConfig {
	@Bean("securityManager")
	public SecurityManager newSecurityManager(@Autowired ShiroUserRealm realm) {
		DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		return sManager;
	}
	@Bean("shiroFilterFactory")
	public ShiroFilterFactoryBean newShiroFilterFactoryBean(@Autowired SecurityManager securityManager) {
		ShiroFilterFactoryBean sfBean = new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		sfBean.setLoginUrl("/doLoginUI");
		LinkedHashMap<String,String>fm = new LinkedHashMap<>();
		 fm.put("/bower_components/**", "anon");
		    fm.put("/build/**", "anon");
		    fm.put("/dist/**", "anon");
		    fm.put("/plugins/**", "anon");
		    fm.put("/user/doLogin", "anon");
		    fm.put("/doLogout", "logout");
		    //设置必须认证才可以访问的资源
		    fm.put("/**", "user");
		sfBean.setFilterChainDefinitionMap(fm);
		return sfBean;
	}
	
}
