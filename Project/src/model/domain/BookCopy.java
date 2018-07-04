package model.domain;

import java.io.Serializable;

/**
 * Immutable class
 */
final public class BookCopy implements Serializable {

	private static final long serialVersionUID = -63976228084869815L;
	private Book book;
	private int copyNum;
	private String exists;

	private boolean isAvailable;

	BookCopy(Book book, int copyNum) {
		this.book = book;
		this.copyNum = copyNum;
	}

	BookCopy(Book book, int copyNum, boolean isAvailable) {
		this.book = book;
		this.copyNum = copyNum;
		this.isAvailable = isAvailable;
	}

	public String Available() {
		return isAvailable ? "Yes" : "No";
	}

	public void changeAvailability() {
		isAvailable = !isAvailable;
	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if (!(ob instanceof BookCopy))
			return false;
		BookCopy copy = (BookCopy) ob;
		return copy.book.getIsbn().equals(book.getIsbn()) && copy.copyNum == copyNum;
	}

	public Book getBook() {
		return book;
	}

	public int getCopyNum() {
		return copyNum;
	}

	public String getExists() {
		return this.Available();
	}

	public boolean getisAvailable() {
		return isAvailable;
	}

	@Override
	public String toString() {
		return "BookCopy [book=" + book + ", copyNum=" + copyNum + ", isAvailable=" + isAvailable + "]";
	}

}
