/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author yupei
 */
public class ConfigureABusiness {

    public static Business Initialize(String n) {
        Business b = new Business(n);
        BookDirectory bd = b.getBookDirectory();
        OrderDirectory od = b.getOrderDirectory();
        UserDirectory ud = b.getUserDirectory();

        Book b1 = new Book();
        b1.setId(1);
        b1.setBookName("Java核心技术");
        b1.setLocation("北京");
        b1.setStatus("已借出");

        Book b2 = new Book();
        b2.setId(2);
        b2.setBookName("Java核心技术2");
        b2.setLocation("北京");
        b2.setStatus("未借出");

        Book b3 = new Book();
        b3.setId(3);
        b3.setBookName("Java核心技术3");
        b3.setLocation("上海");
        b3.setStatus("未借出");

        Book b4 = new Book();
        b4.setId(4);
        b4.setBookName("Java核心技术4");
        b4.setLocation("上海");
        b4.setStatus("未借出");

        bd.addBook(b1);
        bd.addBook(b2);
        bd.addBook(b3);
        bd.addBook(b4);

        User u1 = new User();
        u1.setBalance(500);
        u1.setUserPhoneNum("123");
        u1.setIdentify("用户");

        User u2 = new User();
        u2.setBalance(500);
        u2.setUserPhoneNum("321");
        u2.setIdentify("admin");
        
        User u3 = new User();
        u3.setBalance(500);
        u3.setUserPhoneNum("456");
        u3.setIdentify("用户");
        

        Order o1 = new Order();
        o1.setUser(u1);
        o1.setAmountOfMoney(5);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        o1.setDate(sdf.format(date));
        o1.setBook(b1);
        u1.getOrder().add(o1);
        
        
        ud.addUser(u1);
        ud.addUser(u2);
        ud.addUser(u3);
        od.addOrder(o1);

        return b;
    }
}
