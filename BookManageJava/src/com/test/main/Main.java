package com.test.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
	public class Book{
		private String bookId;
		private String bookTitle;
		private String bookYear;
		public String getBookId() {
			return bookId;
		}
		public void setBookId(String bookId) {
			this.bookId = bookId;
		}
		public String getBookTitle() {
			return bookTitle;
		}
		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}
		public String getBookYear() {
			return bookYear;
		}
		public void setBookYear(String bookYear) {
			this.bookYear = bookYear;
		}
	}
	
	public static void main(String... args){
		BufferedReader br = null;
		try{
			Main m = new Main();
			Map<String,Book> bookCollection = new LinkedHashMap<String,Book>();
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the number of books : ");
			String numberOfBooksStr = br.readLine();
			int numberOfBooks = Integer.parseInt(numberOfBooksStr);
			for(int i=0;i<numberOfBooks;i++){
				Book GeneraterdBook = m.doGenerateBookObject(br);
				m.addBookToCollection(GeneraterdBook, bookCollection);
			}
			
			String terminateKey = "";
			do{
				System.out.print("Enter book id for searching : ");
				String bookId = br.readLine();
				Book bookInfo = bookCollection.get(bookId);
				if(bookInfo !=null){
					m.doPrintBookInfo(bookInfo);
				}else{
					System.out.println("Book id "+bookId +" not found");
				}
				System.out.print("Do you want to search again(Y/N) ");
				terminateKey = br.readLine();
			}while(!terminateKey.equalsIgnoreCase("N"));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void doPrintBookInfo(Book book){
		System.out.println("BookId : "+book.getBookId());
		System.out.println("Title : "+book.getBookTitle());
		System.out.println("Year : "+book.getBookYear());
	}
	
	public Book doGenerateBookObject(BufferedReader br) throws Exception{
		Book book = new Book();
		String input = "";
		System.out.print("Enter book id:");
		input = br.readLine();
		book.setBookId(input);
		System.out.print("Enter book title:");
		input = br.readLine();
		book.setBookTitle(input);
		System.out.print("Enter year:");
		input = br.readLine();
		book.setBookYear(input);
		return book;
	}
	
	public void addBookToCollection(Book bookData, Map<String,Book> bookCollection){
		bookCollection.put(bookData.getBookId(), bookData);
	}
}