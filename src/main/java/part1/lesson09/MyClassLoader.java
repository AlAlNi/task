package part1.lesson09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (Main.getClassName().equals(name)) {
            try {
                byte[] bites = Files.readAllBytes(Paths.get("src/part1.lesson13.SomeClass.class"));
                return defineClass(name, bites, 0, bites.length);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return super.findClass(name);
    }
}
