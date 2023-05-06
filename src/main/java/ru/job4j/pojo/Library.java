package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Philosophy Java", 1400);
        Book book2 = new Book("Professional library", 1200);
        Book book3 = new Book("Full manual", 1000);
        Book book4 = new Book("Clean code", 800);
        Book[] books = {book1, book2, book3, book4};
        for (int i = 0; i < books.length; i++) {
            System.out.println("The book \"" + books[i].getName() + "\" consist of "
                               + books[i].getPages() + " pages.");
        }
        System.out.println();
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println("The book \"" + books[i].getName() + "\" consist of "
                               + books[i].getPages() + " pages.");
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println("The book \"" + books[i].getName() + "\" consist of "
                                   + books[i].getPages() + " pages.");
            }
        }
    }
}
