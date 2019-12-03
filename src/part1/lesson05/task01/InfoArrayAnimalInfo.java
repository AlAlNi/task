package part1.lesson05.task01;

import part1.lesson05.task01.entity.AnimalInfo;

import java.io.*;
import java.util.ArrayList;

public class InfoArrayAnimalInfo  {
    int sizeArrayAnimalInfo;
    ArrayList<AnimalInfo> animalInfoArray = new ArrayList<>();

    int getSizeArrayAnimalInfo() throws IOException {
        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream("src/part1/lesson05/task01/files/sizeArrayList.txt"))) {
            sizeArrayAnimalInfo = (int) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Пустой католог");
        }
        return sizeArrayAnimalInfo;
    }

    void getArrayAnimalInfo() throws IOException {
        if (sizeArrayAnimalInfo > 0) {
            try (ObjectInputStream objectInputStream =
                         new ObjectInputStream(new FileInputStream("src/part1/lesson05/task01/files/animalCatalog.txt"))) {
                for (int i = 0; i < sizeArrayAnimalInfo; i++) {
                    animalInfoArray.add((AnimalInfo) objectInputStream.readObject());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    void saveArrayAnimalInfo() {
        System.out.println(animalInfoArray);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("src/part1/lesson05/task01/files/animalCatalog.txt"))) {
            for (AnimalInfo animalInfo : animalInfoArray) {
                objectOutputStream.writeObject(animalInfo);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    void saveSizeArrayList() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("src/part1/lesson05/task01/files/sizeArrayList.txt"))) {
            objectOutputStream.writeObject(animalInfoArray.size());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
