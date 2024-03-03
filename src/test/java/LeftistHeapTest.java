import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class LeftistHeapTest {

    @Test
    public void testInsertAndDeleteMin() {
        LeftistHeap heap = new LeftistHeap();
        assertTrue(heap.isEmpty());

        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);

        assertFalse(heap.isEmpty());
        assertEquals(1, heap.findMin());

        assertEquals(1, heap.deleteMin());
        assertEquals(3, heap.deleteMin());
        assertEquals(5, heap.deleteMin());
        assertEquals(7, heap.deleteMin());
        assertEquals(10, heap.deleteMin());

        assertTrue(heap.isEmpty());
    }

    @Test
    public void testDeleteMinEmptyHeap() {
        LeftistHeap heap = new LeftistHeap();
        assertThrows(IllegalStateException.class, () -> heap.deleteMin());


    }

    @Test
    public void testFindMin() {
        LeftistHeap heap = new LeftistHeap();
        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);

        assertEquals(1, heap.findMin());
        heap.deleteMin();
        assertEquals(3, heap.findMin());
    }

    @Test
    public void testEmptyHeap() {
        LeftistHeap heap = new LeftistHeap();
        assertTrue(heap.isEmpty());
        assertThrows(IllegalStateException.class, () -> heap.findMin());
    }

    @Test
    public void testPrintHeap() {
        // Testing printHeap is difficult to automate due to its nature of outputting to console
        // Manual inspection is necessary
        LeftistHeap heap = new LeftistHeap();
        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);
        heap.printHeap();
    }
}

