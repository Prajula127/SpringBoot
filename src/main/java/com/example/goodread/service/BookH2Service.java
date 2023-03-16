package com.example.goodread.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.goodread.model.*;
import com.example.goodread.repository.BookRepository;
import java.util.*;

@Service
public class BookH2Service implements BookRepository {
	@Autowired
	private JdbcTemplate db;
	
	@Override
	public ArrayList<Book> getBooks() {
		List<Book> bookList = db.query("select * from book", new BookRowMapper());
		ArrayList<Book> book = new ArrayList<>(bookList);
		return book;
	}
	
	@Override
	public Book getBookById(int bookId) {
		try {
			Book book = db.queryForObject("select * from book where bookId=?", new BookRowMapper(), bookId);
			return book;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public Book addBook(Book book) {
		db.update("insert into book(bookName, imageUrl) values(?,?)", book.getBookName(), book.getImageUrl());
		Book newBook = db.queryForObject("select * from book where bookName=?", new BookRowMapper(), book.getBookName());
		return newBook;
	}
	
	@Override
	public Book updateBook(int bookId, Book book) {
		if (book.getBookName() != null) {
			db.update("update book set bookName=? where bookId=?", book.getBookName(), bookId);
		}
		if (book.getImageUrl() != null) {
			db.update("update book set imageUrl=? where bookId=?", book.getImageUrl(), bookId);
		}
		return getBookById(bookId);
	}
	
	@Override
	public void deleteBook(int bookId) {
		db.update("delete from book where bookId=?", bookId);
	}

}
