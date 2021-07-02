package part1.lesson08.serialize;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;

public class SerializeObject {
    /**
     * Проверяем является ли объект простым типом
     * @param retType - проверяемый объект
     * @return - true, если простой тип
     */
    private static boolean isValidType(Class<?> retType)
    {
        if (retType.isPrimitive() && retType != void.class) return true;
        if (Number.class.isAssignableFrom(retType)) return true;
        if (Boolean.class == retType) return true;
        if (Character.class == retType) return true;
        if (String.class == retType) return true;
        if (Date.class.isAssignableFrom(retType)) return true;
        if (byte[].class.isAssignableFrom(retType)) return true;
        if (Enum.class.isAssignableFrom(retType)) return true;
        return false;
    }

    /**
     * создаём строку с полями объекта, добавляя в начало строки название класса и обрамляя всё тегами. Если объект содержит ссылку на другой объект, рекурсивно кодируем и его.
     * @param object - передаваемый объект
     * @return - итоговая строка
     */
    private static String fieldsToString(Object object) {
        StringBuilder dataObject = new StringBuilder();
        dataObject.append("<object!").append(object.getClass().getName());
        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (isValidType(field.getType())) {
                    dataObject.append("{").append(field.getName()).append(":")
                            .append(field.getType().getSimpleName()).append(":").append(field.get(object)).append("}");
                }
                else {
                    dataObject.append("{").append(field.getName()).append(":").append(field.getType()
                            .getSimpleName()).append(":").append(fieldsToString(field.get(object))).append("}");
                }

            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        dataObject.append(">");

        return String.valueOf(dataObject);
    }

    /**
     * сохраняем строку с данными в файл
     * @param object - передаваемый объект
     * @param fileName - имя файла
     * filePath - путь к папке с программой
     */
    public static void serialize(Object object, String fileName) {

        String dataString = fieldsToString(object);

        String filePath = "./src/part1/lesson08/";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + fileName))) {
            writer.write(dataString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
