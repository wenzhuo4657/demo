package org.example;

public class SwtichTest {
    public static void main(String[] args) {
        String day="M";


        // 返回值测试
        String result = switch (day) {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";
            default -> {
                if(day.isEmpty())
                    yield "Please insert a valid day.";
                else
                    yield "Looks like a Sunday.";
            }

        };
        System.out.println(result);


    }
}
