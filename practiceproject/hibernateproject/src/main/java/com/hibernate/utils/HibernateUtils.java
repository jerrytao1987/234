package com.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	static{
		Configuration cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}
	private HibernateUtils(){
		throw new AssertionError();
	}
	public static Session getCurrentSession() {
		return sf.getCurrentSession();
	}
	public static Session getSession() {
		return sf.openSession();
	}
}
