package musterrrs.SorterApp.doubleLinkedList;

import java.util.Arrays;

public class DoubleListApp{
public static void main(String[] args) {




    System.out.println("###DoublyLinkedList Test  ####");
    DoublyLinkedList<String> liste2 = new DoublyLinkedList<>();

    System.out.println("\n--- 1. Am Ende hinzufügen element ---");
    liste2.add("B");
    liste2.add("C");
    System.out.println("Erwartet: [B <-> C]");
    System.out.println("Ergebnis: " + liste2);
    System.out.println("Erwartete Size: 2, Ergebnis: " + liste2.size());


    System.out.println("\n### 2. Test: Index hinzufügen [add(index, element)] ###");
    System.out.println("\n'A' wird am Anfang (Index 0) hinzugefügt...");
    liste2.addIndex(0, "A");
    System.out.println("Erwartet: [A <-> B <-> C]");
    System.out.println("Ergebnis: " + liste2);

    System.out.println("\n'E' wird am Ende (Index 3) hinzugefügt...");
    liste2.addIndex(3, "E");
    System.out.println("Erwartet: [A <-> B <-> C <-> E]");
    System.out.println("Ergebnis: " + liste2);

    System.out.println("\n'D' wird in der Mitte (Index 3) hinzugefügt...");
    liste2.addIndex(3, "D");
    System.out.println("Erwartet: [A <-> B <-> C <-> D <-> E]");
    System.out.println("Ergebnis: " + liste2);
    System.out.println("Erwartete Größe: 5, Ergebnis: " + liste2.size());


    System.out.println("\n--- 3. Test: Auslesen [get] und umgekehrte Ausgabe [toStringReverse] ---");
    System.out.println("\nNormale Reihenfolge: " + liste2);
    System.out.println("Umgekehrte Reihenfolge: " + liste2.toStringReverse());
    System.out.println("\nElement am Index 3 (erwartet D): " + liste2.get(3));


    System.out.println("\n--- 4. Test: Entfernen [remove(index)] ---");

    System.out.println("\nEntferne aus der Mitte (Index 2, Wert 'C')...");
    String entfernterWert = liste2.remove(2);
    System.out.println("Entfernter Wert: " + entfernterWert);
    System.out.println("Erwartet: [A <-> B <-> D <-> E]");
    System.out.println("Ergebnis: " + liste2);
    System.out.println("Umgekehrte Reihenfolge: " + liste2.toStringReverse());

    System.out.println("\n### Test beendet ###");

    System.out.println("--- Test der IntQueue ---");
    Queue <Integer> nq = new Queue();

    System.out.println("\nFüge 10, 20, 30 hinzu...");
    nq.enqueue(10);
    nq.enqueue(20);
    nq.enqueue(30);
    System.out.println("Aktuelle Größe: " + nq.size());

    System.out.println("\nEntferne ein Element...");
    int erstesElement = nq.dequeue();
    System.out.println("Entferntes Element: " + erstesElement);
    System.out.println("Aktuelle Größe: " + nq.size());

    System.out.println("\nFüge 40, 50 hinzu...");
    nq.enqueue(40);
    nq.enqueue(50);

    System.out.println("Aktuelle Größe: " + nq.size());

    System.out.println("\nEntferne zwei Elemente...");
    Integer[] ersteZwei = nq.dequeue(2);

    System.out.println("Entfernte Elemente: " + Arrays.toString(ersteZwei));

    System.out.println("Aktuelle Größe: " + nq.size());
}
}