package com.yang.framework.util;
import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.RandomStringUtils;

public class RandomString {

    @SuppressWarnings("unused")
    private static final char ZERO = '0';
    private static final char ONE = '1';
    private static final String ZERO_ONE_StRING = "01";



    public static String getNewStrByNumber(Long number , String orginalStr){

        String numberstr = String.valueOf(number);
        BigInteger srcb = new BigInteger(numberstr);//转换为BigInteger类型
        String binaryStr = srcb.toString(2);//转换为2进制并输出结果
        String getIsOneAllPositionStr = getIsOneAllPositionStr(binaryStr.toCharArray());
        String convertNewStr = getNewStrFromOrginalstrByOnepostion(getIsOneAllPositionStr, orginalStr);
        return convertNewStr;
    }


    /**
     * 从原始字符串经过转换得到新的字符串数组  【0】代表以1开头的数字  【1】代表新组成的字符串
     * @param generateZeroOneString
     * @param orginalStr
     * @return
     */
    public static String[] convertNewStrArrayFromOrginal(String generateZeroOneString , String orginalStr) {
        String[] str = new String[2];
        String getFirstIsOneStr = getNewZeroOneStrAfterCutOneBeforeZero(generateZeroOneString);
        String getIsOneAllPositionStr = getIsOneAllPositionStr(getFirstIsOneStr.toCharArray());
        String convertNewStr = getNewStrFromOrginalstrByOnepostion(getIsOneAllPositionStr, orginalStr);
        str[0] = getFirstIsOneStr;
        str[1] = convertNewStr;
        return str;
    }


    /**
     * 从原始字符串经过转换得到新的字符串数组  【0】代表以1开头的数字  【1】代表新组成的字符串
     *
     * @param orginalStr
     * @return
     */
    public static String[] convertNewStrArrayFromOrginal(String orginalStr) {
        String[] str = new String[2];
        int length = orginalStr.length();
        RandomString rs = new RandomString();
        int count = rs.getRandomCount(length, length);
        String generateString = RandomStringUtils.random(count, ZERO_ONE_StRING);
        String getFirstIsOneStr = getNewZeroOneStrAfterCutOneBeforeZero(generateString);
        String getIsOneAllPositionStr = getIsOneAllPositionStr(getFirstIsOneStr.toCharArray());
        String convertNewStr = getNewStrFromOrginalstrByOnepostion(getIsOneAllPositionStr, orginalStr);
        str[0] = getFirstIsOneStr;
        str[1] = convertNewStr;
        return str;
    }


    /**
     * 根据原始字符串的长度产生新组成01的字符串
     * @param orginalStr
     * @return
     */
    public static String generateZeroOneString(String orginalStr) {

        int length = orginalStr.length();
        RandomString rs = new RandomString();
        int count = rs.getRandomCount(length, length);
        String generateZeroOneString = RandomStringUtils.random(count, ZERO_ONE_StRING);

        return generateZeroOneString;
    }

    /**
     * 根据1的下标,从原始字符串得到新的字符串
     *
     * @param onePosition
     * @param orginalStr
     * @return
     */
    public static String getNewStrFromOrginalstrByOnepostion(String onePosition, String orginalStr) {
        char[] originalCharArray = orginalStr.toCharArray();
        StringBuffer sb = new StringBuffer();
        String[] tempArray = onePosition.split("-");
        for (int i = 0; i < tempArray.length; i++) {
            String temp = tempArray[i];
            if (temp != null && !(temp.trim().equals(""))) {
                sb.append(originalCharArray[Integer.parseInt(temp)]);
            }
        }
        return sb.toString();
    }

    /**
     * 得到是1的字符串在charbytes位置,中间以-分开
     *
     * @param charBytes
     * @return
     */
    public static String getIsOneAllPositionStr(char[] charBytes) {
        StringBuffer sbIsOnePosition = new StringBuffer();
        for (int i = 0; i < charBytes.length; i++) {
            char c = charBytes[i];
            switch (c) {
                case ONE:
                    sbIsOnePosition.append(i + "-");
                    break;
            }
        }
        return sbIsOnePosition.toString();
    }

    /**
     * 去除1之前所有0得到新的字符串
     *
     * @param generateString
     * @return
     */
    public static String getNewZeroOneStrAfterCutOneBeforeZero(
            String generateString) {
        char[] charBytes = generateString.toCharArray();
        boolean isOneFlag = false;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < charBytes.length; i++) {
            char c = charBytes[i];
            if (!isOneFlag) {
                switch (c) {
                    case ONE:
                        sb.append(c);
                        isOneFlag = true;
                        break;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 得到随机数的范围
     *
     * @param minValue
     * @param maxValue
     * @return
     */
    public int getRandomCount(int minValue, int maxValue) {

        return (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
    }

    /**
     * 根据位数 产生0和1的组成的字符串
     *
     * @param strLentgh
     * @return
     */
    public static String getZeroOneRandomStr(int strLentgh) {
        String generateString = RandomStringUtils.random(strLentgh,
                ZERO_ONE_StRING);
        return generateString;
    }

    public static String base64Encode(String plainText){
        byte[] b=plainText.getBytes();
        Base64 base64=new Base64();
        b=base64.encode(b);
        String s=new String(b);
        return s;
    }


    public static String base64Decode(String encodeStr){
        byte[] b=encodeStr.getBytes();
        Base64 base64=new Base64();
        b=base64.decode(b);
        String s=new String(b);
        return s;
    }

    /**
     * md5加密
     *
     * @param s
     * @return
     */
    public final static String MD5(String s) {

        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
