package lt.techin.library.pt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookCatalogBenasO implements BookCatalog{

    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        if (book == null || book.getPublisher() == null || book.getTitle() == null || book.getAuthor() == null || book.getIsbn() == null) {
            throw new IllegalArgumentException("Neither book nor any of it's parameters can be null");
        } else if (books.stream().map(Book::getIsbn).toList().contains(book.getIsbn())) {}
        else if (book.getIsbn().trim().isEmpty() || book.getTitle().trim().isEmpty() || book.getAuthor().getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Neither book nor any of it's parameters can be empty");
        } else {
            books.add(book);
        }
    }

    @Override
    public int getTotalNumberOfBooks() {
        return books.size();
    }

    @Override
    public void printBookTitles() {
        books.stream().map(Book::getTitle).forEach(System.out::println);
    }

    @Override
    public void printTitlesOfBooksPublishedAfter(int i) {
        books.stream().filter(book -> book.getPublicationYear() > i).map(Book::getTitle).forEach(System.out::println);
    }

    @Override
    public Book getBookByIsbn(String s) {
        if (books.stream().filter(book -> book.getIsbn().contains(s)).findAny().isEmpty()) {
            throw new BookNotFoundException("Book not found");
        } else {
            return books.stream().filter(book -> book.getIsbn().contains(s)).findAny().orElse(null);
        }
    }

    @Override
    public List<Book> searchBooksByAuthor(String s) {
        return books.stream().filter(book -> book.getAuthor().getName().equals(s)).toList();
    }

    @Override
    public boolean isBookInCatalog(String s) {
        return books.stream().anyMatch(book -> book.getIsbn().equals(s));
    }

    @Override
    public boolean isBookAvailable(String s) {
        return books.stream().filter(book -> book.getIsbn().equals(s)).anyMatch(book -> book.isAvailable());
    }

    @Override
    public double calculateTotalPrice() {
        return books.stream().mapToDouble(Book::getPrice).sum();
    }

    @Override
    public double calculateAveragePrice() {
        return books.stream().mapToDouble(Book::getPrice).average().orElse(0);
    }

    @Override
    public List<Book> getSortedBooks() {
        return books.stream().sorted(Comparator.comparing(Book::getPublicationYear)).toList();
    }

    @Override
    public List<Book> searchBooksByTitleContaining(String s) {
        if(s.trim().isEmpty()){
            return List.of();
        } else {
            return books.stream().filter(book -> book.getTitle().toLowerCase().contains(s.toLowerCase())).toList();
        }
    }

    @Override
    public Book findNewestBookByPublisher(String s) {
        if (!books.stream().map(Book::getPublisher).toList().contains(s)) {
            throw new BookNotFoundException("There are no books by that author");
        } else {
            return books.stream().filter(book -> book.getPublisher().equals(s)).max(Comparator.comparing(Book::getPublicationYear)).orElse(null);
        }
    }

    @Override
    public List<Book> filterBooks(Predicate<Book> predicate) {
        return books;
    }

    @Override
    public Map<String, List<Book>> groupBooksByPublisher() {
        return books.stream().collect(Collectors.groupingBy(Book::getPublisher));
    }
}
