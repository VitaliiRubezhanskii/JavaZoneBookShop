package ua.rubezhanskii.javabookshop.dto;

import ua.rubezhanskii.javabookshop.model.Book;
import ua.rubezhanskii.javabookshop.model.Customer;

public class CartItemDto {


    public CartItemDto() {
    }

    public CartItemDto(Book book, Customer customer) {
        this.book = book;
        this.customer = customer;
    }

    private Book book;
    private Customer customer;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}



