/*
 * Copyright 2013-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.util;

/**
 * A Base 16 CODEC API. See http://www.ietf.org/rfc/rfc4648.txt
 *
 * @author Hanson Char
 */
@SuppressWarnings("checkstyle:nowhitespacebefore")
public enum Base16 {
    ;
    private static final Base16Codec CODEC = new Base16Codec();

    /**
     * @param bytes the bytes.
     * @return a base 16 encoded string of the given bytes.
     */
    public static String encodeAsString(byte... bytes) {
        if (bytes == null)
            return null;
        return bytes.length == 0 ? "" : CodecUtils.toStringDirect(CODEC.encode(bytes));
    }

    /**
     * @param bytes the bytes.
     * @return a 16 encoded byte array of the given bytes.
     */
    public static byte[] encode(byte[] bytes) {
        return bytes == null || bytes.length == 0 ? bytes : CODEC.encode(bytes);
    }

    /**
     * Decodes the given base 16 encoded string, skipping carriage returns, line
     * feeds and spaces as needed.
     * @param b16 the string to decode.
     * @return the decoded string in bytes.
     */
    public static byte[] decode(String b16) {
        if (b16 == null)
            return null;
        if (b16.length() == 0)
            return new byte[0];
        byte[] buf = new byte[b16.length()];
        int len = CodecUtils.sanitize(b16, buf);
        return CODEC.decode(buf, len);
    }

    /**
     * Decodes the given base 16 encoded bytes.
     * @param b16 the byte[] to decode.
     * @return the decoded result.
     */
    public static byte[] decode(byte[] b16) {
        return b16 == null || b16.length == 0 ? b16 : CODEC.decode(b16, b16.length);
    }
}
