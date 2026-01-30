import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.*;

public class NumbersBenasO implements Exercises {
    @Override
    public Integer findSmallest(List<Integer> list) {
        return list.stream().min(Comparator.comparing(i -> i)).orElse(0);
    }

    @Override
    public Integer findLargest(List<Integer> list) {
        return list.stream().max(Comparator.comparing(i -> i)).orElse(0);
    }

    @Override
    public boolean isEqual(Object o, Object o1) {
        return o.equals(o1);
    }

    @Override
    public boolean isSameObject(Object o, Object o1) {
        return true;
    }

    @Override
    public List<Integer> consume(Iterator<Integer> iterator) {
        return List.of();
    }

    @Override
    public int computeSumOfNumbers(int i) {
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            sum += j;
        }
        return sum;
    }

    @Override
    public int computeSumOfNumbers(int i, NumberFilter numberFilter) {
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            if (numberFilter.accept(j)) {
                sum += j;
            }
        }
        return sum;
    }

    @Override
    public List<Integer> computeNumbersUpTo(int i) {
        List<Integer> result = new ArrayList<>();
        for (int j = 1; j < i; j++) {
            result.add(j);
        }
        return result;
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {
//        HashMap ocurances = new HashMap<>();
//        list.stream().
        return null;
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int i, int i1) {
        return null;
    }

    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        return null;
    }
}
