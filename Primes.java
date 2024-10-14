import java.util.*;
import java.io.*;
import java.lang.Math;


// This program generates a list of prime numbers up to a user-specified upper limit, and writes the list to a CSV file.
public class Primes { 
    public static void main(String[] args) { 
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the upper limit: ");
        int upperLimit = console.nextInt();
        console.close(); 
        List<Integer> primes = new ArrayList<Integer>(); // List to store primes
        for (int i = 2; i <= upperLimit; i++) { // Check each number from 2 to upperLimit
            if (isPrime(i)) { // If the number is prime, add it to the list
                primes.add(i); 
            }
        }
        System.out.println("Primes: " + primes);
        
        // Write primes to CSV file
        writePrimesToCSV(primes, "primes.csv"); 
        double runtime = System.currentTimeMillis(); 
        System.out.println("Runtime: " + runtime/1000 + "s");
    }

    public static boolean isPrime(int n) {
        if (n <= 1) { 
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void writePrimesToCSV(List<Integer> primes, String fileName) { 
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            int index = 1;
            writer.println("Number of Primes" + "," + "Prime" + "," + "Natural Logarithm of Prime" + "," + "Natural Logarithm of Natural Logarithm of Prime" + "," + "e^prime"); // Header 
            for (Integer prime : primes) {  // Write each prime to the file
                writer.println(index + "," + prime + "," + Math.log(prime) + "," + Math.log(Math.log(prime)) + "," + Math.exp(prime));  
                index++; 
            } 
            System.out.println("Primes have been written to " + fileName); 
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } 
    }
}