package com.zeus3110.theater_automation.Equipment;

public class ByteHexUtil {

	    //16進数の文字列をバイト配列に変換
	    public static byte[] toByteArray(String hex) {
	        byte[] bytes = new byte[hex.length() / 2];
	        for (int index = 0; index < bytes.length; index++) {
	            bytes[index] = (byte) Integer.parseInt(hex.substring(index * 2, (index + 1) * 2), 16);
	        }
	        return bytes;
	    }

	    //バイト配列を16進数の文字列に変換
	    public static String toHexString(byte bytes[]) {
	        StringBuffer strbuf = new StringBuffer(bytes.length * 2);
	        for (int index = 0; index < bytes.length; index++) {
	            int bt = bytes[index] & 0xff;
	            if (bt < 0x10) {
	                strbuf.append("0");
	            }
	            strbuf.append(Integer.toHexString(bt));
	        }
	        return strbuf.toString();
	    }
}
