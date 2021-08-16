package com.cmk.utils;

import java.util.UUID;

public class UIDUtil {

    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
