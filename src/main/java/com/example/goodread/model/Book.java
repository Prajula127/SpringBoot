package com.example.goodread.model;

public class Book {
	private int bookId;
	private String bookName;
	private String imageUrl;
	
	public Book(int bookId, String bookName, String imageUrl) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.imageUrl = imageUrl;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
