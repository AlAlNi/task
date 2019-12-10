package part1.lesson08;

import com.sun.org.apache.xml.internal.serialize.DOMSerializer;

import part1.lesson08.objects.SObject;
import part1.lesson08.objects.YourFather;
import part1.lesson08.serialize.SInObject;
import part1.lesson08.serialize.SOutObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MainMenu {

    static  void showMenu() {

        System.out.println("Select serialize method:" +
                "\n1. Simple object only" +
                "\n2. General" +
                "\n0. Exit");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int select;
            while ((select = Integer.parseInt(reader.readLine())) != 0){
                if(select == 1) {
                    SObject oneObject = new SObject("Нечто", 20489, true);
                    SOutObject.serialize(oneObject, "SomeObject.dat");
                    SInObject test = new SInObject();
                    Object newObject = test.deSerialize("SomeObject.dat");
                    System.out.println("Объекты одинаковы: " + oneObject.toString().equals(newObject.toString()));
                }
                else {
                    SObject oneObject = new SObject("Нечто", 14892, true);
                    YourFather father = new YourFather("Михаил", 57, false, oneObject);
                    SOutObject.serialize(father, "SomeObject.dat");

                    SInObject test = new SInObject();
                    Object newFather = test.deSerialize("SomeObject.dat");
                    System.out.println("Объекты одинаковы: " + father.toString().equals(newFather.toString()));

                }

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
