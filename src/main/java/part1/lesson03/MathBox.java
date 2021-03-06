//* Класс MathBox, реализующий следующий функционал:
//        *  ◦ Конструктор на вход получает массив Number. Элементы не могут повторяться. Элементы массива внутри объекта раскладываются в подходящую коллекцию (выбрать самостоятельно).
//        *  ◦ Существует метод summator, возвращающий сумму всех элементов коллекции.
//        *  ◦ Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель, являющийся аргументом метода. Хранящиеся в объекте данные полностью заменяются результатами деления.
//        *  ◦ Необходимо правильно переопределить методы toString, hashCode, equals, чтобы можно было использовать MathBox для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap). Выполнение контракта обязательно!
//        *  ◦ Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.

package part1.lesson03;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Объект, хранящий множество чисел Number. По умолчанию все числа приводятся к формату BigDecimal, как предположительный наивысший возможный вариант числа, содержащегося в массиве Number
 *
 * @author AlAlNi
 */
public class MathBox {
    private Set<BigDecimal> nums = new HashSet<>();
    private final Set<Class> classes;

    {
        /**
         * набор возможных классов, с которыми оперирует объект
         * возьмем в обработку только 8 основных типов данных, наследуемых от Number
         */
        classes = new HashSet<>(Arrays.asList(Long.class, Byte.class, Integer.class, Short.class, Double.class, Float.class, BigInteger.class, BigDecimal.class));
    }

    MathBox(Number[] nums) throws UnsupportedNumberTypeException {
        for (int i = 0; i < nums.length; i++) {
            if (!classes.contains(nums[i].getClass())) throw new UnsupportedNumberTypeException();
            this.nums.add(BigDecimal.valueOf(nums[i].doubleValue()));
        }
    }//...constructor

    /**
     * Метод возвращает сумму всех элементов коллекции. результат возврщает в заданном формате Number.
     *
     * @return
     */
    <T extends Number> T summator() {
        Optional<BigDecimal> n = nums.stream().reduce(BigDecimal::add);
        return (T) n.orElse(BigDecimal.valueOf(0));
    }


    /**
     * Выполняет поочередное деление всех хранящихся элементов в объекте на делитель
     *
     * @param divider делитель в любом формате Number.
     * @param <T>     тип делителя
     */
    <T extends Number> void splitter(T divider) {
        BigDecimal d = BigDecimal.valueOf(divider.doubleValue());
        nums = nums.stream().map(n -> n.divide(d)).collect(Collectors.toSet());
    }//...splitter

    /**
     * Удаляет элемент из коллекции, если он там есть.
     *
     * @param num значение удаляемого элемента
     * @return результат удаления
     */
    boolean remove(Integer num) {
        BigDecimal n = BigDecimal.valueOf((double) num);
        boolean removed = false;
        Iterator<BigDecimal> iter = nums.iterator();
        while (iter.hasNext()) {
            BigDecimal nextNum = iter.next();
            if (nextNum.equals(n)) {
                nums.remove(nextNum);
                removed = true;
                break;
            }
        }
        return removed;
    }

    boolean contains(BigDecimal n) {
        for (BigDecimal num : nums) if (n.equals(num)) return true;
        return false;
    }

    @Override
    public String toString() {
        return nums.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nums);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        MathBox nums2 = (MathBox) obj;
        for (BigDecimal n : nums) if (!nums2.contains(n)) return false;
        return super.equals(obj);
    }


}