package com.example.demo.entity;

public class HaveBooks {
	private String UUID;
	private Books books;
	
	//无参构造
	public HaveBooks() {
		super();
	}
		
	//自定义的有参构造，super表示父类，this表示本类
	public HaveBooks(String uuid,Integer id, String bookname, Double prices, Integer counts, Integer typeid) {
		this.UUID = uuid;
		this.books = new Books(id,bookname,prices,counts,typeid);
	}
	
	
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "HaveBooks [UUID=" + UUID + ", books=" + books + "]";
	}
	public HaveBooks(String uUID) {
		super();
		UUID = uUID;
	}
	public HaveBooks(String uUID, Books books) {
		super();
		UUID = uUID;
		this.books = books;
	}
	
}
