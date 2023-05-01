package com.spring.core.session05.aop;

public class ComputerImpl implements Computer {
	@Override
	public Integer add(Integer x, Integer y) {
		int result = x + y;
		return result;
	}

	@Override
	public Integer div(Integer x, Integer y) {
		int result = x / y;
		return result;
	}
}
