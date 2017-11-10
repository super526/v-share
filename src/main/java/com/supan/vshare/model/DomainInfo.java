package com.supan.vshare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author supan
 * @Date 2017/11/9 18:49
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "domain_info")
public class DomainInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //    Registrant Name: 陈绍奇  注册人
//     * Creation Date: 2017-09-08T04:59:56Z 注册时间
//     * Registry Expiry Date: 2027-09-08T04:59:56Z 过期时间

    @Column(name = "domain_name")
    private String domainName;
    @Column(name = "registr_name")
    private String registrName;
    @Column(name = "registr_date")
    private String registrDate;
    @Column(name = "expiry_date")
    private String expiryDate;
}
