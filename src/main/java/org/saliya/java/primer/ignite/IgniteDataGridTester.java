package org.saliya.java.primer.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

/**
 * Saliya Ekanayake on 2/24/17.
 */
public class IgniteDataGridTester {
    public static void main(String[] args) {
        try (Ignite ignite = Ignition.start()) {
            IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

            // Store keys in cache (values will end up on different cache nodes).
            for (int i = 0; i < 10; i++)
                cache.put(i, Integer.toString(i));

            for (int i = 0; i < 10; i++)
                System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
        }
    }
}
