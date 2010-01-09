/* 
 * StringTokenizer.java
 *
 * This file is originally part of J2ME GPS Track
 * Copyright (C) 2006 Dana Peters
 * http://www.qcontinuum.org/gpstrack
 */
package utils;

import java.util.Vector;
/**
 * Tato trida rozdeli jeden string podle zadaneho separatoru, vrati pole stringu
 * Puvodne soucast aplikace J2ME GPS Track, Copyright (C) 2006 Dana Peters, http://www.qcontinuum.org/gpstrack
 * @author Dana Peters
 */
public class StringTokenizer {

    public static Vector getVector(String tokenList, String separator) {
        Vector tokens = new Vector();
        int commaPos = 0;
        String token = "";
        int cnt = 0;
        commaPos = tokenList.indexOf(separator);
        while (commaPos > 0) {
            commaPos = tokenList.indexOf(separator);
            if (commaPos > 0) {
                token = tokenList.substring(0, commaPos);
                tokenList = tokenList.substring(commaPos,tokenList.length());
            }
            if (!token.startsWith(separator))
                tokens.addElement(token);
            while (tokenList.startsWith(separator)) {
                cnt++;
                if (cnt >= 2)
                    tokens.addElement("");
                tokenList = tokenList.substring(1,tokenList.length());
                commaPos = tokenList.indexOf(separator);
            }
            cnt = 0;
        }
        if (commaPos < 0) {
            token = tokenList;
            tokens.addElement(token);
        }
        return tokens;
    }

    public static String[] getArray(String tokenList, String separator) {
        Vector tokens = getVector(tokenList,separator);
        String[] st = new String[tokens.size()];
        tokens.copyInto(st);
        //for (int i = 0; i <= tokens.size() - 1; i++)
        //    st[i] = (String)tokens.elementAt(i);
        return st;
    }
}
