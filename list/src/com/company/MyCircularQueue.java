package com.company;

public class MyCircularQueue {
    private int length = 10;
    private String[] elements = new String[length];
    private int start = 0;
    private int end = -1;
    private int numberOfElems = 0;

    public void Append(String element)
    {
        if (numberOfElems == length) return;
        end++;
        end = end % length;
        elements[end] = element;
        numberOfElems++;
    }

    public void Prepend(String element)
    {
        if (numberOfElems == length) return;
        start--;
        if (start < 0) start += length;
        elements[start] = element;
        numberOfElems++;
    }

    public String Pop()
    {
        if (numberOfElems <= 0) return null;

        String elem = elements[start];
        start++;
        start = start % length;
        numberOfElems--;
        return elem;
    }

    public String PopEnd()
    {
        if (numberOfElems <= 0) return null;

        String elem = elements[end];
        end--;
        if (end < 0) end += length;
        numberOfElems--;
        return elem;
    }

    public void PrintAll()
    {
        for (int i = 0; i < numberOfElems; i++) {
            System.out.println(elements[(start + i) % length]);
        }
    }

    public int CountItems()
    {
        return numberOfElems;
    }

    private String repeat(String toRepeat, int n)
    {
        return new String(new char[n]).replace("\0", toRepeat);
    }

    private String makeLength(String str, int len)
    {
        return String.format("%-" + len + "s", str);
    }

    public void Stats()
    {
        int maxLength = 5;  // length of "start"
        for (int i = 0; i < numberOfElems; i++) {
            if (elements[(start + i) % length].length() > maxLength) maxLength = elements[(start + i) % length].length();
        }
        StringBuilder text = new StringBuilder("\n\n ");
        for (int i = 0; i < length; i++) {
            text.append(makeLength(String.valueOf(i), maxLength));
            if (i + 1 != length) text.append(" ");
        }
        text.append("\n┌");
        for (int i = 0; i < length; i++) {
            text.append(repeat("─", maxLength));
            if (i + 1 != length) text.append("┬");
        }
        text.append("┐\n│");
        for (int i = 0; i < length; i++) {
            String elem = elements[i];
            if (elem == null) text.append(repeat(" ", maxLength));
            else text.append(makeLength(elem, maxLength));
            text.append("│");
        }
        text.append("\n└");
        for (int i = 0; i < length; i++) {
            text.append(repeat("─", maxLength));
            if (i + 1 != length) text.append("┴");
        }
        text.append("┘\n ");
        for (int i = 0; i < length; i++) {
            if (i == start) text.append(makeLength("start", maxLength));
            else if (i == end) text.append(makeLength("end", maxLength));
            else text.append(makeLength("", maxLength));
            text.append(" ");
        }
        text.append("\n ");
        if (start == end) {
            for (int i = 0; i < length; i++) {
                if (i == end) text.append(makeLength("end", maxLength));
                else text.append(makeLength("", maxLength));
                text.append(" ");
            }
        }
        text.append("\n");
        System.out.println(text);
    }
}
