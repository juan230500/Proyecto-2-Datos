package adt;

import juego.Dragon;

public class Node {
    Dragon key;
    int height;
    Node left, right;

    public Node(Dragon d)
    {
        key = d;
        height = 1;
    }
}
