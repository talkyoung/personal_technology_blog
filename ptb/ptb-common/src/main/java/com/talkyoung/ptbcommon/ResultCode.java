package com.talkyoung.ptbcommon;


public enum ResultCode implements IErrorCode {

    //common
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    VALIDATE_CODE_ERROR(10000,"登陆密码出错"),


    MERCHANT_NOT_PASS(10005,"该账户下店铺暂未通过审核"),
    MERCHANT_NAME_USED(10006,"店铺名称已被使用"),
    USER_NAME_USED(10007,"账户名称已被使用"),
    SUBJECT_CATEGORY_USED(10008,"该分类已存在"),
    PREFERENCE_AREA_USED(10009,"该优选名称已存在"),
    NO_MEMBER_ADDRESS(10010,"没有绑定收获地址"),
    REDIS_CONNECTION_ERROR(10011,"没有绑定收获地址"),
    MERCHANT_USER_NOT_PASS(10012,"该账户暂未通过审核"),
    PHONE_NUMBER_USED(10013,"手机号码已被注册"),
    USER_NOT_FOUND(10014,"账号或密码错误"),
    PAY_ACCOUNT_USED(10015,"该支付账号已添加"),
    //订单相关
    ORDER_FLASH_STOCK_OVER(20001,"活动商品库存不足"),
    ORDER_FLASH_REPEAT_ORDER(20002,"重复订单"),
    ORDER_SN_SUBMIT_REPEAT(20003,"重复提交订单"),
    ORDER_SN_NOT_EXIST(20004,"订单已经失效，请重新下单"),
    ORDER_STOCK_LACK(20005,"订单库存不足"),
    ORDER_STOCK_NOT_SET_PRICE(20006,"产品规格没有设置价格"),
    ORDER_FLASH_NOT_FOUND(20001,"没有符合条件的订单"),
    //产品相关
    PRODUCT_VERIFY_NOT_PASS(30001,"操作无效，商品暂未通过审核！"),
    ;


    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
