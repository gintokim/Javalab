import java.io.*;
import java.util.HashSet;

public class FileProcessor {

    public static void main(String[] args) {
        String inputFilePath = "input.txt"; // Путь к входному файлу
        String outputFilePath = "output.txt"; // Путь к выходному файлу
        String compressedFilePath = "compressed.txt"; // Путь к сжатому файлу
        String decompressedFilePath = "decompressed.txt"; // Путь к восстановленному файлу

        // Удаление дублирующихся строк
        removeDuplicates(inputFilePath, outputFilePath);

        // Создание сжатой версии
        createCompressedFile(outputFilePath, compressedFilePath);

        // Восстановление сжатой версии
        decompress(compressedFilePath, decompressedFilePath);
    }

    // Метод для удаления дублирующихся строк
    public static void removeDuplicates(String inputFilePath, String outputFilePath) {
        HashSet<String> uniqueLines = new HashSet<>();
        int duplicateCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (uniqueLines.add(line)) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    duplicateCount++;
                }
            }

            // Запись количества удаленных дубликатов в выходной файл
            writer.write("Количество удаленных дублирующихся строк: " + duplicateCount);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для создания сжатой версии файла
    public static void createCompressedFile(String inputFilePath, String compressedFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(compressedFilePath))) {

            String line;
            HashSet<String> uniqueLines = new HashSet<>();
            while ((line = reader.readLine()) != null) {
                if (uniqueLines.add(line)) {
                    // Считаем количество повторений
                    int count = 1;
                    while ((line = reader.readLine()) != null && line.equals(uniqueLines.iterator().next())) {
                        count++;
                    }
                    writer.write(count + " " + uniqueLines.iterator().next());
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для восстановления сжатой версии
    public static void decompress(String compressedFilePath, String decompressedFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(compressedFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(decompressedFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                if (parts.length == 2) {
                    int count = Integer.parseInt(parts[0]);
                    String text = parts[1];

                    for (int i = 0; i < count; i++) {
                        writer.write(text);
                        writer.newLine();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

