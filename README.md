> **Note: Language Context**
>
> Please note that this project was written in **German** as part of my `Ausbildung` (German vocational training). Therefore, all variable names, comments, and package names are in German.

---

# Custom Doubly Linked List & Queue (From Scratch)

## About This Project

This is one of my most advanced "Computer Science Fundamentals" projects. It's a complete, from-scratch implementation of two foundational data structures: a **Doubly Linked List** and a **Queue**.

The goal was not to simply use Java's built-in `ArrayList` or `Queue`, but to build them from the ground up to understand their internal logic, pointer management, and performance.

## Key Features

### 1. `DoublyLinkedList<E>` (From Scratch)
A fully generic doubly linked list implementation.
* **Full Pointer Management:** Correctly manages `head`, `tail`, `next`, and `previous` references for all operations.
* **Edge Case Handling:** All methods (especially `addIndex` and `remove`) are designed to correctly handle edge cases like an empty list, removing the `head`, or removing the `tail`.
* **Algorithmic Optimization:** The `getNode(index)` method is optimized. It uses a "bi-directional search" (O(n/2)) by checking if the index is in the first or second half of the list (`index < size / 2`) and searching from the `head` or `tail` accordingly.

### 2. `Queue<E>` (Built via Composition)
A complete, generic Queue (FIFO - First-In, First-Out) data structure.
* **Clean Architecture:** This `Queue` is a perfect example of "Composition". It is built *on top of* the `DoublyLinkedList` by using it internally, rather than inheriting from it.
* Provides standard methods: `enqueue()`, `dequeue()`, `peek()`, `size()`, `isEmpty()`.

### 3. JUnit 5 Tested
The `Queue` class is validated by a full `QueueTest.java` unit test suite. These tests verify:
* Correct FIFO ("First-In, First-Out") behavior.
* Correct size management after `enqueue` and `dequeue`.
* Correct exception handling (e.g., `dequeue()` on an empty list).
* Graceful handling of `peek()` on an empty
