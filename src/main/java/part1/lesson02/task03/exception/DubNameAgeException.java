package part1.lesson02.task03.exception;

import part1.lesson02.task03.Person;

/**
 * Класс пользовательского исключения для выбрасывания при совпадении имени и возраста
 */
public class DubNameAgeException extends Exception {
    public DubNameAgeException(Person p1, Person p2) {
        super(String.format("Недопустимое равенство двух объектов. Объект {%s} равен {%s}.", p1, p2));
    }
}