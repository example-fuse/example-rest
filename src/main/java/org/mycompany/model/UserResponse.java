package org.mycompany.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


public class UserResponse {


    private String code;


    private String messsage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "code='" + code + '\'' +
                ", messsage='" + messsage + '\'' +
                '}';
    }
}
