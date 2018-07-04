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

	public String getExists() {
		return this.Available();
	}

	private boolean isAvailable;

	public String Available() {
		return isAvailable ? "Yes" : "No";
	}

	public boolean getisAvailable() {
		return isAvailable;
	}

	BookCopy(Book book, int copyNum, boolean isAvailable) {
		this.book = book;
		this.copyNum = copyNum;
		this.isAvailable = isAvailable;
	}

	BookCopy(Book book, int copyNum) {
		this.book = book;
		this.copyNum = copyNum;
	}

	public int getCopyNum() {
		return copyNum;
	}

	public String getBook() {
		return book.getIsbn();
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

	@Override
	public String toString() {
		return "BookCopy [book=" + book + ", copyNum=" + copyNum + ", isAvailable=" + isAvailable + "]";
	}

}
