import Business.Driver;
import Business.Order;
import Business.User;
import Configure.ConfigureABusiness;
import Configure.CsvReader;
import Method.UserQueueMethod;
import Method.UsersInListMethod;

import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        ConfigureABusiness c = new ConfigureABusiness();//车辆信息初始化
//        HashMap<List<Double>, List<Driver>> driverMap = c.getDriverMap();//车辆地图
        ArrayList<Driver> driverOffList = new ArrayList<>();//离线车辆
        CsvReader csv = new CsvReader();//读取order信息并生成user
        Queue<User> userQueue = csv.getUserQueue();//得到user队列

//        UserQueueMethod u = new UserQueueMethod();
//        u.userQueueMethod(c,driverMap,driverOffList,userQueue);
        UsersInListMethod u = new UsersInListMethod();
        u.userQueueMethod(userQueue);
    }


}
