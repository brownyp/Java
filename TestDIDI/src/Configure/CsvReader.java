package Configure;


import Business.User;
import Method.Methods;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CsvReader {

    private ArrayList<User> userList;
    private Queue<User> userQueue;


    public CsvReader() {
        this.userList = new ArrayList<>();
        this.userQueue = new LinkedList<>();
        String csvFile = "order_20161101.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Methods m = new Methods();


        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] client = line.split(cvsSplitBy);
                List<Double> lo = new ArrayList<>();
                List<Double> lo1 = new ArrayList<>();
                User u = new User();
                u.setUserID(client[0]);
                u.setStartT(Integer.parseInt(client[1]));
                u.setEndT(Integer.parseInt(client[2]));
                lo.add(Double.parseDouble(client[3]));
                lo.add(Double.parseDouble(client[4]));
                lo1.add(Double.parseDouble(client[5]));
                lo1.add(Double.parseDouble(client[6]));
                u.setUserLocation(lo);
                u.setUserAimLocation(lo1);

                double odx = lo.get(0);
                double ody = lo.get(1);

                double ndx = lo1.get(0);
                double ndy = lo1.get(1);

                double degree = 0;

                if (ndx > odx && ndy > ody) {
                    //东北
                    degree = m.getNewDegree(odx, ody, ndx, ndy)+90;
                } else if (ndx > odx && ndy < ody) {
                    //东南
                    degree = m.getNewDegree(odx, ody, ndx, ndy)+180;
                } else if (ndx < odx && ndy > ody) {
                    //西北
                    degree = m.getNewDegree(odx, ody, ndx, ndy);
                } else if (ndx < odx && ndy < ody) {
                    //西南
                    degree = m.getNewDegree(odx, ody, ndx, ndy)+270;
                }

                u.setUserBearing(degree);
                userList.add(u);
                userQueue.add(u);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public ArrayList<User> getUserList() {
        return userList;
    }

    public Queue<User> getUserQueue() {
        return userQueue;
    }


}
