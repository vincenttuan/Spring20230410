package com.spring.core.session02.bean;

public class Paper {
	private Integer id; // 紙張編號 
	private Color color2; // 紙張顏色
	private Size size2; // 紙張尺寸 
	
	public Paper() {
	
	}

	public Paper(Color color, Size size) {
		this.color2 = color;
		this.size2 = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
	}

	public Size getSize2() {
		return size2;
	}

	public void setSize2(Size size2) {
		this.size2 = size2;
	}

	@Override
	public String toString() {
		return "Paper [id=" + id + ", color2=" + color2 + ", size2=" + size2 + "]";
	}

	
	
	
	
	
	
}
