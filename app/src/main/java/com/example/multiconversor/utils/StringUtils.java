package com.example.multiconversor.utils;

public class StringUtils {

    private String param;

    public StringUtils(){}

    public StringUtils(String pParam){
        this.param = pParam;
    }

    public void setParam(String pParam){
        this.param = pParam;
    }

    public String getParam(){
        return this.param;
    }

    public Boolean Capitalize(){
        StringBuilder novoParam = new StringBuilder();

        try {

            if (this.param.isEmpty()) {
                return false;
            }

            String[] arrParam = this.param.split(" ");

            for (int i=0;i<arrParam.length;i++) {
                novoParam.append(arrParam[i].substring(0, 1).toUpperCase());
                novoParam.append(arrParam[i].substring(1, arrParam[i].length()));

                if( i < arrParam.length - 1 ) {
                    novoParam.append(" ");
                }
            }

            this.param = novoParam.toString();

            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
