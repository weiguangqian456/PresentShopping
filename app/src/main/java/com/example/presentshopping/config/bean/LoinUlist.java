package com.example.presentshopping.config.bean;

public class LoinUlist {

    /**
     * code : 0
     * msg : 登录成功
     * data : {"token":"KjQacpSZkTsOo280yfivPrZzzfpPyA","userInfo":{"nickname":null,"mobile":"18617035298","uid":"11","balance":"0.00","points":0}}
     */

    private int code;
    private String msg;
    private DataBean data;

    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
       
    }

   
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;

    }

   
    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;

    }

    public static class DataBean  {
        /**
         * token : KjQacpSZkTsOo280yfivPrZzzfpPyA
         * userInfo : {"nickname":null,"mobile":"18617035298","uid":"11","balance":"0.00","points":0}
         */

        private String token;
        private UserInfoBean userInfo;

       
        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;

        }

       
        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;

        }

        public static class UserInfoBean {
            /**
             * nickname : null
             * mobile : 18617035298
             * uid : 11
             * balance : 0.00
             * points : 0
             */

            private Object nickname;
            private String mobile;
            private String uid;
            private String balance;
            private int points;

           
            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;

            }

           
            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;

            }

           
            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;

            }

           
            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;

            }

           
            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
                this.points = points;
            }
        }
    }
}

