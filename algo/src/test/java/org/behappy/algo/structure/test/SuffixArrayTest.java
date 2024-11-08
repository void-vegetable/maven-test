package org.behappy.algo.structure.test;

import org.behappy.algo.structure.SuffixArray;
import org.behappy.algo.structure.SuffixTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class SuffixArrayTest {

    @Test
    public void testSuffixArray() {
        String string = "aasfaasdsadasdfasdasdasdasfdasfassdfas";

        SuffixArray suffixArrayBuilder = new SuffixArray(string);
        SuffixTree<String> suffixTree = new SuffixTree<String>(string);

        Set<String> suffixSet = suffixTree.getSuffixes();
        ArrayList<Integer> suffixArray = suffixArrayBuilder.getSuffixArray();

        int i = 0;
        for (String suffix : suffixSet) {
            String substring = string.substring(suffixArray.get(i++));
            assertTrue(suffix.equals(substring));
        }
    }

    @Test
    public void testKMRarray() {
        String string = "aasfaasdsadasdfasdasdasdasfdasfassdfas";

        SuffixArray suffixArrayBuilder = new SuffixArray(string);
        ArrayList<Integer> suffixArray = suffixArrayBuilder.getSuffixArray();
        ArrayList<Integer> KMRarray = suffixArrayBuilder.getKMRarray();

        int length = string.length();
        for (int i = 0; i < length; i++) {
            assertTrue(suffixArray.get(KMRarray.get(i)) == i);
        }
    }
}