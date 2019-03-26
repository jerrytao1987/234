package privilege;

import static org.junit.Assert.*;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class Tutorial {
	public static void main(String[] args) {
		Ini config = new Ini();
		config.load(Tutorial.class.getClassLoader().getResourceAsStream("shiro.ini"));
		Factory factory = new IniSecurityManagerFactory(config );
		SecurityManager securityManager = (SecurityManager) factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute("user", "jerry");
		Object value = session.getAttribute("user");
		System.out.println(value);
		if(!subject.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
			token.setRememberMe(true);
			try {
				subject.login(token);
			} catch (UnknownAccountException e) {
				// TODO Auto-generated catch block
				System.out.println("There is no user with username of "+token.getPrincipal());
			} catch (IncorrectCredentialsException e) {
				// TODO: handle exception
				System.out.println("Password for account "+token.getPrincipal()+" was incorrect!");
			} catch (LockedAccountException e) {
				// TODO: handle exception
				System.out.println("The account for username " + token.getPrincipal() + " is locked. " +
						"Please contact your administrator to unlock it.");
			}
			// … catch more exceptions here (maybe custom ones specific to your application?
			catch (AuthenticationException e) {
				// TODO: handle exception
				//unexpected condition? error?
				System.out.println(token.getPrincipal());
			}
		}
		Object principal = subject.getPrincipal();
		System.out.println(principal);
		if(subject.hasRole("schwartz")){
			System.out.println("拥有schwartz角色");
		}else{
			System.out.println("没有拥有schwartz角色");
		}
		if(subject.isPermitted("lightsaber:weild")){
			System.out.println("拥有lightsaber:weild权限");
		}else{
			System.out.println("没有拥有lightsaber:weild权限");
		}
		if(subject.isPermitted("winnebago:drive:eagle5")){
			System.out.println("拥有winnebago:drive:eagle5权限");
		}else{
			System.out.println("没有拥有winnebago:drive:eagle5权限");
		}
		subject.logout();
		
	}
	@Test
	public void testName() throws Exception {
		/*Realm realm = null;
		DefaultSecurityManager securityManager = new DefaultSecurityManager(realm);
		CustomerDao sessionDao = new CustomerDao();
		DefaultSessionManager sessionManager = (DefaultSessionManager) securityManager.getSessionManager();
		sessionManager.setSessionDAO(sessionDAO);*/
		
	}
}