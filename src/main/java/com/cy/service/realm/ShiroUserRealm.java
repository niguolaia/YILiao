package com.cy.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.dao.UserDao;
import com.cy.pojo.User;
@Service
public class ShiroUserRealm extends AuthorizingRealm{
	@Autowired
	private UserDao userDao;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken=(UsernamePasswordToken) token;
		String username=upToken.getUsername();
		User user = userDao.findObjectByUsername(username);
		if(user==null)
			throw new UnknownAccountException("用户名不存在");
		if(user.getValid()==0)
			throw new LockedAccountException("该用户已被禁用");
		ByteSource credentialsSalt=ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt,getName());
		return info;
	}

		@Override
		public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
			HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
			cMatcher.setHashAlgorithmName("MD5");
			cMatcher.setHashIterations(1);
			super.setCredentialsMatcher(cMatcher);
		}
}
