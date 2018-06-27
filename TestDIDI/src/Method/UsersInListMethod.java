package Method;

import Business.Driver;
import Business.Order;
import Business.User;
import Configure.ConfigureABusiness;

import java.math.BigDecimal;
import java.util.*;

public class UsersInListMethod {
    public UsersInListMethod() {

    }

    public void userQueueMethod( Queue<User> userQueue) {
        int uTime = 1477929720;//初始时间
        int oriTime = 1477929720;

        Methods methods = new Methods();

        //网格数量显示
//        methods.showBlockNumber(driverMap);

        //订单list
        ArrayList<Order> orderslist = new ArrayList<>();

        //订单数量计数器
        int successNum = 0;

        //司机数量计数器
        int driverNumber;

        while (!userQueue.isEmpty()) {
            ArrayList<User> userQueueList = new ArrayList<>();
            //检查车辆在线状态
//            methods.checkDriverStatus(uTime, oriTime, driverOffList, driverMap);

            //user的目标driver
            List<Driver> userAimDriver = new ArrayList<>();

            //同一秒的user同时入场
            while (userQueue.peek().getStartT() == uTime) {
                userQueueList.add(userQueue.peek());
                userQueue.poll();
            }

            if(userQueueList.size()==1){
                //原始方案，搜索最近的车
            }else{
                
                userQueueList.size();

            }


            uTime++;
        }

    }

}
