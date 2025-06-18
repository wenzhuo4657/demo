package org.example.domain.InterceptResponseOrexception.handler;

public class ErrorInfo<T> {

    private String code;
    private String info;

    private T data;


    public ErrorInfo(String code, String info, T data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



    public static final class Builder<T>{
        private String code;
        private String info;

        private T data;




        public Builder<T> code(String code){
            this.code = code;
            return this;
        }
        public Builder<T> info(String info){
            this.info = info;
            return this;
        }

        public Builder<T> data(T data){
            this.data = data;
            return this;
        }
        public ErrorInfo<T> build(){
            return new ErrorInfo<T>(code, info, data);
        }

        public static <T> Builder<T> builder(){
            return new Builder<T>();
        }

    }
}
