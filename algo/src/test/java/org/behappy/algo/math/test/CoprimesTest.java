package org.behappy.algo.math.test;

import org.behappy.algo.math.Coprimes;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoprimesTest {

    @Test
    public void totientTest() {
        final List<Long> args = Arrays.asList(1L, 17L, 96L, 498L, 4182119424L);
        final List<Long> expected = Arrays.asList(1L, 16L, 32L, 164L, 1194891264L);

        for (int i = 0; i < args.size(); i++)
            assertEquals(expected.get(i), Coprimes.getNumberOfCoprimes(args.get(i)));
    }
}
