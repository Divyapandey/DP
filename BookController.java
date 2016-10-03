package com.spring.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Book;
import com.spring.services.BookService;
@Controller
public class BookController {
	@Autowired
private BookService bookService;

public BookService getBookService() {
	return bookService;
}

public void setBookService(BookService bookService) {
	this.bookService = bookService;
}
@RequestMapping("/getAllBooks")
public ModelAndView getAllProducts(){
	List<Book>books = bookService.getAllBooks();
	return new ModelAndView("booksList","books",books);
}
@RequestMapping("getBookByIsbn/{isbn}")
public ModelAndView getBookByIsbn(@PathVariable(value="isbn") int isbn){
     Book b=bookService.getBookByIsbn(isbn);
	return new ModelAndView("bookPage","bookObj",b);
}
@RequestMapping("/delete/{isbn}")
public String deleteBook(@PathVariable(value="isbn") int isbn){
	bookService.deleteBook(isbn);
	//http://localhost:8080/appname/getAllBooks
	return"redirect:/getAllBooks";
}

}



