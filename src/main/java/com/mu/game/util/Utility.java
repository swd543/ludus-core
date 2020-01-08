package com.mu.game.util;

public class Utility {
    public static String getBinaryString(long l){
        var sb=new StringBuilder();
        sb.append(Long.toBinaryString(l));
        for(var i=sb.length();i<64;i++){
            sb.insert(0,0);
        }
        return sb.toString();
    }
}
