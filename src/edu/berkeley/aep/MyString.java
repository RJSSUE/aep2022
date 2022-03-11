package edu.berkeley.aep;

public class MyString {
    private String content;
    public MyString(String string) {
        content = string;
    }

    public String reversed(){
        return reverse(content);
    }
    public String reverse(String string) {
        if (string.length() < 2) return string;
        return reverse(string.substring(1)) + string.charAt(0);
    }
}
