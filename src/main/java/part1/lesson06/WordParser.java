package part1.lesson06;

import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * Класс для обработки файла и сохранения всех уникальных слов в алфавитном порядке в другом файле.
 */
public class WordParser {
    private File file; //файл оригинал, с которого будем проводить чтение.
    private Set<String> wordSet = new TreeSet<>();
    private File resultFile; //файл по умолчанию, куда будет сохраняться результат. инициализируется в конструкторе.


    /**
     * Конструктор - инициализатор файла, из которого будем считывать все слова, путем ввода имени файла с консоли.
     */
    public WordParser() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            this.file = new File(reader.readLine());
            resultFile = new File(file + "_parsed");
        } catch (IOException e) {
            System.out.println("read file error " + e.getMessage());

        }
    }

    /**
     * Конструктор - инициализатор файла, из которого будем считывать все слова, путем явного указания пути к файлу.
     *
     * @param file - путь к файлу, с которого будем считывать слова
     */
    public WordParser(String file) {
        this.file = new File(file);
    }

    /**
     * Метод проходит по инициализированному файлу и сохраняет все слова в TreeSet в нижнем регистре
     *
     * @throws IOException
     */
    public void parseFile() throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            Matcher matcher = Pattern.compile("[a-zA-Zа-яА-Я]+").matcher(fileReader.lines().collect(Collectors.joining(System.lineSeparator())));
            while (matcher.find()) {
                wordSet.add(matcher.group().toLowerCase()); //регистр в нашей программе не учитывается, поэтому все слова будем хранить в нижнем регистре
            }
        }
    }

    /**
     * Метод сохранения списка слов {@link WordParser#wordSet} в файл
     *
     * @param resultFile - файл для записи списка слов.
     * @throws IOException
     */
    private void save(File resultFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
            writer.write(wordSet.stream().collect(Collectors.joining(System.lineSeparator())));
        }
    }

    /**
     * Получение массива слов не длиннее указанного размера
     * (метод используется во второй части задания)
     *
     * @param maxLength - максимально допустимая длина слова в массиве
     * @return возвращает массив слов, отфильтрованный по заданной длине
     */
    public List<String> getWords(int maxLength) {
        return  wordSet.stream().filter(w->w.length()<=maxLength).collect(Collectors.toList());
    }

    /**
     * Сохраняет все отпарсенные слова в файл по умолчанию
     *
     * @throws IOException
     */
    public void saveParsed() throws IOException {
        save(resultFile);
    }

    /**
     * Сохраняет все отпарсенные слова в указанный файл.
     *
     * @param resultFile файл, в который сохранить все слова.
     * @throws IOException
     */
    public void saveParsed(String resultFile) throws IOException {
        save(new File(resultFile));
    }
}
