package part1.lesson08.serialize;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeSerializeObject {
    /**
     * Из строки с данными оставляем только данные для восстановления объекта
     * @param dataString - переданная строка
     * @return - строка с данными класса
     */
    private String parseClass(String dataString) {
        String classString = null;
        if (dataString != null) {
            Pattern pattern = Pattern.compile("<.+>");
            Matcher matcher = pattern.matcher(dataString);
            while (matcher.find()) {
                classString = dataString.substring(matcher.start() + 1, matcher.end() - 1);
            }
        }
        return classString;
    }

    /**
     * Извлекаем из переданной строки имя класса, затем поля с данными. Передаём в метод createClass класс объекта и получаем обратно объект с пустыми полями.
     * Заполняем поля восстановленных объектов.
     * Создаём массив из ссылочных типов, если есть, рекурсивно заполняем их.
     * @param classString - строка с данными объекта
     * @return - объект с восстановленными полями
     */
    private Object parseFields(String classString) {
        ArrayList<String> objects = new ArrayList<>();
        String replaceableObject = "toReplaceThisObject";
        if (classString.contains("<") || classString.contains(">")) {
            Pattern pattern = Pattern.compile("<.+?>");
            Matcher matcher = pattern.matcher(classString);
            while(matcher.find()) {
                objects.add(classString.substring(matcher.start(), matcher.end()));
            }
            classString = classString.replaceAll("<.+?>", replaceableObject);
        }

        Pattern patternClass = Pattern.compile("^.+?\\{");
        Matcher matcherClass = patternClass.matcher(classString);
        String objectClass = null;
        while(matcherClass.find()) {
            objectClass = classString.substring(matcherClass.start() + 7, + matcherClass.end() - 1);
        }
        Object object = createObject(objectClass);

        String[] objectFields = null;
        Pattern patternField = Pattern.compile("\\{.+?\\}");
        Matcher matcherField = patternField.matcher(classString);
        while(matcherField.find()) {
            objectFields = classString.substring(matcherField.start() + 1, matcherField.end() - 1).split(":");
            if(objectFields[2].equals(replaceableObject)) {
                setField(object, objectFields[0], objectFields[1], parseFields(parseClass(objects.get(0))));
            }
            else {
                setField(object, objectFields[0], objectFields[1], objectFields[2]);
            }
        }
        return object;
    }

    /**
     * Создаём объект заданного класса с пустыми полями.
     * @param className - передавамое в метод имя класса
     * @return - созданный объект
     */
    private Object createObject(String className) {
        Object newObject = null;
        try {
            Class<?> newObj = Class.forName(className);
            newObject = newObj.getConstructor().newInstance();
        }
        catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return newObject;
    }

    /**
     * Заполняем поля созданных объектов.
     * Выводим ошибку, если нет доступа к полю.
     * @param object - передаваемый объект
     * @param fieldName - имя поля
     * @param fieldType - тип поля
     * @param fieldObject - значение поля
     */
    private void setField(Object object, String fieldName, String fieldType, Object fieldObject) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (field.getName().equals(fieldName)) {
                    setValue(object, field, fieldType, fieldObject);
                }
            } catch (IllegalAccessException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Читаем строку из файла и передаём в обработку.
     * Выводим ошибку, если файл не найден.
     * @param fileName - имя файла
     * @return - строка с даннными из файла
     * filePath - путь для чтения объекта из папки с программой
     */
    public Object deSerialize(String fileName) {
        String dataString = null;
        String filePath = "./src/part1/lesson08/";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath + fileName))) {
            dataString = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String parsedClass = parseClass(dataString);
        return parseFields(parsedClass);
    }

    /**
     * Приводим переданное значение поля к типу поля объекта
     * @param object - передаваемый объект
     * @param field - поле объекта
     * @param type - тип поля объекта
     * @param value - значение поля объекта
     * @throws IllegalAccessException - передаём в основной метод ошибку доступа к полю
     */
    private void setValue(Object object, Field field, String type, Object value) throws IllegalAccessException , NullPointerException {

        if (type.equals("int")) {
            field.setInt(object, Integer.parseInt(value.toString()));
        }
        else if(type.equals("boolean")) {
            field.setBoolean(object, Boolean.parseBoolean(value.toString()));
        }
        else if(type.equals("long")) {
            field.setLong(object, Long.parseLong(value.toString()));
        }
        else if(type.equals("double")) {
            field.setDouble(object, Double.parseDouble(value.toString()));
        }
        else if(type.equals("float")) {
            field.setFloat(object, Float.parseFloat(value.toString()));
        }
        else if(type.equals("byte")) {
            field.setByte(object, Byte.parseByte(value.toString()));
        }
        else if(type.equals("short")) {
            field.setShort(object, Short.parseShort(value.toString()));
        }
        else if(type.equals("String")) {
            field.set(object, value.toString());
        }
        else {
            field.set(object, value);
        }
    }
}