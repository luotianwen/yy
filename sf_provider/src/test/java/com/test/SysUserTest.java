package com.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shifeng.provide.solr.SolrService;

 

public class SysUserTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "META-INF/spring/applicationContext.xml" });
		context.start();
		System.out.println("服务启动成功！！！");
		SolrService solrService = (SolrService)context.getBean("solrService");
		solrService.dataFullImport();
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
