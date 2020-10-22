package com.example.presentshopping.config.constant;

import com.example.presentshopping.config.bean.LoinUlist;
import com.example.presentshopping.utils.tool.UserInforBean;

public class UserInforManage {


    private static UserInforManage instance;

    private LoinUlist userInfor;

    private UserInforManage() {
    }

    public static UserInforManage getInstance() {
        if (instance == null) {
            synchronized (UserInforManage.class) {
                if (instance == null) {
                    instance = new UserInforManage();
                }
            }
        }
        return instance;
    }

    public LoinUlist getUserInfor() {
        return userInfor;
    }

    public void setUserInfor(LoinUlist userInfor) {
        this.userInfor = userInfor;
    }

}
