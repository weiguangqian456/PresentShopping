package com.example.presentshopping.config.bean;

import java.util.List;

public class SupplierListBean {

    /**
     * code : 0
     * msg : 获取商品列表成功
     * data : {"list":[{"id":2012,"title":"咪然 东北大米 正宗五常有机稻花香大米现磨新米原粮原产地袋装2.5kg","thumb":"http://oss.lxtianxia.cn/cec15c26262691c80004d7bac5aed9fd.jpg","marketprice":"108.00","isteam":2,"productprice":"168.00"},{"id":2008,"title":"咪然 2019新品富硒现磨鲜米 东北大米 煮粥米 东北原粮地直发 真空袋装5kg","thumb":"http://oss.lxtianxia.cn/5d77e66b19e040c58a02b34048d621ae.jpg","marketprice":"128.00","isteam":2,"productprice":"150.00"},{"id":2011,"title":"咪然 稻花香香米五常大米 东北大米10斤 黑龙江原产地直供现磨新米 真空袋装5kg","thumb":"http://oss.lxtianxia.cn/b64ba8dcc183f6fe4136775ef371db24.jpg","marketprice":"135.00","isteam":2,"productprice":"0.00"},{"id":2010,"title":"咪然 2019新品富硒现磨大米 东北大米 煮粥米 真空袋装鲜米2.5kg 产地直发","thumb":"http://oss.lxtianxia.cn/ab9ae5efeba45b49f1c23d8ef7490f72.jpg","marketprice":"78.00","isteam":2,"productprice":"0.00"},{"id":2053,"title":"山东蜜薯   5kg/箱","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/g6ZAy4o6aU48HOPpY2pYWA8bBha94z.jpg","marketprice":"99.00","isteam":0,"productprice":"118.00"},{"id":2055,"title":"BOB 6色口红 套装礼盒","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/P0qEnQQm89pNnDe8iJqDpPj80989N0.jpg","marketprice":"66.00","isteam":0,"productprice":"138.00"},{"id":2056,"title":"蓝月亮原生态竹纤维纸巾12卷60克","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/Ynzh3z888bvviF38vf20h0K8b2KfXH.jpg","marketprice":"39.00","isteam":0,"productprice":"52.00"},{"id":2057,"title":"蓝月亮原生态竹纤维纸巾  28卷/2提","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/Z12zpKaDTyyAdWKtY3ygLUAk2DWbaL.jpg","marketprice":"69.00","isteam":0,"productprice":"89.00"},{"id":2058,"title":"蓝莓酒  大兴安岭野生蓝莓酒 750ML","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/xKMfvqIEwI0q3KGEViAviQj6qQVikm.jpg","marketprice":"199.00","isteam":1,"productprice":"298.00"},{"id":2060,"title":"蓝月亮金尊原生态竹纤维卷纸，24卷/2提","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/H02LS6dDuQRrPbsallNVn0dRlZapB9.jpg","marketprice":"59.00","isteam":0,"productprice":"69.00"}],"count":97}
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

    public static class DataBean {
        /**
         * list : [{"id":2012,"title":"咪然 东北大米 正宗五常有机稻花香大米现磨新米原粮原产地袋装2.5kg","thumb":"http://oss.lxtianxia.cn/cec15c26262691c80004d7bac5aed9fd.jpg","marketprice":"108.00","isteam":2,"productprice":"168.00"},{"id":2008,"title":"咪然 2019新品富硒现磨鲜米 东北大米 煮粥米 东北原粮地直发 真空袋装5kg","thumb":"http://oss.lxtianxia.cn/5d77e66b19e040c58a02b34048d621ae.jpg","marketprice":"128.00","isteam":2,"productprice":"150.00"},{"id":2011,"title":"咪然 稻花香香米五常大米 东北大米10斤 黑龙江原产地直供现磨新米 真空袋装5kg","thumb":"http://oss.lxtianxia.cn/b64ba8dcc183f6fe4136775ef371db24.jpg","marketprice":"135.00","isteam":2,"productprice":"0.00"},{"id":2010,"title":"咪然 2019新品富硒现磨大米 东北大米 煮粥米 真空袋装鲜米2.5kg 产地直发","thumb":"http://oss.lxtianxia.cn/ab9ae5efeba45b49f1c23d8ef7490f72.jpg","marketprice":"78.00","isteam":2,"productprice":"0.00"},{"id":2053,"title":"山东蜜薯   5kg/箱","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/g6ZAy4o6aU48HOPpY2pYWA8bBha94z.jpg","marketprice":"99.00","isteam":0,"productprice":"118.00"},{"id":2055,"title":"BOB 6色口红 套装礼盒","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/P0qEnQQm89pNnDe8iJqDpPj80989N0.jpg","marketprice":"66.00","isteam":0,"productprice":"138.00"},{"id":2056,"title":"蓝月亮原生态竹纤维纸巾12卷60克","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/Ynzh3z888bvviF38vf20h0K8b2KfXH.jpg","marketprice":"39.00","isteam":0,"productprice":"52.00"},{"id":2057,"title":"蓝月亮原生态竹纤维纸巾  28卷/2提","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/Z12zpKaDTyyAdWKtY3ygLUAk2DWbaL.jpg","marketprice":"69.00","isteam":0,"productprice":"89.00"},{"id":2058,"title":"蓝莓酒  大兴安岭野生蓝莓酒 750ML","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/xKMfvqIEwI0q3KGEViAviQj6qQVikm.jpg","marketprice":"199.00","isteam":1,"productprice":"298.00"},{"id":2060,"title":"蓝月亮金尊原生态竹纤维卷纸，24卷/2提","thumb":"https://wmoss.lxtianxia.cn/images/8/2020/10/H02LS6dDuQRrPbsallNVn0dRlZapB9.jpg","marketprice":"59.00","isteam":0,"productprice":"69.00"}]
         * count : 97
         */

        private int count;
        private List<ListBean> list;

        
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
             * id : 2012
             * title : 咪然 东北大米 正宗五常有机稻花香大米现磨新米原粮原产地袋装2.5kg
             * thumb : http://oss.lxtianxia.cn/cec15c26262691c80004d7bac5aed9fd.jpg
             * marketprice : 108.00
             * isteam : 2
             * productprice : 168.00
             */

            private int id;
            private String title;
            private String thumb;
            private String marketprice;
            private int isteam;
            private String productprice;

            
            public int getId() {
                return id;
            }

            public void setId(int id) {
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

            
            public String getMarketprice() {
                return marketprice;
            }

            public void setMarketprice(String marketprice) {
                this.marketprice = marketprice;

            }

            
            public int getIsteam() {
                return isteam;
            }

            public void setIsteam(int isteam) {
                this.isteam = isteam;

            }

            
            public String getProductprice() {
                return productprice;
            }

            public void setProductprice(String productprice) {
                this.productprice = productprice;

            }
        }
    }
}
