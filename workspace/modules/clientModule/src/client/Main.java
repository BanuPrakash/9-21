package client;

import com.cisco.prj.service.AppService;
//import com.cisco.prj.util.DateUtil;

public class Main {
    public static void main(String[] args) {
        AppService service = new AppService();
        service.addUser();
//        System.out.println(DateUtil.getDate());
    }
}
