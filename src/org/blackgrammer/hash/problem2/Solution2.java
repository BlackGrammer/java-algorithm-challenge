package org.blackgrammer.hash.problem2;

public class Solution2 implements Solution {

    @Override
    public boolean solution(String[] phone_book) {

        String shortNumber;
        String longNumber;
        for (int idx = 0, len = phone_book.length; idx < len; idx++) {
            for (int idx2 = idx + 1; idx2 < len; idx2++) {
                if (phone_book[idx].length() > phone_book[idx2].length()) {
                    longNumber = phone_book[idx];
                    shortNumber = phone_book[idx2];
                } else {
                    longNumber = phone_book[idx2];
                    shortNumber = phone_book[idx];
                }

                if (longNumber.startsWith(shortNumber)) {
                    return false;
                }
            }
        }

        return true;
    }
}
