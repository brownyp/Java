/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.system;

import business.city.City;
import business.enterprise.Enterprise;
import business.network.Network;
import business.order.Order;
import business.organization.Organization;
import business.person.Person;
import business.product.Product;
import business.product.ProductMessage;
import business.role.EnterpriseAdminRole;
import business.role.SystemAdminRole;
import business.role.UserRole;
import business.state.State;
import business.useraccount.UserAccount;
import business.usermessage.Message;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import business.logistic.FedexPackages;
import business.logistic.UspsPackages;
       

/**
 *
 * @author kkkevinxx
 */
public class ConfigureABusiness implements Serializable{

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        Person person = system.getPersonDirectory().createAndAddPerson("HaoningXin", "China", "Beijing", "Beijing", "UESTC", "101010", "000-000", "xxx@uestc.edu", "/Users/kkkevinxx/Downloads/Pictures/Person1.jpg");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "123", person, new SystemAdminRole(), "OK");

        //First Country....University
        Network n1 = system.getNetworkDirectory().createAndAddNetwork("China");
        State s1 = n1.getStateDirectory().createAndAddState("Beijing");
        City c1 = s1.getCityDirectory().createAndAddCity("Beijing");
        Enterprise e1 = c1.getEnterpriseDirectory().createAndAddEnterprise("UESTC", Enterprise.EnterpriseType.University, "China", "Beijing", "Beijing");
        Person personE = e1.getPersonDirectory().createAndAddPerson("eyi", "China", "Beijing", "Beijing", "UESTC", "101010", "000-000", "xxx@uestc.edu", "/Users/kkkevinxx/Downloads/Pictures/Person2.jpg");
        UserAccount uaE = e1.getUserAccountDirectory().createUserAccount("e1", "123", personE, new EnterpriseAdminRole(), "OK");
        Organization o1 = e1.getOrganizationDirectory().createOrganization(Organization.Type.User);

        Person person1 = o1.getPersonDirectory().createAndAddPerson("uyi", "China", "Beijing", "Beijing", "UESTC", "101010", "000-000", "xin.h@husky.neu.edu", "/Users/kkkevinxx/Downloads/Pictures/Person3.jpg");
        UserAccount ua1 = o1.getUserAccountDirectory().createUserAccount("u1", "123", person1, new UserRole(), "OK");
        Product product = o1.getProductDirectory().createProduct("iPone", "Nice phone Nice phone Nice phone Nice phone Nice phone Nice phone Nice phone Nice phone Nice phone Nice phone Nice phone Nice phone Nice phone Nice phone ", "2017-05-11", "N/A", "OK", 3000, 5000, Product.Category.Electronics.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/17.jpg");
        Product product1 = o1.getProductDirectory().createProduct("Mac", "Nice Mac", "2015-05-19", "N/A", "Pending", 9000, 15000, Product.Category.Electronics.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/16.jpg");
        Product product2 = o1.getProductDirectory().createProduct("Noodle", "Delicious noodle", "2017-09-22", "N/A", "OK", 40, 70, Product.Category.Food.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/15.jpg");
        Product product0s = o1.getProductDirectory().createProduct("eee1", "look good", "2017-03-14", "2017-06-18", "Sold", 60, 110, Product.Category.Electronics.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/14.jpg");
        Product product1s = o1.getProductDirectory().createProduct("eee2", "look good", "2017-03-14", "2017-06-18", "Sold", 60, 110, Product.Category.Electronics.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/15.jpg");
        Product product2s = o1.getProductDirectory().createProduct("eee3", "look good", "2017-03-14", "2017-06-18", "Sold", 60, 110, Product.Category.Electronics.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/16.jpg");
        Product product3s = o1.getProductDirectory().createProduct("Table1", "look good", "2017-03-14", "2017-06-18", "Sold", 60, 110, Product.Category.Furniture.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/17.jpg");
        Product product4s = o1.getProductDirectory().createProduct("Table2", "look good", "2017-03-14", "2017-06-18", "Sold", 60, 110, Product.Category.Furniture.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/1.jpg");
        Product product5s = o1.getProductDirectory().createProduct("foooood", "look good", "2017-03-14", "2017-06-18", "Sold", 60, 110, Product.Category.Food.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/12.jpg");
        product.setLongitude(42.325); product.setLatitude(-71.059); product.setVerify("Verified");
        product1.setLongitude(42.325); product1.setLatitude(-71.059); product1.setVerify("Verified");
        product2.setLongitude(41.325); product2.setLatitude(-72.059); product2.setVerify("Verified");
        product0s.setLongitude(42.025); product0s.setLatitude(-71.159); product0s.setVerify("Verified");
        product1s.setLongitude(42.225); product1s.setLatitude(-71.009); product1s.setVerify("Normal");
        product2s.setLongitude(42.425); product2s.setLatitude(-71.039); product2s.setVerify("Normal");
        product3s.setLongitude(42.305); product3s.setLatitude(-71.051); product3s.setVerify("Normal");
        product4s.setLongitude(42.035); product4s.setLatitude(-72.159); product4s.setVerify("Normal");
        product5s.setLongitude(43.315); product5s.setLatitude(-71.079); product5s.setVerify("Normal");

        
        Product product11 = o1.getProductDirectory().createProduct("Samsang", "Nice phone", "2017-05-21", "N/A", "OK", 1000, 1733, Product.Category.Electronics.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/13.jpg");
        Product product12 = o1.getProductDirectory().createProduct("iMac Pro", "Nice Mac", "2015-05-13", "N/A", "OK", 6000, 10000, Product.Category.Electronics.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/12.jpg");
        Product product13 = o1.getProductDirectory().createProduct("LG", "Nice phone", "2017-01-11", "N/A", "OK", 1000, 2100, Product.Category.Electronics.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/11.jpg");
        Product product14 = o1.getProductDirectory().createProduct("Mac Book", "Nice Mac book", "2015-03-19", "N/A", "OK", 3000, 4500, Product.Category.Electronics.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/10.jpg");
        Product product15 = o1.getProductDirectory().createProduct("Inspirion", "Nice labtop", "2017-02-09", "N/A", "OK", 3000, 4500, Product.Category.Electronics.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/9.jpg");

        Product product16 = o1.getProductDirectory().createProduct("Fur1", "Nice ", "2016-04-13", "N/A", "OK", 600, 1000, Product.Category.Furniture.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/8.jpg");
        Product product17 = o1.getProductDirectory().createProduct("Fur2", "Nice ", "2017-03-11", "N/A", "OK", 110, 200, Product.Category.Furniture.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/7.jpg");
        Product product18 = o1.getProductDirectory().createProduct("Fur3", "Nice ", "2017-02-09", "N/A", "OK", 300, 450, Product.Category.Furniture.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/6.jpg");
        Product product19 = o1.getProductDirectory().createProduct("Fur4", "Nice ", "2017-02-09", "N/A", "OK", 300, 450, Product.Category.Furniture.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/5.jpg");

        Product product30 = o1.getProductDirectory().createProduct("Food1", "Nice ", "2017-03-11", "N/A", "OK", 1120, 2300, Product.Category.Food.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/4.jpg");
        Product product31 = o1.getProductDirectory().createProduct("Food2", "Nice ", "2017-02-09", "N/A", "OK", 3030, 4450, Product.Category.Food.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/3.jpg");
        Product product32 = o1.getProductDirectory().createProduct("Food3", "Nice ", "2017-02-09", "N/A", "OK", 3040, 4550, Product.Category.Food.getValue(), ua1, "/Users/kkkevinxx/Downloads/Pictures/2.jpg");
        product11.setLongitude(42.325); product11.setLatitude(-71.059); product11.setVerify("Verified");
        product12.setLongitude(42.325); product12.setLatitude(-71.059); product12.setVerify("Verified");
        product13.setLongitude(41.325); product13.setLatitude(-72.059); product13.setVerify("Verified");
        product14.setLongitude(42.025); product14.setLatitude(-71.159); product14.setVerify("Verified");
        product15.setLongitude(42.225); product15.setLatitude(-71.009); product15.setVerify("Verified");
        product16.setLongitude(42.425); product16.setLatitude(-71.039); product16.setVerify("Normal");
        product17.setLongitude(42.305); product17.setLatitude(-71.051); product17.setVerify("Normal");
        product18.setLongitude(42.035); product18.setLatitude(-72.159); product18.setVerify("Normal");
        product19.setLongitude(43.315); product19.setLatitude(-71.079); product19.setVerify("Normal");
        product30.setLongitude(42.305); product30.setLatitude(-71.051); product30.setVerify("Normal");
        product31.setLongitude(42.035); product31.setLatitude(-72.159); product31.setVerify("Normal");
        product32.setLongitude(43.315); product32.setLatitude(-71.079); product32.setVerify("Normal");
        
        
        
        
        
//Seecond Country.....University
        Network n2 = system.getNetworkDirectory().createAndAddNetwork("USA");
        State s2 = n2.getStateDirectory().createAndAddState("MA");
        City c2 = s2.getCityDirectory().createAndAddCity("Boston");
        Enterprise e2 = c2.getEnterpriseDirectory().createAndAddEnterprise("NEU", Enterprise.EnterpriseType.University, "USA", "MA", "Boston");
        Organization o2 = e2.getOrganizationDirectory().createOrganization(Organization.Type.User);

        Person person2 = o2.getPersonDirectory().createAndAddPerson("uer", "USA", "MA", "Boston", "NEU", "02115", "000-000", "xxx@husky.neu.edu", "/Users/kkkevinxx/Downloads/Pictures/Person5.jpg");
        UserAccount ua2 = o2.getUserAccountDirectory().createUserAccount("u2", "123", person2, new UserRole(), "OK");
        Product product4 = o2.getProductDirectory().createProduct("Headphone", "Nice headphone", "2017-05-11", "N/A", "OK", 300, 500, Product.Category.Electronics.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/1.jpg");
        Product product5 = o2.getProductDirectory().createProduct("Speaker Sony", "Nice speaker", "2015-05-19", "N/A", "Pending", 90, 150, Product.Category.Electronics.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/2.jpg");
        Product product6 = o2.getProductDirectory().createProduct("Rice", "Delicious rice", "2017-09-22", "N/A", "OK", 40, 70, Product.Category.Food.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/3.jpg");
        Product product7 = o2.getProductDirectory().createProduct("Sofa", "80 new", "2017-03-14", "2017-06-18", "Sold", 60, 110, Product.Category.Furniture.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/4.jpg");

        Product product21 = o2.getProductDirectory().createProduct("Huawei", "Nice phone", "2017-01-21", "N/A", "OK", 300, 750, Product.Category.Electronics.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/5.jpg");
        Product product22 = o2.getProductDirectory().createProduct("XPS", "Nice labtop", "2016-04-13", "N/A", "OK", 6000, 10000, Product.Category.Electronics.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/6.jpg");
        Product product23 = o2.getProductDirectory().createProduct("Xiaomi", "Nice phone", "2017-03-11", "N/A", "OK", 1100, 2000, Product.Category.Electronics.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/7.jpg");
        Product product24 = o2.getProductDirectory().createProduct("Inspirion", "Nice labtop", "2017-02-09", "N/A", "OK", 3000, 4500, Product.Category.Electronics.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/8.jpg");
        Product product25 = o2.getProductDirectory().createProduct("Inspirion", "Nice labtop", "2017-02-09", "N/A", "OK", 3000, 4500, Product.Category.Electronics.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/9.jpg");

        Product product26 = o2.getProductDirectory().createProduct("Fur1", "Nice ", "2016-04-13", "N/A", "OK", 600, 1000, Product.Category.Furniture.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/10.jpg");
        Product product27 = o2.getProductDirectory().createProduct("Fur2", "Nice ", "2017-03-11", "N/A", "OK", 110, 200, Product.Category.Furniture.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/11.jpg");
        Product product28 = o2.getProductDirectory().createProduct("Fur3", "Nice ", "2017-02-09", "N/A", "OK", 300, 450, Product.Category.Furniture.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/12.jpg");
        Product product29 = o2.getProductDirectory().createProduct("Fur4", "Nice ", "2017-02-09", "N/A", "OK", 300, 450, Product.Category.Furniture.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/13.jpg");

        Product product40 = o2.getProductDirectory().createProduct("Food1", "Nice ", "2017-03-11", "N/A", "OK", 1120, 2300, Product.Category.Food.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/14.jpg");
        Product product41 = o2.getProductDirectory().createProduct("Food2", "Nice ", "2017-02-09", "N/A", "OK", 3030, 4450, Product.Category.Food.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/15.jpg");
        Product product42 = o2.getProductDirectory().createProduct("Food3", "Nice ", "2017-02-09", "N/A", "OK", 3040, 4550, Product.Category.Food.getValue(), ua2, "/Users/kkkevinxx/Downloads/Pictures/16.jpg");

        product4.setLongitude(42.325); product4.setLatitude(-71.059); product4.setVerify("Verified");
        product5.setLongitude(42.325); product5.setLatitude(-71.059); product5.setVerify("Verified");
        product6.setLongitude(41.325); product6.setLatitude(-72.059); product6.setVerify("Normal");
        product7.setLongitude(42.025); product7.setLatitude(-71.159); product7.setVerify("Verified");
        product21.setLongitude(42.225); product21.setLatitude(-71.009); product21.setVerify("Verified");
        product22.setLongitude(42.425); product22.setLatitude(-71.039); product22.setVerify("Verified");
        product23.setLongitude(42.305); product23.setLatitude(-71.051); product23.setVerify("Verified");
        product24.setLongitude(42.035); product24.setLatitude(-72.159); product24.setVerify("Normal");
        product25.setLongitude(43.315); product25.setLatitude(-71.079); product25.setVerify("Normal");
        product26.setLongitude(42.305); product26.setLatitude(-71.051); product26.setVerify("Verified");
        product27.setLongitude(42.035); product27.setLatitude(-72.159); product27.setVerify("Normal");
        product28.setLongitude(43.315); product28.setLatitude(-71.079); product28.setVerify("Normal");
        product29.setLongitude(42.025); product29.setLatitude(-71.159); product29.setVerify("Verified");
        product40.setLongitude(42.225); product40.setLatitude(-71.009); product40.setVerify("Normal");
        product41.setLongitude(42.425); product41.setLatitude(-71.039); product41.setVerify("Verified");
        product42.setLongitude(42.305); product42.setLatitude(-71.051); product42.setVerify("Normal");
        
        
        
        
        
        
        Order order0s = person1.getOrderDirectory().CreateOrders(product0s, "2017-06-14 12:30", "Peoeo", "123-333", "Street111111111", "Express2", ua1, ua2, "Delivered", 8);
        person2.getOrderDirectory().getOrderList().add(order0s);
        Order order1s = person1.getOrderDirectory().CreateOrders(product1s, "2017-06-14 12:30", "Peoeo", "123-333", "Street111111111", "Express2", ua1, ua2, "Delivered", 8);
        person2.getOrderDirectory().getOrderList().add(order1s);
        Order order2s = person1.getOrderDirectory().CreateOrders(product2s, "2017-06-14 12:30", "Peoeo", "123-333", "Street111111111", "Express2", ua1, ua2, "Delivered", 8);
        person2.getOrderDirectory().getOrderList().add(order2s);
        Order order3s = person1.getOrderDirectory().CreateOrders(product3s, "2017-06-14 12:30", "Peoeo", "123-333", "Street111111111", "Express2", ua1, ua2, "Delivered", 8);
        person2.getOrderDirectory().getOrderList().add(order3s);
        Order order4s = person1.getOrderDirectory().CreateOrders(product4s, "2017-06-14 12:30", "Peoeo", "123-333", "Street111111111", "Express2", ua1, ua2, "Delivered", 8);
        person2.getOrderDirectory().getOrderList().add(order4s);
        Order order5s = person1.getOrderDirectory().CreateOrders(product5s, "2017-06-14 12:30", "Peoeo", "123-333", "Street111111111", "Express2", ua1, ua2, "Delivered", 8);
        person2.getOrderDirectory().getOrderList().add(order5s);

        Order order7 = person2.getOrderDirectory().CreateOrders(product7, "2017-06-10 12:30", "Peoeo", "123-333", "Street111111111", "Express2", ua2, ua1, "Delivered", 8);
        person1.getOrderDirectory().getOrderList().add(order7);

        ProductMessage pm = product.getProductMessageDirectory().createProductMessage("look good, cheaper is better: )", "Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content ", ua2, "2017-03-12 22:11");

        Message rMessage2 = ua2.getMessageDirectory().createMessage("Content Content Content Content Content Content Content Content Content Content Content Content Content Content Contenz 111111111 111111111 111111111 111111111 111111111 111111111 111111111 111111111 111111111  ", "Read", "2017-03-12 21:25", ua1, ua2, product, null);
        ua1.getMessageDirectory().getMessageList().add(rMessage2);
        Message m = ua2.getMessageDirectory().createMessage("Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content 2222222222 2222222222 2222222222 2222222222 2222222222 2222222222 2222222222 2222222222 2222222222 2222222222 ", "Read", "2017-03-12 22:11", ua2, ua1, product, rMessage2);
        ua1.getMessageDirectory().getMessageList().add(m);
        Message m21 = ua2.getMessageDirectory().createMessage("Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content 3333333333 3333333333 3333333333 3333333333 3333333333 3333333333 3333333333 3333333333 3333333333 3333333333 ", "Unread", "2017-03-12 22:13", ua1, ua2, product, m);
        ua1.getMessageDirectory().getMessageList().add(m21);
        Message m22 = ua2.getMessageDirectory().createMessage("Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content 444444444444444444444444 ", "Unread", "2017-03-12 22:34", ua1, ua2, product, m21);
        ua1.getMessageDirectory().getMessageList().add(m22);

        Organization o3 = e1.getOrganizationDirectory().createOrganization(Organization.Type.User);
        Person person3 = o3.getPersonDirectory().createAndAddPerson("usan", "China", "Beijing", "Beijing", "BUPT", "101010", "000-000", "xxx@uestc.edu", "/Users/kkkevinxx/Downloads/Pictures/Person6.jpg");
        UserAccount ua3 = o3.getUserAccountDirectory().createUserAccount("u3", "123", person3, new UserRole(), "OK");
        Product product330 = o3.getProductDirectory().createProduct("Food1", "Nice ", "2017-03-11", "N/A", "OK", 1120, 2300, Product.Category.Food.getValue(), ua3, "/Users/kkkevinxx/Downloads/Pictures/14.jpg");
        product330.setLongitude(42.035); product330.setLatitude(-72.159); product330.setVerify("Verified");
        Order order330 = person3.getOrderDirectory().CreateOrders(product330, "2017-06-14 12:30", "Peoeo", "123-333", "Street111111111", "Express2", ua2, ua3, "Delivered", 9);
        person2.getOrderDirectory().getOrderList().add(order330);
        

        Organization o4 = e2.getOrganizationDirectory().createOrganization(Organization.Type.User);
        Person person4 = o4.getPersonDirectory().createAndAddPerson("usi", "USA", "MA", "Boston", "NEU", "02115", "000-000", "xxx@husky.neu.edu", "/Users/kkkevinxx/Downloads/Pictures/Person7.jpg");
        UserAccount ua4 = o4.getUserAccountDirectory().createUserAccount("u4", "123", person4, new UserRole(), "OK");

        Organization o5 = e2.getOrganizationDirectory().createOrganization(Organization.Type.User);
        Person person5 = o5.getPersonDirectory().createAndAddPerson("uwu", "USA", "MA", "Boston", "NEU", "02115", "000-000", "xxx@husky.neu.edu", "/Users/kkkevinxx/Downloads/Pictures/Person8.jpg");
        UserAccount ua5 = o5.getUserAccountDirectory().createUserAccount("u5", "123", person5, new UserRole(), "OK");

        Organization o6 = e2.getOrganizationDirectory().createOrganization(Organization.Type.User);
        Person person6 = o6.getPersonDirectory().createAndAddPerson("uliu", "USA", "MA", "Boston", "NEU", "02115", "000-000", "xxx@husky.neu.edu", "/Users/kkkevinxx/Downloads/Pictures/Person9.jpg");
        UserAccount ua6 = o6.getUserAccountDirectory().createUserAccount("u6", "123", person6, new UserRole(), "OK");

        Organization o7 = e2.getOrganizationDirectory().createOrganization(Organization.Type.User);
        Person person7 = o7.getPersonDirectory().createAndAddPerson("uqi", "USA", "MA", "Boston", "NEU", "02115", "000-000", "xxx@husky.neu.edu", "/Users/kkkevinxx/Downloads/Pictures/Person10.jpg");
        UserAccount ua7 = o7.getUserAccountDirectory().createUserAccount("u7", "123", person7, new UserRole(), "OK");

        Organization o8 = e2.getOrganizationDirectory().createOrganization(Organization.Type.User);
        Person person8 = o8.getPersonDirectory().createAndAddPerson("uba", "USA", "MA", "Boston", "NEU", "02115", "000-000", "xxx@husky.neu.edu", "/Users/kkkevinxx/Downloads/Pictures/Person11.jpg");
        UserAccount ua8 = o8.getUserAccountDirectory().createUserAccount("u8", "123", person8, new UserRole(), "OK");

        Enterprise e3 = c2.getEnterpriseDirectory().createAndAddEnterprise("BU", Enterprise.EnterpriseType.University, "USA", "MA", "Boston");

        Organization o9 = e3.getOrganizationDirectory().createOrganization(Organization.Type.User);
        Person person9 = o9.getPersonDirectory().createAndAddPerson("ujiu", "USA", "MA", "Boston", "BU", "02115", "000-000", "xxx@husky.neu.edu", "/Users/kkkevinxx/Downloads/Pictures/Person12.jpg");
        UserAccount ua9 = o9.getUserAccountDirectory().createUserAccount("u9", "123", person9, new UserRole(), "OK");

        Organization o10 = e3.getOrganizationDirectory().createOrganization(Organization.Type.User);
        Person person10 = o10.getPersonDirectory().createAndAddPerson("ushi", "USA", "MA", "Boston", "BU", "02115", "000-000", "xxx@husky.neu.edu", "/Users/kkkevinxx/Downloads/Pictures/Person4.jpg");
        UserAccount ua10 = o10.getUserAccountDirectory().createUserAccount("u10", "123", person10, new UserRole(), "OK");

        Organization o11 = e3.getOrganizationDirectory().createOrganization(Organization.Type.User);
        Person person11 = o11.getPersonDirectory().createAndAddPerson("ushiy", "USA", "MA", "Boston", "BU", "02115", "000-000", "xxx@husky.neu.edu", "/Users/kkkevinxx/Downloads/Pictures/Person3.jpg");
        UserAccount ua11 = o11.getUserAccountDirectory().createUserAccount("u11", "123", person11, new UserRole(), "OK");

        Organization o12 = e3.getOrganizationDirectory().createOrganization(Organization.Type.User);
        Person person12 = o12.getPersonDirectory().createAndAddPerson("ushie", "USA", "MA", "Boston", "BU", "02115", "000-000", "xxx@husky.neu.edu", "/Users/kkkevinxx/Downloads/Pictures/Person6.jpg");
        UserAccount ua12 = o12.getUserAccountDirectory().createUserAccount("u12", "123", person12, new UserRole(), "OK");

        Organization o13 = e3.getOrganizationDirectory().createOrganization(Organization.Type.User);
        Person person13 = o13.getPersonDirectory().createAndAddPerson("ushis", "USA", "MA", "Boston", "BU", "02115", "000-000", "xxx@husky.neu.edu", "/Users/kkkevinxx/Downloads/Pictures/Person8.jpg");
        UserAccount ua13 = o13.getUserAccountDirectory().createUserAccount("u13", "123", person13, new UserRole(), "OK");

        ArrayList<Product> temp = new ArrayList<Product>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("product.csv"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");

                Product newproduct = new Product();

                String productname = item[0];
                newproduct.setProductName(productname);

                String productdes = item[1];
                newproduct.setDescription(productdes);

                newproduct.setCatagory(Product.Category.valueOf(item[2]).getValue());

                String productdate = item[3];
                newproduct.setPublishDate(productdate);

                String productsold = item[4];
                newproduct.setSoldDate(productsold);

                String productstatus = item[5];
                newproduct.setStatus(productstatus);

                int productprice = Integer.parseInt(item[6]);
                newproduct.setProductPrice(productprice);

                int productOriprice = Integer.parseInt(item[7]);
                newproduct.setProductOriginPrice(productOriprice);
                
                newproduct.setVerify("Normal");
                
                

                temp.add(newproduct);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int i1 = 0;
        int j1 = 0;
        while (i1 < 50) {
            temp.get(i1).setUserAccount(ua4);
            i1++;
        }
        j1++;
        while (i1 >= 50 && i1 < 100) {
            temp.get(i1).setUserAccount(ua5);
            i1++;
        }
        j1++;
        while (i1 >= 100 && i1 < 150) {
            temp.get(i1).setUserAccount(ua6);
            i1++;
        }
        j1++;
        while (i1 >= 150 && i1 < 200) {
            temp.get(i1).setUserAccount(ua7);
            i1++;
        }
        j1++;
        while (i1 >= 200 && i1 < 250) {
            temp.get(i1).setUserAccount(ua8);
            i1++;
        }
        j1++;
        while (i1 >= 250 && i1 < 300) {
            temp.get(i1).setUserAccount(ua9);
            i1++;
        }
        j1++;
        while (i1 >= 300 && i1 < 350) {
            temp.get(i1).setUserAccount(ua10);
            i1++;
        }
        j1++;
        while (i1 >= 350 && i1 < 400) {
            temp.get(i1).setUserAccount(ua11);
            i1++;
        }
        j1++;
        while (i1 >= 400 && i1 < 450) {
            temp.get(i1).setUserAccount(ua12);
            i1++;
        }
        j1++;
        while (i1 >= 450 && i1 < 500) {
            temp.get(i1).setUserAccount(ua13);
            i1++;
        }

        ArrayList<Order> tempOrder = new ArrayList<Order>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("productsold.csv"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");

                Order order = new Order();

                String orderdate = item[0];
                String ordertime = item[1];

                String orderdt = orderdate + " " + ordertime;
                order.setOrderDate(orderdt);

                String rname = item[2];
                order.setRecipientName(rname);

                String rnumber = item[3];
                order.setRecipientPhone(rnumber);

                String raddress = item[4];
                order.setRecipientAddress(raddress);

                String roption = item[5];
                order.setExpress(roption);

                String rstatus = item[8];
                order.setOrderStatus(rstatus);
                
                int rRating = Integer.parseInt(item[9]);
                order.setRating(rRating);
                
                
                
                tempOrder.add(order);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int i = 0;
        int j = 0;
        while (i < 50) {
            tempOrder.get(i).setBuyer(ua4);
            tempOrder.get(i).setSeller(ua5);
            tempOrder.get(i).setProduct(temp.get(i));

            person4.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            person5.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            i++;
        }
        j++;
        while (i >= 50 && i < 100) {
            tempOrder.get(i).setBuyer(ua5);
            tempOrder.get(i).setSeller(ua6);
            tempOrder.get(i).setProduct(temp.get(i));
            person5.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            person6.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            i++;
        }
        j++;
        while (i >= 100 && i < 150) {
            tempOrder.get(i).setBuyer(ua6);
            tempOrder.get(i).setSeller(ua7);
            tempOrder.get(i).setProduct(temp.get(i));
            person6.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            person7.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            i++;
        }
        j++;
        while (i >= 150 && i < 200) {
            tempOrder.get(i).setBuyer(ua7);
            tempOrder.get(i).setSeller(ua8);
            tempOrder.get(i).setProduct(temp.get(i));
            person7.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            person8.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            i++;
        }
        while (i >= 200 && i < 250) {
            tempOrder.get(i).setBuyer(ua8);
            tempOrder.get(i).setSeller(ua9);
            tempOrder.get(i).setProduct(temp.get(i));
            person8.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            person9.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            i++;
        }

        j++;
        while (i >= 250 && i < 300) {
            tempOrder.get(i).setBuyer(ua9);
            tempOrder.get(i).setSeller(ua10);
            tempOrder.get(i).setProduct(temp.get(i));
            person9.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            person10.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            i++;
        }
        j++;
        while (i >= 300 && i < 350) {
            tempOrder.get(i).setBuyer(ua10);
            tempOrder.get(i).setSeller(ua11);
            tempOrder.get(i).setProduct(temp.get(i));
            person10.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            person11.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            i++;
        }
        j++;
        while (i >= 350 && i < 400) {
            tempOrder.get(i).setBuyer(ua11);
            tempOrder.get(i).setSeller(ua12);
            tempOrder.get(i).setProduct(temp.get(i));
            person11.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            person12.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            i++;
        }
        j++;

        while (i >= 400 && i < 450) {
            tempOrder.get(i).setBuyer(ua12);
            tempOrder.get(i).setSeller(ua13);
            tempOrder.get(i).setProduct(temp.get(i));
            person12.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            person13.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            i++;
        }
        j++;
        while (i >= 450 && i < 500) {
            tempOrder.get(i).setBuyer(ua13);
            tempOrder.get(i).setSeller(ua4);
            tempOrder.get(i).setProduct(temp.get(i));
            person13.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            person4.getOrderDirectory().getOrderList().add(tempOrder.get(i));
            i++;
        }

        ArrayList<Product> temp1 = new ArrayList<Product>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("OKproduct.csv"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");

                Product newproduct1 = new Product();

                String productname = item[0];
                newproduct1.setProductName(productname);

                String productdes = item[1];
                newproduct1.setDescription(productdes);

                newproduct1.setCatagory(Product.Category.valueOf(item[2]).getValue());

                String productdate = item[3];
                newproduct1.setPublishDate(productdate);

                String productsold = item[4];
                newproduct1.setSoldDate(productsold);

                String productstatus = item[5];
                newproduct1.setStatus(productstatus);

                int productprice = Integer.parseInt(item[6]);
                newproduct1.setProductPrice(productprice);

                int productOriprice = Integer.parseInt(item[7]);
                newproduct1.setProductOriginPrice(productOriprice);
                
                String imagePath = item[8];
                newproduct1.setImagePath(imagePath);
                
                double productLA = Double.parseDouble(item[9]);
                newproduct1.setLongitude(productLA);
                
                double productLO = Double.parseDouble(item[10]);
                newproduct1.setLatitude(productLO);
                
                newproduct1.setVerify("Normal");
                
                

                temp1.add(newproduct1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int i2 = 0;
        int j2 = 0;
        while (i2 < 50) {
            temp1.get(i2).setUserAccount(ua4);
            o4.getProductDirectory().getProductList().add(temp1.get(i2));
            i2++;
        }
        j2++;
        while (i2 >= 50 && i2 < 100) {
            temp1.get(i2).setUserAccount(ua5);
            o5.getProductDirectory().getProductList().add(temp1.get(i2));
            i2++;
        }
        j2++;
        while (i2 >= 100 && i2 < 150) {
            temp1.get(i2).setUserAccount(ua6);
            o6.getProductDirectory().getProductList().add(temp1.get(i2));
            i2++;
        }
        j2++;
        while (i2 >= 150 && i2 < 200) {
            temp1.get(i2).setUserAccount(ua7);
            o7.getProductDirectory().getProductList().add(temp1.get(i2));
            i2++;
        }
        j2++;
        while (i2 >= 200 && i2 < 250) {
            temp1.get(i2).setUserAccount(ua8);
            o8.getProductDirectory().getProductList().add(temp1.get(i2));
            i2++;
        }
        j2++;
        while (i2 >= 250 && i2 < 300) {
            temp1.get(i2).setUserAccount(ua9);
            o9.getProductDirectory().getProductList().add(temp1.get(i2));
            i2++;
        }
        j2++;
        while (i2 >= 300 && i2 < 350) {
            temp1.get(i2).setUserAccount(ua10);
            o10.getProductDirectory().getProductList().add(temp1.get(i2));
            i2++;
        }
        j2++;
        while (i2 >= 350 && i2 < 400) {
            temp1.get(i2).setUserAccount(ua11);
            o11.getProductDirectory().getProductList().add(temp1.get(i2));
            i2++;
        }
        j2++;
        while (i2 >= 400 && i2 < 450) {
            temp1.get(i2).setUserAccount(ua12);
            o12.getProductDirectory().getProductList().add(temp1.get(i2));
            i2++;
        }
        j2++;
        while (i2 >= 450 && i2 < 500) {
            temp1.get(i2).setUserAccount(ua13);
            o13.getProductDirectory().getProductList().add(temp1.get(i2));
            i2++;
        }

        return system;
    }
}
