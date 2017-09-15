package com.supan.vshare.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "product_dav")
public class ProductDav {
    @Id
    @Column(name = "dav_id")
    private Integer davId;

    /**
     * 大V名字
     */
    @Column(name = "dav_name")
    private String davName;

    /**
     * 大V描述
     */
    @Column(name = "dav_desc")
    private String davDesc;

    /**
     * 大V标签
     */
    @Column(name = "dav_tag")
    private String davTag;

    /**
     * 大V编号
     */
    @Column(name = "dav_type")
    private Integer davType;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return dav_id
     */
    public Integer getDavId() {
        return davId;
    }

    /**
     * @param davId
     */
    public void setDavId(Integer davId) {
        this.davId = davId;
    }

    /**
     * 获取大V名字
     *
     * @return dav_name - 大V名字
     */
    public String getDavName() {
        return davName;
    }

    /**
     * 设置大V名字
     *
     * @param davName 大V名字
     */
    public void setDavName(String davName) {
        this.davName = davName;
    }

    /**
     * 获取大V描述
     *
     * @return dav_desc - 大V描述
     */
    public String getDavDesc() {
        return davDesc;
    }

    /**
     * 设置大V描述
     *
     * @param davDesc 大V描述
     */
    public void setDavDesc(String davDesc) {
        this.davDesc = davDesc;
    }

    /**
     * 获取大V标签
     *
     * @return dav_tag - 大V标签
     */
    public String getDavTag() {
        return davTag;
    }

    /**
     * 设置大V标签
     *
     * @param davTag 大V标签
     */
    public void setDavTag(String davTag) {
        this.davTag = davTag;
    }

    /**
     * 获取大V编号
     *
     * @return dav_type - 大V编号
     */
    public Integer getDavType() {
        return davType;
    }

    /**
     * 设置大V编号
     *
     * @param davType 大V编号
     */
    public void setDavType(Integer davType) {
        this.davType = davType;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}