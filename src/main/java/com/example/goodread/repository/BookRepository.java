package com.example.goodread.repository;

import java.util.ArrayList;

import com.example.goodread.model.Book;

public interface BookRepository {
	ArrayList<Book> getBooks();
	Book getBookById(int bookId);
	Book addBook(Book book);
	Book updateBook(int bookId, Book book);
	void deleteBook(int bookId);
}
