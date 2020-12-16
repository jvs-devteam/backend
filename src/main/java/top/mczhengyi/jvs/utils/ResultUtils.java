package top.mczhengyi.jvs.utils;

import top.mczhengyi.jvs.bean.Result;
import top.mczhengyi.jvs.bean.ResultEnum;

public class ResultUtils {
    /**
     * 请求处理成功
     * @return 返回一个无数据的结果对象
     */
    public static Result success() {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 请求处理成功并返回了数据
     * @param object 数据
     * @return 返回一个含有数据的结果对象
     */
    public static Result success(Object object) {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), object);
    }

    /**
     * 服务器处理错误或请求错误
     * @return 错误的结果对象
     */
    public static Result fail() {
        return new Result(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMessage(), null);
    }

    /**
     * 请求处理错误或请求错误 自定义错误
     * @param message 错误信息
     * @return 返回一个错误的结果对象
     */
    public static Result fail(String message) {
        return new Result(ResultEnum.UNKNOWN_ERROR.getCode(), message, null);
    }
}
