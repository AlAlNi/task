package part1.lesson09;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

class Loader {
    private final String name;
    private StringBuilder builder;

    Loader(String name) {
        builder = new StringBuilder();
        this.name = name;
    }

    void loading() {
        String code = buildMethodImpl();
        javac(code);
    }

    private void javac(String code) {
        try {
            Files.write(Paths.get(getPath()), code.getBytes());
            JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
            String[] javacOpts = {getPath()};
            javac.run(null, null, null, javacOpts);
        } catch (IOException e) {
            System.out.println("Ошибка компиляции " + e);
        }
    }

    private String getPath() {
        return "./" + name + ".java";
    }

    private String buildMethodImpl() {
        builder.append(workerImpl());
        enterCode();
        builder.append("\n}\n}");
        System.out.println("loading...");
        return builder.toString();
    }

    private void enterCode() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("введите код...\nнажмите Enter");
            String line;
            while (!"".equals(line = reader.readLine())) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String workerImpl() {
        return
                "import part1.lesson09.Worker;\n" +
                        "public class SomeClass implements Worker {\n" +
                        "public void doWork(){\n";
    }
}
