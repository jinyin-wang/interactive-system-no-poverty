package com.hualala.openapiPlatform.model.dto;

import lombok.Data;

/**
 * Created by Administrator on 2019/5/13. A Class working as an entity to put some special entities
 * to the front page
 */
@Data
public class AfCalculate {
    private String countyname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.foodstampRate
     *
     * @mbg.generated
     */
    private String foodstamprate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.povertyRate
     *
     * @mbg.generated
     */
    private String povertyrate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.malePovertyRate
     *
     * @mbg.generated
     */
    private String malepovertyrate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.femalePovertyRate
     *
     * @mbg.generated
     */
    private String femalepovertyrate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.underhighschoolPovertyRate
     *
     * @mbg.generated
     */
    private String underhighschoolpovertyrate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.highschoolPovertyRate
     *
     * @mbg.generated
     */
    private String highschoolpovertyrate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.collegePovertyRate
     *
     * @mbg.generated
     */
    private String collegepovertyrate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.bachelorPovertyRate
     *
     * @mbg.generated
     */
    private String bachelorpovertyrate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.disabilityCorelation
     *
     * @mbg.generated
     */
    private String disabilitycorelation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.avgHouseAgeCorelation
     *
     * @mbg.generated
     */
    private String avghouseagecorelation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.avgFuelUseageCorelation
     *
     * @mbg.generated
     */
    private String avgfueluseagecorelation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.fulljobCorelation
     *
     * @mbg.generated
     */
    private String fulljobcorelation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.partjobCorelation
     *
     * @mbg.generated
     */
    private String partjobcorelation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bfpredict.nojobCorelation
     *
     * @mbg.generated
     */
    private String nojobcorelation;

    private String cor1;

    private String cor2;

    private String cor3;

    private String foodstamp;
}