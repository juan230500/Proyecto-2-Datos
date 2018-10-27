package adt;

import juego.Dragon;

public class Node {
    public Dragon key;
    int height;
    public Node left, right;

    public Node(Dragon d)
    {
        key = d;
        height = 1;
    }
}
