package com.p609915198.fwb.utils;import android.text.TextUtils;/** * Created by mark.liu on 2018-3-28. */public class DateUtil {    public static long string2Mills(String date) {        if (TextUtils.isEmpty(date)) {            return 0;        }        long all = 0;        String[] s = date.split(":");        for (int i = 0; i < s.length; i++) {            String index = s[i];            if (!TextUtils.isEmpty(index)) {                int indexInt = Integer.parseInt(index);                switch (i) {                    case 0:                        all += indexInt * 60 * 60 * 1000;                        break;                    case 1:                        all += indexInt * 60 * 1000;                        break;                    case 2:                        all += indexInt * 1000;                        break;                }            }        }        return all;    }}