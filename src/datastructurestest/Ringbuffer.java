package datastructurestest;

public class Ringbuffer {
    private Entry first;
    private final int size;



    public Ringbuffer(int size){
        if (size <= 0) throw new IllegalArgumentException();
        this.size = size;

        // initialize empty Buffer for size
        this.first = new Entry(null, null, null, 0);
        Entry start = first;
        for (int i = 1; i < size; i++){
            Entry newEntry = new Entry(null, null, start, i);
            start.next = newEntry;
            start = newEntry;
        }
        start.next = first;
        first.previous = start;
    }

    public void insert(String text){
        Entry insertEntry = first;
        insertEntry.element = text;
        first = first.next;
    }

    public void print(){
        Entry printEntry = first;
        for (int i = 0; i < size; i++){
            if (printEntry.element == null){
                System.out.println(printEntry.position + ": Kein Eintrag");
            } else{
                System.out.println(printEntry.position + ": " + printEntry.element);
            }
            printEntry = printEntry.next;
        }
    }

    private static class Entry{
        private String element;
        private Entry next;
        private Entry previous;
        private int position;

        private Entry(String element, Entry next, Entry previous, int position){
            this.element = element;
            this. next = next;
            this. previous = previous;
            this.position = position;
        }
    }

}