package com.cedar.test;


import java.util.Objects;

/**
 * 申报上线展示
 *
 * @author zhangnan
 * @date 2021/3/11 15:07
 */
public enum DeclareSortEnum {

    HE_BEI("13", "130000", "河北", 10),

    SHEN_ZHEN("4403", "440300", "深圳", 20),

    GUANG_DONG("44", "440000", "广东", 30),

    XIN_JIANG("65", "650000", "新疆", 40),

    GAN_SU("62", "620000", "甘肃", 50),

    SHANG_HAI("31", "310000", "上海", 60),

    NING_BO("3302", "330200", "宁波", 70),

    HE_NAN("41", "410000", "河南", 80),

    NING_XIA("64", "640000", "宁夏", 90),

    SHAAN_XI("61", "610000", "陕西", 100),

    SHAN_DONG("37", "370000", "山东", 110),

    BEI_JING("11", "110000", "北京", 120),

    SI_CHUAN("51", "510000", "四川", 130),

    QING_HAI("63", "630000", "青海", 140),

    TIAN_JIN("12", "120000", "天津", 150),

    GUANG_XI("45", "450000", "广西", 160),

    ZHE_JIANG("33", "330000", "浙江", 170),

    XIA_MEN("3502", "350200", "厦门", 180),

    FU_JIAN("35", "350000", "福建", 190),

    CHONG_QING("50", "500000", "重庆", 200),

    SHAN_XI("14", "140000", "山西", 210),

    JIANG_XI("36", "360000", "江西", 220),

    JIANG_SU("32", "320000", "江苏", 210),

    GUI_ZHOU("52", "520000", "贵州", 220),

    AN_HUI("34", "340000", "安徽", 230),

    HU_BEI("42", "420000", "湖北", 240),

    HU_NAN("43", "430000", "湖南", 250),

    HAI_NAN("46", "460000", "海南", 260),

    QING_DAO("3702", "370200", "青岛", 270),

    JI_LIN("22", "220000", "吉林", 280),

    YUN_NAN("53", "530000", "云南", 290),

    HEI_LONG_JIANG("23", "230000", "黑龙江", 300),

    NEI_MENG("15", "150000", "内蒙古", 310),

    LIAO_NING("21", "210000", "辽宁", 320),

    DA_LIAN("2102", "210200", "大连", 330),

    XI_ZANG("54", "540000", "西藏", 340),

    CN("0", "000000", "全国", 350);

    /**
     * key的前缀
     */
    private String shortKey;
    /**
     * 地区码
     */
    private String key;


    private String keyName;

    /**
     * 地区码的权重
     */
    private Integer value;


    DeclareSortEnum(String shortKey, String key, String keyName, Integer value) {
        this.shortKey = shortKey;
        this.key = key;
        this.keyName = keyName;
        this.value = value;
    }


    /**
     * 获取枚举字段
     *
     * @param key
     * @return
     */
    public static DeclareSortEnum getEnum(String key) {
        DeclareSortEnum sortEnum = CN;
        for (DeclareSortEnum declareSortEnum : DeclareSortEnum.values()) {
            if (Objects.equals(declareSortEnum.getKey(), key)) {
                sortEnum = declareSortEnum;
                break;
            }
        }
        return sortEnum;
    }


    public String getShortKey() {
        return shortKey;
    }

    public String getKeyName() {
        return keyName;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }
}
