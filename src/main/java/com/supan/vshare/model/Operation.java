package com.supan.vshare.model;

import java.util.Date;
import javax.persistence.*;

public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ip;

    /**
     * 创建时间
     */
    private Date date;

    @Column(name = "typeId")
    private Integer typeid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取创建时间
     *
     * @return date - 创建时间
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置创建时间
     *
     * @param date 创建时间
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return typeId
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * @param typeid
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }
}