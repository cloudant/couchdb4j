package com.fourspaces.couchdb.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import com.fourspaces.couchdb.Session;

public class TestSession {
	public static Session getTestSession() {
		Properties props = new Properties();
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("couchdb-test.properties");
			props.load(is);
			if (props.getProperty("user") != null && props.getProperty("password") != null) {
				return new Session(props.getProperty("host"),Integer.parseInt(props.getProperty("port")),props.getProperty("user"),props.getProperty("password"));
			} else {
				return new Session(props.getProperty("host"),Integer.parseInt(props.getProperty("port")));
}
		} catch (Exception e) {
			System.out.println("Cannot find properties file");
			return new Session("localhost",5984);
			//throw new RuntimeException(e);
		}		
	}
	@Test
	public void noop() {} // just to avoid junit warning
}
