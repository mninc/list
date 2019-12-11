package com.company;

class MyData {
    private String theData;
    private MyData next = null;
    private MyData prev = null;

    MyData(String someData, MyData oneBefore, MyData oneAfter)
    {
        theData = someData;
        next = oneAfter;
        prev = oneBefore;
    }
    void setNext(MyData theNext){
        next = theNext;
    }

    void setPrevious(MyData thePrev){
        prev = thePrev;
    }

    MyData Next()
    {
        return next;
    }
    MyData Previous()
    {
        return prev;
    }
    String GetString()
    {
        return theData;
    }

}
