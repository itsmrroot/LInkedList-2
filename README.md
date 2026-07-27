# Singly Linked List — Java Practice Project

A simple implementation of a singly linked list in Java, built for learning and
practicing how linked lists work under the hood (no built-in `LinkedList` class used).

## Project Structure

```
com.company/
├── Node.java        # The building block of the list
├── LinkedList.java  # The list itself, with operations
└── Main.java        # Entry point / demo usage
```

## Node.java

Represents a single element in the list.

```java
public class Node {
    int data;   // the value stored in this node
    Node next;  // reference to the next node (null if it's the last one)
}
```

Each `Node` only knows about the node right after it — that's what makes it
*singly* linked (as opposed to a doubly linked list, where each node also
points backward).

## LinkedList.java

Holds a reference to the **head** (first node) and provides methods to
manipulate the list.

| Method | What it does |
|---|---|
| `append(Node newNode)` | Adds a node to the **end** of the list. Walks from `head` until it finds the last node, then attaches the new one. |
| `insert(Node newNode, int index)` | Inserts a node at a specific position. If `index == 0`, the new node becomes the head. Otherwise it walks to the node *before* the target index and re-links pointers around it. |
| `delete(int index)` | Removes the node at a given position and returns its `data`. If `index == 0`, the head is simply moved forward. Otherwise it re-links the previous node to skip over the deleted one. |
| `displayLinkedList()` | Walks the list from `head` to the end, printing each node's `data`. |
| `createLinkedList()` | A hardcoded example that manually builds a 3-node list (`11 → 18 → 24`) — useful for seeing the wiring explicitly, node by node. |

### How the operations actually work

- **Traversal**: since a node only knows the *next* node, the only way to reach
  node #5 is to start at `head` and follow `.next` five times. This is why
  `append`, `insert`, and `delete` all use loops like:
  ```java
  while (current.next != null) {
      current = current.next;
  }
  ```
- **Insert/Delete are just pointer surgery**: nothing is "shifted" in memory
  like an array. To insert a node in the middle, you just point the previous
  node at the new node, and point the new node at whatever the previous node
  used to point to.
- **Index 0 is special-cased**: inserting or deleting at the head means there
  is no "previous" node to update — you update `this.head` directly instead.

## Main.java — What the demo does, step by step

```java
LinkedList l1 = new LinkedList();
l1.createLinkedList();          // list: 11 → 18 → 24

l1.append(newNode1);            // append 22 → list: 11 → 18 → 24 → 22
l1.insert(newNode2, 0);         // insert 43 at index 0 → list: 43 → 11 → 18 → 24 → 22
l1.insert(newNode3, 2);         // insert 5 at index 2 → list: 43 → 11 → 5 → 18 → 24 → 22
l1.delete(2);                   // delete index 2 (removes 5) → list: 43 → 11 → 18 → 24 → 22

l1.displayLinkedList();
```

**Expected output:**
```
43
11
18
24
22
```

## Known Limitations (good things to notice while practicing)

- `append()` is **O(n)** — it has to walk the whole list every time because
  there's no `tail` pointer stored on the class. For a list you append to a
  lot, tracking a `tail` field (updated on every append/insert/delete) would
  make appends O(1).
- `insert()` and `delete()` don't check for out-of-bounds indexes beyond
  `current != null` — passing a huge index just silently does nothing rather
  than throwing an error.
- `delete()` will throw a `NullPointerException` if called on an empty list
  (`this.head.data` when `head` is `null`).
- `createLinkedList()` is hardcoded — a natural next exercise is to make it
  read values from user input in a loop until the user chooses to stop,
  rebuilding the list dynamically instead of hardcoding `11, 18, 24`.
