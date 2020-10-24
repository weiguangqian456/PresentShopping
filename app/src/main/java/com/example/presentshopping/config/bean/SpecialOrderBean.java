package com.example.presentshopping.config.bean;

import java.util.List;

public class SpecialOrderBean {

    /**
     * data : {"lose_num":6,"win_num":0,"list":[{"id":"1603447409571685","title":"测试支付","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/r45kokZcOSK5ZIS6mI3ShyDC33SD55.jpg","amount":"0.01","create_time":"2020-10-23 18:03:29","number":"1","status":6,"show_time":1603534920,"is_team":1,"pay_status":3,"goods_id":"2169","team_status":2},{"id":"1603447392529545","title":"山东秋月梨百果园供应商产地直供，3公斤","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/OslOoWq4OaOo4UtUI74oOIuQ2qRO2L.jpg","amount":"99.00","create_time":"2020-10-23 18:03:12","number":"1","status":1,"show_time":0,"is_team":1,"pay_status":null,"goods_id":"2108","team_status":2},{"id":"1603447390871320","title":"山东秋月梨百果园供应商产地直供，3公斤","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/OslOoWq4OaOo4UtUI74oOIuQ2qRO2L.jpg","amount":"99.00","create_time":"2020-10-23 18:03:10","number":"1","status":1,"show_time":0,"is_team":1,"pay_status":null,"goods_id":"2108","team_status":2},{"id":"1603447378474593","title":"山东秋月梨百果园供应商产地直供，3公斤","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/OslOoWq4OaOo4UtUI74oOIuQ2qRO2L.jpg","amount":"99.00","create_time":"2020-10-23 18:02:58","number":"1","status":1,"show_time":0,"is_team":1,"pay_status":null,"goods_id":"2108","team_status":2},{"id":"1603447082397122","title":"测试支付","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/r45kokZcOSK5ZIS6mI3ShyDC33SD55.jpg","amount":"0.01","create_time":"2020-10-23 17:58:02","number":"1","status":1,"show_time":0,"is_team":1,"pay_status":null,"goods_id":"2169","team_status":2},{"id":"1603440053960361","title":"测试支付","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/r45kokZcOSK5ZIS6mI3ShyDC33SD55.jpg","amount":"0.01","create_time":"2020-10-23 16:00:53","number":"1","status":4,"show_time":0,"is_team":1,"pay_status":null,"goods_id":"2169","team_status":2}],"count":6}
     * code : 0
     * msg : 获取订单列表成功
     */

    private DataBean data;
    private int code;
    private String msg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public static class DataBean {
        /**
         * lose_num : 6
         * win_num : 0
         * list : [{"id":"1603447409571685","title":"测试支付","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/r45kokZcOSK5ZIS6mI3ShyDC33SD55.jpg","amount":"0.01","create_time":"2020-10-23 18:03:29","number":"1","status":6,"show_time":1603534920,"is_team":1,"pay_status":3,"goods_id":"2169","team_status":2},{"id":"1603447392529545","title":"山东秋月梨百果园供应商产地直供，3公斤","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/OslOoWq4OaOo4UtUI74oOIuQ2qRO2L.jpg","amount":"99.00","create_time":"2020-10-23 18:03:12","number":"1","status":1,"show_time":0,"is_team":1,"pay_status":null,"goods_id":"2108","team_status":2},{"id":"1603447390871320","title":"山东秋月梨百果园供应商产地直供，3公斤","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/OslOoWq4OaOo4UtUI74oOIuQ2qRO2L.jpg","amount":"99.00","create_time":"2020-10-23 18:03:10","number":"1","status":1,"show_time":0,"is_team":1,"pay_status":null,"goods_id":"2108","team_status":2},{"id":"1603447378474593","title":"山东秋月梨百果园供应商产地直供，3公斤","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/OslOoWq4OaOo4UtUI74oOIuQ2qRO2L.jpg","amount":"99.00","create_time":"2020-10-23 18:02:58","number":"1","status":1,"show_time":0,"is_team":1,"pay_status":null,"goods_id":"2108","team_status":2},{"id":"1603447082397122","title":"测试支付","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/r45kokZcOSK5ZIS6mI3ShyDC33SD55.jpg","amount":"0.01","create_time":"2020-10-23 17:58:02","number":"1","status":1,"show_time":0,"is_team":1,"pay_status":null,"goods_id":"2169","team_status":2},{"id":"1603440053960361","title":"测试支付","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/r45kokZcOSK5ZIS6mI3ShyDC33SD55.jpg","amount":"0.01","create_time":"2020-10-23 16:00:53","number":"1","status":4,"show_time":0,"is_team":1,"pay_status":null,"goods_id":"2169","team_status":2}]
         * count : 6
         */

        private int lose_num;
        private int win_num;
        private int count;
        private List<ListBean> list;

        public int getLose_num() {
            return lose_num;
        }

        public void setLose_num(int lose_num) {
            this.lose_num = lose_num;
        }

        public int getWin_num() {
            return win_num;
        }

        public void setWin_num(int win_num) {
            this.win_num = win_num;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean  {
            /**
             * id : 1603447409571685
             * title : 测试支付
             * thumb : https://wmoss.lxtianxia.cn/images/8/2020/10/r45kokZcOSK5ZIS6mI3ShyDC33SD55.jpg
             * amount : 0.01
             * create_time : 2020-10-23 18:03:29
             * number : 1
             * status : 6
             * show_time : 1603534920
             * is_team : 1
             * pay_status : 3
             * goods_id : 2169
             * team_status : 2
             */

            private String id;
            private String title;
            private String thumb;
            private String amount;
            private String create_time;
            private String number;
            private int status;
            private int show_time;
            private int is_team;
            private int pay_status;
            private String goods_id;
            private int team_status;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getShow_time() {
                return show_time;
            }

            public void setShow_time(int show_time) {
                this.show_time = show_time;
            }

            public int getIs_team() {
                return is_team;
            }

            public void setIs_team(int is_team) {
                this.is_team = is_team;
            }

            public int getPay_status() {
                return pay_status;
            }

            public void setPay_status(int pay_status) {
                this.pay_status = pay_status;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public int getTeam_status() {
                return team_status;
            }

            public void setTeam_status(int team_status) {
                this.team_status = team_status;
            }
        }
    }
}
