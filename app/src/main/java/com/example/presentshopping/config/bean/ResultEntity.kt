package com.example.presentshopping.config.bean

/**
 * @author created by edz
 * 网络请求返回实体
 */
class ResultEntity {
    /**
     * data : null
     * code : 0
     * msg : 新增成功
     */
    var data: Any? = null
    var code = 0
    var msg: String? = null
    override fun toString(): String {
        return "ResultEntity{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}'
    }
}