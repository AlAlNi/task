//package part1.lesson05.task01;
//
//import java.io.*;
//import java.util.ArrayList;
//
//class Loading {
//    private ArrayList<AnimalInfo> animalInfoArrayList = new ArrayList<>();
//    private ArrayList<AnimalInfo> arrayListSearchFullMatch = new ArrayList<>();
//    private ArrayList<AnimalInfo> arrayListSearchByLetter = new ArrayList<>();
//    private ArrayList<AnimalInfo> arrayListSearchId = new ArrayList<>();
//    int sizeArrayList;
//
//    void unloadArrayList() throws IOException {
//        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("sizeArrayList.txt"))) {
//            sizeArrayList = (int) objectInputStream.readObject();
//        } catch (ClassNotFoundException | IOException e) {
//            e.printStackTrace();
//        }
//        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("animalCatalog.txt"))) {
//            for (int i = 0; i < sizeArrayList; i++) {
//                getAnimalInfoArrayList().add((AnimalInfo) objectInputStream.readObject());
//            }
//        } catch (ClassNotFoundException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    void addArrayList(AnimalInfo a1) {
//        getAnimalInfoArrayList().add(a1);
//        System.out.println(ItemsMenu.TEXT_DATA_ADD);
//        System.out.println(animalInfoArrayList.get(animalInfoArrayList.size() - 1));
//    }
//
//    void saveArrayList() {
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
//                new FileOutputStream("animalCatalog.txt"))) {
//            for (AnimalInfo animalInfo : getAnimalInfoArrayList()) {
//                objectOutputStream.writeObject(animalInfo);
//            }
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//    }
//
//    void saveSizeArrayList() {
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
//                new FileOutputStream("sizeArrayList.txt"))) {
//            objectOutputStream.writeObject(getAnimalInfoArrayList().size());
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//    }
//
//    ArrayList<AnimalInfo> getAnimalInfoArrayList() {
//        return animalInfoArrayList;
//    }
//
//    ArrayList<AnimalInfo> getArrayListSearchFullMatch() {
//        return arrayListSearchFullMatch;
//    }
//
//    ArrayList<AnimalInfo> getArrayListSearchByLetter() {
//        return arrayListSearchByLetter;
//    }
//    ArrayList<AnimalInfo> getArrayListSearchId() {
//        return arrayListSearchId;
//    }
//
//    public void setAnimalInfoArrayList(ArrayList<AnimalInfo> animalInfoArrayList) {
//        this.animalInfoArrayList = animalInfoArrayList;
//    }
//}
