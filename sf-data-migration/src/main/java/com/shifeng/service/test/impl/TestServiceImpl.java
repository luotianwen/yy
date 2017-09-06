package com.shifeng.service.test.impl;

import org.springframework.stereotype.Service;

import com.shifeng.service.test.TestService;

@Service("testService")
public class TestServiceImpl implements TestService{
	
	public void test() {
		System.out.println("山东省第三方士大夫");
	}

}
