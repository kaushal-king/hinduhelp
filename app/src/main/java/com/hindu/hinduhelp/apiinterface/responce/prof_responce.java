package com.hindu.hinduhelp.apiinterface.responce;


import com.hindu.hinduhelp.apiinterface.get_set.prof_get_set;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class prof_responce
{
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("de")
    @Expose
    private List<prof_get_set> de = null;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<prof_get_set> getDe() {
        return de;
    }

    public void setDe(List<prof_get_set> de) {
        this.de = de;
    }

}
