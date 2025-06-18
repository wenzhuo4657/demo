package org.example.domain.InterceptResponseOrexception.handler;


/**
 * 功能描述：响应结果
 *
 */

public class Response<T> {

    /**
     * 结果码
     */
    private String code;
    /**
     * 数据
     */
    private T data;
    /**
     * 信息
     */
    private String message;

    /**
     * 返回成功码的构建器
     *
     * @return 成功码的构建器
     */
    public static <T> Response<T> ok() {
        return ok(null);
    }

    /**
     * 返回成功码的构建器
     *
     * @param data 响应体
     * @param <T>  响应体类型
     * @return 成功码的构建器
     */
    public static <T> Response<T> ok(T data) {
        return new Response<T>().withCode("200").withData(data);
    }

    /**
     * 返回指定编码的构建器
     *
     * @param code 编码
     * @return 成功码的构建器
     */
    public static <T> Response<T> code(String code) {
        return new Response<T>().withCode(code);
    }

    /**
     * 返回自定义失败构建器
     *
     * @param errorCode 错误编码
     * @param message   错误消息
     * @param <T>
     * @return
     */
    public static <T> Response<T> fail(String errorCode, String message) {
        return (new Response()).withCode(errorCode).withMessage(message);
    }


    /**
     * 设置结果编码
     *
     * @param code 结果编码
     * @return Builder
     */
    public Response<T> withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * 设置数据
     *
     * @param data 数据
     * @return this
     */
    public Response<T> withData(T data) {
        this.data = data;
        return this;
    }

    /**
     * 设置信息
     *
     * @param message 信息
     * @return this
     */
    public Response<T> withMessage(String message) {
        this.message = message;
        return this;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
