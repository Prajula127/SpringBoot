package com.example.goodread.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.goodread.model.Book;
import com.example.goodread.service.BookH2Service;

@RestController
public class BookController {
	@Autowired
	public BookH2Service bookService;
	
	@GetMapping("/books")
	public ArrayList<Book> getBooks() {
		return bookService.getBooks();
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBookById(@PathVariable("bookId") int bookId) {
		return bookService.getBookById(bookId);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book) {
		return bookService.updateBook(bookId, book);
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		bookService.deleteBook(bookId);
	}
}
