package com.ray.partner_matching_system.once.importuser;

import com.alibaba.excel.EasyExcel;

import java.util.List;

/**
 * 导入 Excel
 */
public class ImportExcel {

    /**
     * 读取数据
     */
    public static void main(String[] args) {
        
        String fileName = "/Users/ray/Documents/partner-matching-backend/partner-matching-system/src/main/resources/testExcel.xlsx";
        synchronousRead(fileName);
    }

    /**
     * 监听器读取
     */
    public static void readByListener(String fileName) {
        EasyExcel.read(fileName, XingQiuTableUserInfo.class, new TableListener()).sheet().doRead();
    }


    /**
     * 同步读
     */
    public static void synchronousRead(String fileName) {
        // 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<XingQiuTableUserInfo> totalDataList =
                EasyExcel.read(fileName).head(XingQiuTableUserInfo.class).sheet().doReadSync();
        for (XingQiuTableUserInfo xingQiuTableUserInfo : totalDataList) {
            System.out.println(xingQiuTableUserInfo);
        }
    }

}
