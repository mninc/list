package com.company;

public class MyPriorityQueue extends MyLinkedList {
    private MyQueue priority = new MyQueue();
    private MyQueue normal = new MyQueue();

    public void Append(String text, boolean hasPriority)
    {
        if (hasPriority) priority.Append(text);
        else normal.Append(text);
    }

    public String Pop()
    {
        if (priority.CountItems() > 0) return priority.Pop();
        return normal.Pop();
    }

    public void PrintAll()
    {
        priority.PrintAll("Priority elements:");
        normal.PrintAll("Normal elements:");
    }

    public void BubbleSort(boolean forwards)
    {
        priority.BubbleSort(forwards);
        normal.BubbleSort(forwards);
    }

    public void MergeSort()
    {
        priority = (MyQueue)priority.MergeSort(priority);
        normal = (MyQueue)normal.MergeSort(normal);
    }

    public void InsertionSort()
    {
        priority.InsertionSort();
        normal.InsertionSort();
    }

    public int CountItems()
    {
        return priority.CountItems() + normal.CountItems();
    }
}
