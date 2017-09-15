package com.supan.vshare.model.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @Author supan
 * @Date 2017/9/15 16:09
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "product", type = "product")
@XmlRootElement // MediaType 转为 XML
public class EsProduct implements Serializable {
    @Id  // 主键
    private String id;
    @Field(index = FieldIndex.not_analyzed)
    private Integer productId; // Product 的 id

    private String productName;
    private String productCategory;
    private Integer productDavId; //推荐商品-大V编号
}
