/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author yupei
 */
public class BookDirectory {
    ArrayList<Book> bookDirectory = new ArrayList<>();
    
    public BookDirectory(){
        this.bookDirectory = new ArrayList<Book>();
    }

    public ArrayList<Book> getBookDirectory() {
        return bookDirectory;
    }

    public void setBookDirectory(ArrayList<Book> bookDirectory) {
        this.bookDirectory = bookDirectory;
    }
    
    public void delBook(Book book){
        bookDirectory.remove(book);
    }
    
    public void addBook(Book book){
        bookDirectory.add(book);
    }
}
