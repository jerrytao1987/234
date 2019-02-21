package cn.itcast.a_ognl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.itcast.bean.User;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class Demo {
	
	@Test
	public void fun1() throws OgnlException{
		User rootUser = new User("tom", 18);
		Map<String, User> context = new HashMap<String, User>();
		context.put("user1", new User("jack",18));
		context.put("user2", new User("rose",22));
		
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
	
		String name = (String) Ognl.getValue("name", oc, oc.getRoot());
		Integer age = (Integer) Ognl.getValue("age", oc, oc.getRoot());
		System.out.println(name);
		System.out.println(age);
	}
	
	@Test
	public void fun2() throws OgnlException{
		User rootUser = new User("tom", 18);
		Map<String, User> context = new HashMap<String, User>();
		context.put("user1", new User("jack",18));
		context.put("user2", new User("rose",22));
		
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
	
		String name = (String) Ognl.getValue("#user1.name", oc, oc.getRoot());
		String name2 = (String) Ognl.getValue("#user2.name", oc, oc.getRoot());
		Integer age = (Integer) Ognl.getValue("#user2.age", oc, oc.getRoot());
		System.out.println(name);
		System.out.println(name2);
		System.out.println(age);
	}
	
	@Test
	public void fun3() throws OgnlException{
		User rootUser = new User("tom", 18);
		Map<String, User> context = new HashMap<String, User>();
		context.put("user1", new User("jack",18));
		context.put("user2", new User("rose",22));
		
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
	
		Ognl.getValue("name='jerry'", oc, oc.getRoot());
		String name = (String) Ognl.getValue("name", oc, oc.getRoot());
		System.out.println(name);
		
		String name2 = (String) Ognl.getValue("#user1.name='郝老师',#user1.name", oc, oc.getRoot());
		System.out.println(name2);
	}
	
	@Test
	public void fun4() throws OgnlException{
		User rootUser = new User("tom", 18);
		Map<String, User> context = new HashMap<String, User>();
		context.put("user1", new User("jack",18));
		context.put("user2", new User("rose",22));
		
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
	
		Ognl.getValue("setName('lilei')", oc, oc.getRoot());
		String name = (String) Ognl.getValue("getName()", oc, oc.getRoot());
		System.out.println(name);
		
		String name2 = (String) Ognl.getValue("#user1.setName('lucy'),#user1.name", oc, oc.getRoot());
		System.out.println(name2);
	}
	
	@Test
	public void fun5() throws OgnlException{
		User rootUser = new User("tom", 18);
		Map<String, User> context = new HashMap<String, User>();
		context.put("user1", new User("jack",18));
		context.put("user2", new User("rose",22));
		
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
	
		String name = (String) Ognl.getValue("@cn.itcast.a_ognl.HahaUtils@echo('hello')", oc, oc.getRoot());
//		Double pi = (Double) Ognl.getValue("@java.lang.Math@PI", oc, oc.getRoot());
//		Double pi = (Double) Ognl.getValue("@Math@PI", oc, oc.getRoot());
		Double pi = (Double) Ognl.getValue("@@PI", oc, oc.getRoot());
		System.out.println(name);
		System.out.println(pi);
	}
	
	/**
	 * @throws OgnlException
	 */
	@Test
	public void fun6() throws OgnlException{
		User rootUser = new User("tom", 18);
		Map<String, User> context = new HashMap<String, User>();
//		context.put("user1", new User("jack",18));
//		context.put("user2", new User("rose",22));
		
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
	
		Integer size = (Integer) Ognl.getValue("{'tom','jerry','jack','rose'}.size()", oc, oc.getRoot());
		String name = (String) Ognl.getValue("{'tom','jerry','jack','rose'}[0]", oc, oc.getRoot());
		String name2 = (String) Ognl.getValue("{'tom','jerry','jack','rose'}.get(1)", oc, oc.getRoot());
//		System.out.println(size);
//		System.out.println(name);
//		System.out.println(name2);

		Integer size2 = (Integer) Ognl.getValue("#{'name':'tom','age':18}.size()", oc, oc.getRoot());
		String name3 = (String) Ognl.getValue("#{'name':'tom','age':18}['name']", oc, oc.getRoot());
		Integer age = (Integer) Ognl.getValue("#{'name':'tom','age':18}.get('age')", oc, oc.getRoot());
		System.out.println(size2);
		System.out.println(name3);
		System.out.println(age);
	}
}
