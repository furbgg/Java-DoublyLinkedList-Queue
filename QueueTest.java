package musterrrs.SorterApp.doubleLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue<String> queue;

    @BeforeEach
    void setUp() {

        queue = new Queue();
    }

    @Test
    @DisplayName("Eine nue erstellte Queue sollte leer sein")
    void aNewQueueShouldBeEmpty() {
        assertTrue(queue.isEmpty(), "Eine neu erstellte Queue muss leer sein");
    }

    @Test
    @DisplayName("Nach dem hinzufugen eines Elements sollte die Queue nicht leer seinn")
    void sholdNotBeEmpty() {
        queue.enqueue("first item");
        assertFalse(queue.isEmpty(), "Nach dem Hinzufügen eines Elements darf die Queue nicht leer sein.");
    }

    @Test
    @DisplayName("Elemente sollten in ReihenFolge entfernt werden")
    void shouldRemoveTrue () {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals("A" , queue.dequeue() , "Das zuerst hinzufugte ELEment 'A' sollte zuerst entfernt werden");
        assertEquals("B" , queue.dequeue() , "Das zweite hinzugefugte Element 'B' sollte als Zweites entfernen werden");
        assertEquals("C",queue.dequeue(),"Das dritte hinzufugte Eleement 'C' sollte als Drittes entfernen werden ");
    }

    @Test
    @DisplayName("peek sollte das erste element zuruckgeben, ohne es zu entfernen")
    void peekShouldReturnFirstItemWithoutRemovingIt() {
        queue.enqueue("first");
        queue.enqueue("second");

        String peekedItem = queue.peek();

        assertEquals("first" , peekedItem , "peek() für erste element is FIRST");
        assertEquals(2,queue.size(), "nachdem peek() list ist nicht anders");
        assertEquals("first" , queue.peek() , "peek() für erste elemente wieder FIRST" );
    }

    @Test
    @DisplayName("Versuch, ein Element aus einer leeren Queue zu entfernen")
    void  emptyQueueShouldNoSuchElementExpection() {
        assertThrows(NoSuchElementException.class,() -> queue.dequeue());
    }
    @Test
    @DisplayName("Aufruf von peek() auf einer leeren Queue()")
    void emptyQueueShouldReturnNull () {
        String peekedItem = queue.peek();

        assertEquals(null,peekedItem,"peek() should return null");
    }

    @Test
    @DisplayName("Size() methode korrekt aktulalisiert")
    void queueGrosseJederSituationAktulisiasiert () {

        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(2,queue.size(),"Enqueue method korrekt aktulisariert");
        String removed = queue.dequeue();
        assertEquals("A" , removed, "First dequeue für A");
        assertEquals(1,queue.size(),"Nachdem dequeue grosse ist 1 ");

    }

@Test
    @DisplayName("Null hinzufügen in Queue")
    void nullShouldQueueNichtHinzufugen() {

        assertThrows(IllegalArgumentException.class, () -> {
            queue.enqueue(null);
        },"Wenn ein Null element hinzufugen probieren, muss ein Expection auslosen");

}


}