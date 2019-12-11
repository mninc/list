package com.company;

import java.util.*;

public class Main {
    private Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    private void run()
    {
        System.out.println("Hello, we are going to make list of strings");
        System.out.println("Pick list type (linked list l, stack s, queue q, priority queue pq, circular queue cq)");

        String choice = s.nextLine().trim();
        if (choice.startsWith("l")) {
            L();
        } else if (choice.startsWith("s")) {
            S();
        } else if (choice.startsWith("q")) {
            Q();
        } else if (choice.startsWith("pq")) {
            PQ();
        } else if (choice.startsWith("cq")) {
            CQ();
        }
    }

    private int GetChoice(String[] options)
    {
        System.out.println("What would you like to do now?");
        int len = options.length;
        for (int i = 0; i < len; i++) {
            System.out.println((i + 1) + " " + options[i]);
        }
        int choice = Integer.parseInt(s.nextLine().trim());
        if (choice > len) {
            System.out.println("Invalid choice");
            return GetChoice(options);
        } else {
            return choice;
        }
    }

    private ArrayList<String> GetElements()
    {
        ArrayList<String> elems = new ArrayList<String>();
        System.out.println("Type in lines of text, followed by enter. When you have finished press Enter twice");

        while (true) {
            String nextLine = s.nextLine().trim();
            if (nextLine.length() == 0) {
                break;
            } else {
                elems.add(nextLine);
            }
        }
        return elems;
    }

    private void L()
    {
        ArrayList<String> startElements = GetElements();
        MyLinkedList theList = new MyLinkedList();
        for (String startElement : startElements) {
            theList.AppendItem(startElement);
        }

        while (true) {
            int choice = GetChoice(new String[]{
                    "Quit",
                    "Count items in the list",
                    "Print the list",
                    "Add another string to the start of the list",
                    "Add another string to the end of the list",
                    "Delete the first thing in the list",
                    "Delete the last thing in the list",
                    "Bubble sort the list",
                    "Merge sort the list",
                    "Insertion sort the list"
            });
            if (choice == 1) {
                break;
            } else if (choice == 2) {
                System.out.println(String.format("There are %d items in the list", theList.CountItems()));
            } else if (choice == 3) {
                System.out.println();
                theList.PrintAll();
                System.out.println();
            } else if (choice == 4) {
                System.out.println("Enter new item");
                theList.PrependItem(s.nextLine().trim());
            } else if (choice == 5) {
                System.out.println("Enter new item");
                theList.AppendItem(s.nextLine().trim());
            } else if (choice == 6) {
                theList.DeleteItem(0);
            } else if (choice == 7) {
                theList.DeleteItem(theList.CountItems() - 1);
            } else if (choice == 8) {
                long startTime = System.nanoTime();
                theList.BubbleSort(true);
                long endTime = System.nanoTime();
                System.out.println("Done! Took " + (endTime - startTime) + " nanoseconds");
            } else if (choice == 9) {
                long startTime = System.nanoTime();
                theList.BubbleSort(false);
                long endTime = System.nanoTime();
                System.out.println("Done! Took " + (endTime - startTime) + " nanoseconds");
            } else if (choice == 10) {
                long startTime = System.nanoTime();
                theList = theList.MergeSort(theList);
                long endTime = System.nanoTime();
                System.out.println("Done! Took " + (endTime - startTime) + " nanoseconds");
            } else if (choice == 11) {
                long startTime = System.nanoTime();
                theList.InsertionSort();
                long endTime = System.nanoTime();
                System.out.println("Done! Took " + (endTime - startTime) + " nanoseconds");
            }
        }
    }

    private void S()
    {
        ArrayList<String> startElements = GetElements();
        MyStack theList = new MyStack();
        for (String startElement : startElements) {
            theList.AppendItem(startElement);
        }

        while (true) {
            int choice = GetChoice(new String[]{
                    "Quit",
                    "Count items in the list",
                    "Print the list",
                    "Push",
                    "Pop"
            });
            if (choice == 1) {
                break;
            } else if (choice == 2) {
                System.out.println(String.format("There are %d items in the list", theList.CountItems()));
            } else if (choice == 3) {
                System.out.println();
                theList.PrintAll();
                System.out.println();
            } else if (choice == 4) {
                System.out.println("Enter a new element to push:");
                theList.Push(s.nextLine().trim());
            } else if (choice == 5) {
                System.out.println("Element popped: " + theList.Pop());
            }
        }

    }

    private void Q()
    {
        ArrayList<String> startElements = GetElements();
        MyQueue theList = new MyQueue();
        for (String startElement : startElements) {
            theList.Append(startElement);
        }

        while (true) {
            int choice = GetChoice(new String[]{
                    "Quit",
                    "Count items in the list",
                    "Print the list",
                    "Append",
                    "Pop"
            });
            if (choice == 1) {
                break;
            } else if (choice == 2) {
                System.out.println(String.format("There are %d items in the list", theList.CountItems()));
            } else if (choice == 3) {
                System.out.println();
                theList.PrintAll();
                System.out.println();
            } else if (choice == 4) {
                System.out.println("Enter a new element to append:");
                theList.Append(s.nextLine().trim());
            } else if (choice == 5) {
                System.out.println("Element popped: " + theList.Pop());
            }
        }

    }

    private void PQ()
    {
        System.out.println("All elements added as non-priority");
        ArrayList<String> startElements = GetElements();
        MyPriorityQueue theList = new MyPriorityQueue();
        for (String startElement : startElements) {
            theList.Append(startElement, false);
        }

        while (true) {
            int choice = GetChoice(new String[]{
                    "Quit",
                    "Count items in the list",
                    "Print the list",
                    "Append",
                    "Pop",
                    "Bubble sort",
                    "Bubble sort backwards",
                    "Merge sort",
                    "Insertion sort"
            });
            if (choice == 1) {
                break;
            } else if (choice == 2) {
                System.out.println(String.format("There are %d items in the list", theList.CountItems()));
            } else if (choice == 3) {
                System.out.println();
                theList.PrintAll();
                System.out.println();
            } else if (choice == 4) {
                System.out.println("Enter a new element to append:");
                String elem = s.nextLine().trim();
                System.out.println("Priority? T for true, F for false");
                theList.Append(elem, s.nextLine().trim().toLowerCase().equals("t"));
            } else if (choice == 5) {
                System.out.println("Element popped: " + theList.Pop());
            } else if (choice == 6) {
                long startTime = System.nanoTime();
                theList.BubbleSort(true);
                long endTime = System.nanoTime();
                System.out.println("Done! Took " + (endTime - startTime) + " nanoseconds");
            } else if (choice == 7) {
                long startTime = System.nanoTime();
                theList.BubbleSort(false);
                long endTime = System.nanoTime();
                System.out.println("Done! Took " + (endTime - startTime) + " nanoseconds");
            } else if (choice == 8) {
                long startTime = System.nanoTime();
                theList.MergeSort();
                long endTime = System.nanoTime();
                System.out.println("Done! Took " + (endTime - startTime) + " nanoseconds");
            } else if (choice == 9) {
                long startTime = System.nanoTime();
                theList.InsertionSort();
                long endTime = System.nanoTime();
                System.out.println("Done! Took " + (endTime - startTime) + " nanoseconds");
            }
        }
    }

    private void CQ()
    {
        ArrayList<String> startElements = GetElements();
        MyCircularQueue theList = new MyCircularQueue();
        for (String startElement : startElements) {
            theList.Append(startElement);
        }

        while (true) {
            int choice = GetChoice(new String[]{
                    "Quit",
                    "Count items in the list",
                    "Print the list",
                    "Append",
                    "Prepend",
                    "Pop",
                    "Pop from end",
                    "Stats"
            });
            if (choice == 1) {
                break;
            } else if (choice == 2) {
                System.out.println(String.format("There are %d items in the list", theList.CountItems()));
            } else if (choice == 3) {
                System.out.println();
                theList.PrintAll();
                System.out.println();
            } else if (choice == 4) {
                System.out.println("Enter a new element to append:");
                theList.Append(s.nextLine().trim());
            } else if (choice == 5) {
                System.out.println("Enter a new element to prepend:");
                theList.Prepend(s.nextLine().trim());
            } else if (choice == 6) {
                System.out.println("Element popped: " + theList.Pop());
            } else if (choice == 7) {
                System.out.println("Element popped from the end: " + theList.PopEnd());
            } else if (choice == 8) {
                theList.Stats();
            }
        }
    }
}
