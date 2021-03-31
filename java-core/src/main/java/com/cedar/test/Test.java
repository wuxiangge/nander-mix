package com.cedar.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangnan
 * @date 2021/3/11 16:33
 */
public class Test {


    /**
     * 按照上限地区在前 非上线地区在后排序
     * 上限地区中如果工作室地区存在 非工作室放在前
     */
    private static final Comparator<BatchDeclareLocalStatisticSharedDTO> LOCATION_COMPARATOR = (e1, e2) -> {
        // 首先把白名单放在前面
        int whiteResult = Boolean.compare(e1.getBoolInWhiteList(), e2.getBoolInWhiteList());

        // 然后按照地区顺序排序
        if (whiteResult != 0) {
            int studioResult = Boolean.compare(e1.getBoolInStudioLocation(), e2.getBoolInStudioLocation());

            if (studioResult != 0) {
                // 当前工作室中放在第一位
                Integer e1Value = DeclareSortEnum.getEnum(e1.getLocationCode()).getValue();
                Integer e2Value = DeclareSortEnum.getEnum(e2.getLocationCode()).getValue();
                int valueResult = Integer.compare(e2Value, e1Value);
                return valueResult;
            } else {
                return studioResult;
            }
        } else {
            return whiteResult;
        }

    };


    public static void main(String[] args) {


        List<BatchDeclareLocalStatisticSharedDTO> batchDeclareLocalStatisticSharedDTOS = new ArrayList<>();


        BatchDeclareLocalStatisticSharedDTO batchDeclareLocalStatisticSharedDTO = new BatchDeclareLocalStatisticSharedDTO();

        batchDeclareLocalStatisticSharedDTO.setBoolInStudioLocation(true);
        batchDeclareLocalStatisticSharedDTO.setBoolInWhiteList(false);

        batchDeclareLocalStatisticSharedDTOS.add(batchDeclareLocalStatisticSharedDTO);


        BatchDeclareLocalStatisticSharedDTO batchDeclareLocalStatisticSharedDTO2 = new BatchDeclareLocalStatisticSharedDTO();

        batchDeclareLocalStatisticSharedDTO2.setBoolInStudioLocation(true);
        batchDeclareLocalStatisticSharedDTO2.setBoolInWhiteList(true);

        batchDeclareLocalStatisticSharedDTOS.add(batchDeclareLocalStatisticSharedDTO2);


        batchDeclareLocalStatisticSharedDTOS.sort(LOCATION_COMPARATOR);

    }

}
