package com.cedar.test;

/**
 * @author zhangnan
 * @date 2021/3/4 10:39
 */
public class BatchDeclareLocalStatisticSharedDTO {


    /**
     * 是否是工作室地区
     */
    private Boolean boolInStudioLocation = false;

    /**
     * 地区吗
     */
    private String locationCode;

    /**
     * 地区值
     */
    private String locationValue;

    /**
     * 企业总量
     */
    private Integer totalNum = 0;


    /**
     * 未进行报税设置的企业数量
     */
    private Integer nonTaxSetting = 0;


    /**
     * 安全认证数量
     */
    private Integer securityNum = 0;


    /**
     * 是否在白名单中
     */
    private Boolean boolInWhiteList = false;


    public Boolean getBoolInStudioLocation() {
        return boolInStudioLocation;
    }

    public void setBoolInStudioLocation(Boolean boolInStudioLocation) {
        this.boolInStudioLocation = boolInStudioLocation;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationValue() {
        return locationValue;
    }

    public void setLocationValue(String locationValue) {
        this.locationValue = locationValue;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getNonTaxSetting() {
        return nonTaxSetting;
    }

    public void setNonTaxSetting(Integer nonTaxSetting) {
        this.nonTaxSetting = nonTaxSetting;
    }

    public Integer getSecurityNum() {
        return securityNum;
    }

    public void setSecurityNum(Integer securityNum) {
        this.securityNum = securityNum;
    }

    public Boolean getBoolInWhiteList() {
        return boolInWhiteList;
    }

    public void setBoolInWhiteList(Boolean boolInWhiteList) {
        this.boolInWhiteList = boolInWhiteList;
    }
}
