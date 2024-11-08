package org.behappy.algo.structure.test;

import org.behappy.algo.structure.SuffixTree;
import org.behappy.algo.structure.test.common.SuffixTreeTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SuffixTreeTests {

    @Test
    public void testSuffixTree() {
        String bookkeeper = "bookkeeper";
        SuffixTree<String> tree = new SuffixTree<String>(bookkeeper);
        assertTrue(SuffixTreeTest.suffixTreeTest(tree, bookkeeper));
    }
}
