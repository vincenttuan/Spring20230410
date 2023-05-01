package com.spring.core.session05.aop_lab;

// 幕後歌者 
public class BackSinger implements Singer {

	@Override
	public void sing() {
		System.out.println("啦啦啦~~");
	}
	
}
