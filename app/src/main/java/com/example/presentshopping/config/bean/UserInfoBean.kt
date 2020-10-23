package com.example.presentshopping.config.bean

class UserInfoBean {
    /**
     * code : 0
     * msg : 获取用户信息成功
     * data : {"nickname":null,"mobile":"18617035298","uid":"11","balance":"0.00","points":0,"paypwd":null,"pay":2}
     */
    var code = 0
    var msg: String? = null
    var data: DataBean? = null

    class DataBean {
        /**
         * nickname : null
         * mobile : 18617035298
         * uid : 11
         * balance : 0.00
         * points : 0
         * paypwd : null
         * pay : 2
         */
        var nickname: Any? = null
        var mobile: String? = null
        var uid: String? = null
        var balance: String? = null
        var points = 0
        var paypwd: Any? = null
        var pay = 0
    }
}