package org.behappy.algo.structure.test;

import org.behappy.algo.structure.Queue;
import org.behappy.algo.structure.test.common.JavaCollectionTest;
import org.behappy.algo.structure.test.common.QueueTest;
import org.behappy.algo.structure.test.common.Utils;
import org.behappy.algo.structure.test.common.Utils.TestData;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.assertTrue;

public class QueueTests {

    @Test
    public void testArrayQueue() {
        TestData data = Utils.generateTestData(2500);

        String aName = "Queue [array]";
        Queue.ArrayQueue<Integer> aQueue = new Queue.ArrayQueue<Integer>();
        Collection<Integer> aCollection = aQueue.toCollection();

        assertTrue(QueueTest.testQueue(aQueue, aName,
                data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(aCollection, Integer.class, aName,
                data.unsorted, data.sorted, data.invalid));

        // Specific test based on bug
        aQueue = new Queue.ArrayQueue<Integer>();
        for (int i = 0; i < 1024; i++) {
            aQueue.offer(i);
        }
        aQueue.poll();
        aQueue.offer(1024);
        Iterator it = aQueue.toQueue().iterator();
        while (it.hasNext())
            it.next();
    }

    @Test
    public void testLinkedQueue() {
        TestData data = Utils.generateTestData(250);

        String lName = "Queue [linked]";
        Queue.LinkedQueue<Integer> lQueue = new Queue.LinkedQueue<Integer>();
        Collection<Integer> lCollection = lQueue.toCollection();

        assertTrue(QueueTest.testQueue(lQueue, lName,
                data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(lCollection, Integer.class, lName,
                data.unsorted, data.sorted, data.invalid));

        lQueue = new Queue.LinkedQueue<Integer>();
        for (int i = 0; i < 1024; i++) {
            lQueue.offer(i);
        }
        lQueue.poll();
        lQueue.offer(1024);
        Iterator it = lQueue.toQueue().iterator();
        while (it.hasNext())
            it.next();
    }
}
