package part1.lesson12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Select" +
                    "\n1. OutOfMemoryError in Heap" +
                    "\n2. OutOfMemoryError in Metaspace");
            if (Integer.parseInt(reader.readLine()) == 1) {
                OutOfMemoryError.heapError();
            }
            else {
                OutOfMemoryError.metaspaceError();
            }
        }
        catch (java.lang.OutOfMemoryError e) {
            System.err.println("OutOfMemoryError: " + e.getMessage());
        }
        catch (NumberFormatException | IOException e) {
            System.err.println("Неверный выбор " + e.getMessage());
        }
    }
}
