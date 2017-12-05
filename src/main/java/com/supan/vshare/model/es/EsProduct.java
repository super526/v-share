//package com.supan.vshare.model.es;
//
//import com.supan.vshare.model.Product;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.BeanUtils;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldIndex;
//
//import javax.xml.bind.annotation.XmlRootElement;
//import java.io.Serializable;
//import java.util.Date;
//
///**
// * @Author supan
// * @Date 2017/9/15 16:09
// * @Copyright(c) gome inc Gome Co.,LTD
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Document(indexName = "product", type = "product")
//@XmlRootElement // MediaType 转为 XML
//public class EsProduct implements Serializable {
//    @Id  // 主键
//    private String id;
////    @Field(index = FieldIndex.not_analyzed)
////    private Integer productId; // Product 的 id
//
//    private String productName;//商品名称
//    private String productDavName;//商品大V名称
//    private String productCategory;//商品品类
//    private String productDesc;//商品描述
//
////    @Field(index = FieldIndex.not_analyzed)  // 不做全文检索字段
//    private String productUrl;
//    @Field(index = FieldIndex.not_analyzed)  // 不做全文检索字段
//    private String productIcon;
//    @Field(index = FieldIndex.not_analyzed)  // 不做全文检索字段
//    private String productChannel;
//    @Field(index = FieldIndex.not_analyzed)  // 不做全文检索字段
//    private double productPrice;
//    @Field(index = FieldIndex.not_analyzed)  // 不做全文检索字段
//    private Integer productClick = 0;
//    @Field(index = FieldIndex.not_analyzed)  // 不做全文检索字段
//    private Integer productVote = 0;
//    @Field(index = FieldIndex.not_analyzed)  // 不做全文检索字段
//    private Date createTime;
//    @Field(index = FieldIndex.not_analyzed)  // 不做全文检索字段
//    private Integer productDavId; //推荐商品-大V编号
//
////    protected  EsProduct(){}
////
////    public EsProduct(String id, String productName, String productDavName, String productCategory, String productDesc, String productUrl, String productIcon, String productChannel, double productPrice, Integer productClick, Integer productVote, Timestamp createTime, Integer productDavId) {
////        this.id = id;
////        this.productName = productName;
////        this.productDavName = productDavName;
////        this.productCategory = productCategory;
////        this.productDesc = productDesc;
////        this.productUrl = productUrl;
////        this.productIcon = productIcon;
////        this.productChannel = productChannel;
////        this.productPrice = productPrice;
////        this.productClick = productClick;
////        this.productVote = productVote;
////        this.createTime = createTime;
////        this.productDavId = productDavId;
////    }
////
////    public String getId() {
////        return id;
////    }
////
////    public void setId(String id) {
////        this.id = id;
////    }
////
////    public String getProductName() {
////        return productName;
////    }
////
////    public void setProductName(String productName) {
////        this.productName = productName;
////    }
////
////    public String getProductDavName() {
////        return productDavName;
////    }
////
////    public void setProductDavName(String productDavName) {
////        this.productDavName = productDavName;
////    }
////
////    public String getProductCategory() {
////        return productCategory;
////    }
////
////    public void setProductCategory(String productCategory) {
////        this.productCategory = productCategory;
////    }
////
////    public String getProductDesc() {
////        return productDesc;
////    }
////
////    public void setProductDesc(String productDesc) {
////        this.productDesc = productDesc;
////    }
////
////    public String getProductUrl() {
////        return productUrl;
////    }
////
////    public void setProductUrl(String productUrl) {
////        this.productUrl = productUrl;
////    }
////
////    public String getProductIcon() {
////        return productIcon;
////    }
////
////    public void setProductIcon(String productIcon) {
////        this.productIcon = productIcon;
////    }
////
////    public String getProductChannel() {
////        return productChannel;
////    }
////
////    public void setProductChannel(String productChannel) {
////        this.productChannel = productChannel;
////    }
////
////    public double getProductPrice() {
////        return productPrice;
////    }
////
////    public void setProductPrice(double productPrice) {
////        this.productPrice = productPrice;
////    }
////
////    public Integer getProductClick() {
////        return productClick;
////    }
////
////    public void setProductClick(Integer productClick) {
////        this.productClick = productClick;
////    }
////
////    public Integer getProductVote() {
////        return productVote;
////    }
////
////    public void setProductVote(Integer productVote) {
////        this.productVote = productVote;
////    }
////
////    public Timestamp getCreateTime() {
////        return createTime;
////    }
////
////    public void setCreateTime(Timestamp createTime) {
////        this.createTime = createTime;
////    }
////
////    public Integer getProductDavId() {
////        return productDavId;
////    }
////
////    public void setProductDavId(Integer productDavId) {
////        this.productDavId = productDavId;
////    }
//
//    public EsProduct(Product product) {
//        BeanUtils.copyProperties(product, this);
//    }
//
//    public void update(Product product) {
//        BeanUtils.copyProperties(product, this);
//    }
//
//
//}
