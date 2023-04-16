package com;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> fibonacci(n));

        System.out.println("Waiting for calculation to complete...");
        try {
            future.get(); // wait for the calculation to complete
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        try {
            int result = future.get();
            System.out.println("Fibonacci(" + n + ") = " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

