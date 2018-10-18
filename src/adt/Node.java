package adt;

import juego.Dragon;

public class Node {
    Dragon key;
    int height;
    Node left, right;

    Node(Dragon d)
    {
        key = d;
        height = 1;
    }
}
