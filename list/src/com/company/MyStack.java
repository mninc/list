package com.company;

public class MyStack extends MyLinkedList {
    public void Push(String elem)
    {
        AppendItem(elem);
    }

    public String Pop()
    {
        int len = CountItems();
        MyData elem = GetItem(len - 1);
        DeleteItem(len - 1);
        if (elem != null) return elem.GetString();
        else return null;
    }
}
