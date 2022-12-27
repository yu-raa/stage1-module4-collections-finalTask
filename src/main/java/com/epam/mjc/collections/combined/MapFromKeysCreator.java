package com.epam.mjc.collections.combined;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        Map<Integer, Set<String>> reverse = new HashMap<>();
        for (String value : sourceMap.keySet()) {
            if (reverse.containsKey(value.length())) {
                Set<String> newSet = new TreeSet<>(reverse.get(value.length()));
                newSet.add(value);
                reverse.replace(value.length(), newSet);
            }
            else {
                reverse.put(value.length(), Set.of(value));
            }
        }

        return reverse;
    }
}
