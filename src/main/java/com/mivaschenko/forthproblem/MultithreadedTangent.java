package com.mivaschenko.forthproblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.*;

public class MultithreadedTangent {
    final ArrayList<Double> array = new ArrayList<>();

    public MultithreadedTangent(String input) throws FileNotFoundException {
        Scanner numFile = new Scanner(new File(input));
        Scanner sc = new Scanner(numFile.nextLine());
        sc.useDelimiter(" ");
        while(sc.hasNextDouble()) {
            this.array.add(sc.nextDouble());
        }
        sc.close();
        numFile.close();
    }

    public String calculate(int upperBound) throws  ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        StringBuilder buffer = new StringBuilder();
        buffer.append(Math.min(upperBound, array.size())).append(" numbers were processed\n");
        for (int i=0; (i<array.size())&&(i<upperBound); i++) {
            Double element = array.get(i);
            final Future<Double> future = executor.submit(() -> Math.tan(element));
            buffer.append("val = ").append(element.toString())
                    .append("; tan(val) = ").append(future.get().toString()).append("\n");
        }
        executor.shutdown();
        return buffer.toString();
    }
}
