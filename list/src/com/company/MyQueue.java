package com.company;

public class MyQueue extends MyLinkedList {
    public void Append(String text)
    {
        AppendItem(text);
    }

    public String Pop()
    {
        MyData elem = GetItem(0);
        DeleteItem(0);
        if (elem != null) return elem.GetString();
        else return null;
    }
}
