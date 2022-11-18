package com.paragonitfeni.main.Model;

import java.math.BigInteger;

public class Common_Resources {

    public static String securedPasswordM(String inputMessage) {

        StringBuilder messageToBinaryBuilder = new StringBuilder();
        char[] chars = inputMessage.toCharArray();
        for (char c : chars) {
            messageToBinaryBuilder.append(String.format("%8s", Integer.toBinaryString(c)).replaceAll(" ", "0"));
        }

        // Text to Binary
        StringBuilder SecurityStringToBinaryBuilder = new StringBuilder();

        char[] chars2 = DB.SECURITY_STRING.toCharArray();
        for (char c2 : chars2) {
            SecurityStringToBinaryBuilder.append(String.format("%8s", Integer.toBinaryString(c2)).replaceAll(" ", "0"));
        }

        StringBuilder SecurityCodeToBinaryBuilder = new StringBuilder();

        char[] chars3 = DB.SECURITY_CODE.toCharArray();
        for (char c3 : chars3) {
            SecurityCodeToBinaryBuilder.append(String.format("%8s", Integer.toBinaryString(c3)).replaceAll(" ", "0"));
        }

        String inputMessageBinaryString = messageToBinaryBuilder.toString();
        String securityStringBinaryString = SecurityStringToBinaryBuilder.toString();
        String securityCodeBinaryString = SecurityCodeToBinaryBuilder.toString();
        String transmitMessage = securityStringBinaryString + securityCodeBinaryString + inputMessageBinaryString
                + securityStringBinaryString + securityCodeBinaryString;

        // Binary To Hexadecimal
        String hexString = new BigInteger(transmitMessage, 2).toString(16);
        System.out.println("Sent Message: " + hexString);

        return hexString;
    }

}