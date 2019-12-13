package part1.lesson08;

import part1.lesson08.objects.Son;
import part1.lesson08.objects.Father;
import part1.lesson08.serialize.DeSerializeObject;
import part1.lesson08.serialize.SerializeObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MainMenu {
    static void showMenu() {
        System.out.println("Select serialize method:" +
                "\n1. Simple object only" +
                "\n2. General" +
                "\n0. Exit");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int select;
            while ((select = Integer.parseInt(reader.readLine())) != 0) {
                if (select == 1) {
                    Son oneObject = new Son("Нечто", 20489, true);
                    SerializeObject.serialize(oneObject, "SomeObject.dat");
                    DeSerializeObject test = new DeSerializeObject();
                    Object newObject = test.deSerialize("SomeObject.dat");
                    System.out.println("Objects are the same: " + oneObject.toString().equals(newObject.toString()));
                }
                if (select == 2) {
                    Son oneObject = new Son("Нечто", 14892, true);
                    Father father = new Father("Михаил", 57, false, oneObject);
                    SerializeObject.serialize(father, "SomeObject.dat");
                    DeSerializeObject test = new DeSerializeObject();
                    Object newFather = test.deSerialize("SomeObject.dat");
                    System.out.println("Objects are the same: " + father.toString().equals(newFather.toString()));
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Exit");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
