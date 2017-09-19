package com.supan.vshare.model;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Document(indexName = "product", type = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;
    /**
     * 商品推荐大V名称
     */
    @Column(name = "product_dav_name")
    private String productDavName;
    /**
     * 商品链接
     */
    @Column(name = "product_url")
    private String productUrl;

    /**
     * 商品渠道
     */
    @Column(name = "product_channel")
    private String productChannel;

    /**
     * 单价
     */
    @Column(name = "product_price")
    private Double productPrice;

    /**
     * 商品点击量
     */
    @Column(name = "product_click")
    private Integer productClick;

    /**
     * 描述
     */
    @Column(name = "product_desc")
    private String productDesc;

    /**
     * 小图
     */
    @Column(name = "product_icon")
    private String productIcon;

    /**
     * 商品分类
     */
    @Column(name = "product_category")
    private String productCategory;

    /**
     * 推荐商品-大V编号
     */
    @Column(name = "product_dav_id")
    private Integer productDavId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 商品点赞量
     */
    @Column(name = "product_vote")
    private Integer productVote;
    public static List<String> getBaseColumns() {
        return Lists
                .newArrayList("productName", "productDavName", "productDesc", "productCategory");
    }
//    /**
//     * @return product_id
//     */
//    public Integer getProductId() {
//        return productId;
//    }
//
//    /**
//     * @param productId
//     */
//    public void setProductId(Integer productId) {
//        this.productId = productId;
//    }
//
//    /**
//     * 获取商品名称
//     *
//     * @return product_name - 商品名称
//     */
//    public String getProductName() {
//        return productName;
//    }
//
//public String getProductDavName() {
//    return productDavName;
//}
//
//    public void setProductDavName(String productDavName) {
//        this.productDavName = productDavName;
//    }
//    /**
//     * 设置商品名称
//     *
//     * @param productName 商品名称
//     */
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    /**
//     * 获取商品链接
//     *
//     * @return product_url - 商品链接
//     */
//    public String getProductUrl() {
//        return productUrl;
//    }
//
//    /**
//     * 设置商品链接
//     *
//     * @param productUrl 商品链接
//     */
//    public void setProductUrl(String productUrl) {
//        this.productUrl = productUrl;
//    }
//
//    /**
//     * 获取商品渠道
//     *
//     * @return product_channel - 商品渠道
//     */
//    public String getProductChannel() {
//        return productChannel;
//    }
//
//    /**
//     * 设置商品渠道
//     *
//     * @param productChannel 商品渠道
//     */
//    public void setProductChannel(String productChannel) {
//        this.productChannel = productChannel;
//    }
//
//    /**
//     * 获取单价
//     *
//     * @return product_price - 单价
//     */
//    public BigDecimal getProductPrice() {
//        return productPrice;
//    }
//
//    /**
//     * 设置单价
//     *
//     * @param productPrice 单价
//     */
//    public void setProductPrice(BigDecimal productPrice) {
//        this.productPrice = productPrice;
//    }
//
//    /**
//     * 获取商品点击量
//     *
//     * @return product_click - 商品点击量
//     */
//    public Integer getProductClick() {
//        return productClick;
//    }
//
//    /**
//     * 设置商品点击量
//     *
//     * @param productClick 商品点击量
//     */
//    public void setProductClick(Integer productClick) {
//        this.productClick = productClick;
//    }
//
//    /**
//     * 获取描述
//     *
//     * @return product_desc - 描述
//     */
//    public String getProductDesc() {
//        return productDesc;
//    }
//
//    /**
//     * 设置描述
//     *
//     * @param productDesc 描述
//     */
//    public void setProductDesc(String productDesc) {
//        this.productDesc = productDesc;
//    }
//
//    /**
//     * 获取小图
//     *
//     * @return product_icon - 小图
//     */
//    public String getProductIcon() {
//        return productIcon;
//    }
//
//    /**
//     * 设置小图
//     *
//     * @param productIcon 小图
//     */
//    public void setProductIcon(String productIcon) {
//        this.productIcon = productIcon;
//    }
//
//    /**
//     * 获取商品分类
//     *
//     * @return product_category - 商品分类
//     */
//    public String getProductCategory() {
//        return productCategory;
//    }
//
//    /**
//     * 设置商品分类
//     *
//     * @param productCategory 商品分类
//     */
//    public void setProductCategory(String productCategory) {
//        this.productCategory = productCategory;
//    }
//
//    /**
//     * 获取推荐商品-大V编号
//     *
//     * @return product_dav_id - 推荐商品-大V编号
//     */
//    public Integer getProductDavId() {
//        return productDavId;
//    }
//
//    /**
//     * 设置推荐商品-大V编号
//     *
//     * @param productDavId 推荐商品-大V编号
//     */
//    public void setProductDavId(Integer productDavId) {
//        this.productDavId = productDavId;
//    }
//
//    /**
//     * 获取创建时间
//     *
//     * @return create_time - 创建时间
//     */
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    /**
//     * 设置创建时间
//     *
//     * @param createTime 创建时间
//     */
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    /**
//     * 获取商品点赞量
//     *
//     * @return product_vote - 商品点赞量
//     */
//    public Integer getProductVote() {
//        return productVote;
//    }
//
//    /**
//     * 设置商品点赞量
//     *
//     * @param productVote 商品点赞量
//     */
//    public void setProductVote(Integer productVote) {
//        this.productVote = productVote;
//    }
}