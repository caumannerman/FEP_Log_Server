package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String visited;

    @Column
    private String date;

    @Column
    private String sLength;

    @Column
    private String sTrCode;
    @Column
    private String sRpCode;
    @Column
    private String sSeq;
    @Column
    private String sDataCnt;
    @Column
    private String sMsgGb;
    @Column
    private String sOrderNo ;
    @Column
    private String sIssueCode;
    @Column
    private String sAcctNo;
    @Column
    private String sTrdNo;
    @Column
    private String sTrdPrice;
    @Column
    private String sTrdQty;
    @Column
    private String sTrdType;
    @Column
    private String sTrdTime;
    @Column
    private String sNearTrdPrice;
    @Column
    private String sFarTrdPrice;
    @Column
    private String sSide;
    @Column
    private String sBookCode;
    @Column
    private String sFiller;
    @Column
    private String sPurpose;
    @Column
    private String sBalanceType;
    @Column
    private String sdontknow;


}
