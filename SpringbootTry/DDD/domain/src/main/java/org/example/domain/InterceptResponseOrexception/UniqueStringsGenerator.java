package org.example.domain.InterceptResponseOrexception;

import java.util.ArrayList;
import java.util.List;

import java.util.HashSet;
import java.util.Set;

public class UniqueStringsGenerator {
    public static void main(String[] args) {
        Set<String> uniqueStrings = generateUniqueStrings(200, 5);
        for (String str : uniqueStrings) {
            System.out.println(str);
        }
    }

    public static Set<String> generateUniqueStrings(int count, int length) {
        if (count > Math.pow(62, length)) {
            throw new IllegalArgumentException("Cannot generate " + count + " unique strings of length " + length);
        }

        Set<String> uniqueStrings = new HashSet<>();
        while (uniqueStrings.size() < count) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int randomInt = (int) (Math.random() * 62);
                if (randomInt < 10) {
                    // 0-9
                    sb.append((char) ('0' + randomInt));
                } else if (randomInt < 36) {
                    // A-Z
                    sb.append((char) ('A' + randomInt - 10));
                } else {
                    // a-z
                    sb.append((char) ('a' + randomInt - 36));
                }
            }
            uniqueStrings.add(sb.toString());
        }
        return uniqueStrings;
    }
}
