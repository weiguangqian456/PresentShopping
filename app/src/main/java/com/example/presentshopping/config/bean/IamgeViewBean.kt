package com.example.presentshopping.config.bean

class IamgeViewBean {
    /**
     * code : 0
     * msg : 操作成功
     * data : {"list":[{"img":"https://i.loli.net/2020/09/27/8H9MGwSaKhbYgsf.jpg","url":"www.baidu.com"},{"img":"https://i.loli.net/2020/09/27/TriKIlSREdx7Hmk.jpg","url":"www.baidu.com"},{"img":"https://i.loli.net/2020/09/27/8Hdhgfq9X2pw7Mo.jpg","url":"www.baidu.com"}]}
     */
    var code = 0
    var msg: String? = null
    var data: DataBean? = null

    class DataBean  {
        var list: List<ListBean>? = null

        class ListBean  {
            /**
             * img : https://i.loli.net/2020/09/27/8H9MGwSaKhbYgsf.jpg
             * url : www.baidu.com
             */
            var img: String? = null
            var url: String? = null
        }
    }
}