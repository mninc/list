package com.company;

public class MyLinkedList {
    private MyData startOfList = null;

    public void AppendItem(String text)
    {
        if (startOfList != null) {
            MyData thisElem = startOfList;
            while (thisElem.Next() != null) thisElem = thisElem.Next();
            thisElem.setNext(new MyData(text, thisElem, null));
        } else startOfList = new MyData(text, null, null);
    }

    public void PrependItem(String text)
    {
        startOfList = new MyData(text, null, startOfList);
    }

    public void DeleteItem(int number)
    {
        if (startOfList == null) return;
        int counter = 0;
        MyData thisElem = startOfList;
        while (counter != number) {
            counter++;
            thisElem = thisElem.Next();
            if (thisElem == null) return;
        }
        MyData nextElem = thisElem.Next();
        MyData prevElem = thisElem.Previous();
        if (prevElem != null) prevElem.setNext(nextElem);
        else startOfList = nextElem;
        if (nextElem != null) nextElem.setPrevious(prevElem);
    }

    public MyData GetItem(int index)
    {
        int counter = 0;
        MyData thisElem = startOfList;
        while (counter != index) {
            counter++;
            thisElem = thisElem.Next();
            if (thisElem == null) return null;
        }
        return thisElem;
    }


    public int CountItems()
    {
        int counter = 0;
        MyData thisElem = startOfList;
        while (thisElem != null) {
            counter++;
            thisElem = thisElem.Next();
        }
        return counter;
    }

    private void PrintAll2()
    {
        MyData thisElem = startOfList;
        StringBuilder output = new StringBuilder("");
        while (thisElem != null) {
            output.append(thisElem.GetString());
            thisElem = thisElem.Next();
            if (thisElem != null) output.append(", ");
        }
        System.out.println(output);
    }

    public void PrintAll()
    {
        System.out.println("String elements:");
        PrintAll2();
    }

    public void PrintAll(String text)
    {
        System.out.println(text);
        PrintAll2();
    }

    public void BubbleSort(boolean forwards)
    {
        int changes = -1;
        while (changes != 0) {
            changes = 0;
            MyData thisElem = startOfList;
            while (thisElem != null) {
                MyData nextElem = thisElem.Next();
                if (nextElem == null) break;

                int comparison = thisElem.GetString().compareToIgnoreCase(nextElem.GetString());
                if (!forwards) comparison = -comparison;
                if (comparison > 0) {
                    changes++;
                    thisElem.setNext(nextElem.Next());
                    if (thisElem.Previous() == null) startOfList = nextElem;
                    else thisElem.Previous().setNext(nextElem);
                    if (nextElem.Next() != null) nextElem.Next().setPrevious(thisElem);
                    nextElem.setPrevious(thisElem.Previous());
                    nextElem.setNext(thisElem);
                    thisElem.setPrevious(nextElem);
                } else thisElem = nextElem;
            }
        }
    }

    private MyLinkedList[] Split(MyLinkedList toSplit)
    {
        int length = toSplit.CountItems();
        int midpoint = length / 2;
        MyLinkedList a = new MyLinkedList();
        MyLinkedList b = new MyLinkedList();
        MyData thisElem = toSplit.startOfList;
        for (int i = 0; i < length; i++) {
            if (i < midpoint) a.AppendItem(thisElem.GetString());
            else b.AppendItem(thisElem.GetString());
            thisElem = thisElem.Next();
        }
        return new MyLinkedList[] {a, b};
    }


    public MyLinkedList MergeSort(MyLinkedList toSort)
    {
        if (toSort.CountItems() == 1) return toSort;
        MyLinkedList[] data = Split(toSort);
        MyLinkedList a = data[0];
        MyLinkedList b = data[1];
        a = MergeSort(a);
        b = MergeSort(b);
        MyLinkedList toReturn = new MyLinkedList();

        while (a.CountItems() > 0 || b.CountItems() > 0) {
            if (a.CountItems() == 0) {
                toReturn.AppendItem(b.startOfList.GetString());
                b.DeleteItem(0);
            } else if (b.CountItems() == 0) {
                toReturn.AppendItem(a.startOfList.GetString());
                a.DeleteItem(0);
            } else {
                int comparison = a.startOfList.GetString().compareToIgnoreCase(b.startOfList.GetString());
                if (comparison <= 0) { // a is smaller
                    toReturn.AppendItem(a.startOfList.GetString());
                    a.DeleteItem(0);
                } else {
                    toReturn.AppendItem(b.startOfList.GetString());
                    b.DeleteItem(0);
                }
            }
        }
        return toReturn;
    }

    public void InsertionSort()
    {
        int length = CountItems();
        for (int i = 1; i < length; i++) {
            MyData thisElem = GetItem(i);
            for (int j = 0; j <= i+1 && j < length; j++) {
                MyData compare = GetItem(j);
                if (compare == thisElem) continue;
                int comparison = thisElem.GetString().compareToIgnoreCase(compare.GetString());
                if (comparison <= 0 || j > i) { // thisElem is smaller
                    if (thisElem.Next() != null) thisElem.Next().setPrevious(thisElem.Previous());
                    thisElem.Previous().setNext(thisElem.Next());
                    MyData beforeC = compare.Previous();
                    if (beforeC != null) beforeC.setNext(thisElem);
                    else startOfList = thisElem;
                    thisElem.setPrevious(beforeC);
                    thisElem.setNext(compare);
                    compare.setPrevious(thisElem);
                    break;
                }
            }
        }
    }

    private MyLinkedList Partition(MyLinkedList in)
    {
        MyData start = in.startOfList;
        in.DeleteItem(0);
        MyLinkedList smaller = new MyLinkedList();
        MyLinkedList larger = new MyLinkedList();

        // iterate

        return this;
    }

    public void QuickSort()
    {

    }
}
