package com.yang.framework.util;

import java.util.UUID;

/**
 * User: Andy
 * Date: 12-9-11
 * Time: 下午7:17
 */
public class UuidUtil {

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8) + uuid.substring(9, 13)
                + uuid.substring(14, 18) + uuid.substring(19, 23)
                + uuid.substring(24);
    }
}
