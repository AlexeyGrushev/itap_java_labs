package lab4;

import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";
        
        // Создаем исходный файл для демонстрации
        createSourceFile(sourceFile);
        
        // Вариант 1: обработка ошибок открытия и закрытия файлов
        copyFileVariant1(sourceFile, destFile);
        
        // Вариант 2: обработка ошибок чтения и записи файлов
        copyFileVariant2(sourceFile, destFile + ".v2");
    }
    
    // Вариант 1: Обработка ошибок открытия и закрытия файлов
    public static void copyFileVariant1(String source, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try {
            System.out.println("\n=== Вариант 1: Обработка открытия/закрытия файлов ===");
            
            // Попытка открыть файлы
            fis = new FileInputStream(source);
            fos = new FileOutputStream(dest);
            
            int content;
            while ((content = fis.read()) != -1) {
                fos.write(content);
            }
            
            System.out.println("Файл успешно скопирован из " + source + " в " + dest);
            
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден!");
            System.out.println("Детали: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода при работе с файлом!");
            System.out.println("Детали: " + e.getMessage());
        } finally {
            // Закрытие файлов в блоке finally
            try {
                if (fis != null) {
                    fis.close();
                    System.out.println("Входной поток закрыт");
                }
                if (fos != null) {
                    fos.close();
                    System.out.println("Выходной поток закрыт");
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файлов!");
                System.out.println("Детали: " + e.getMessage());
            }
        }
    }
    
    // Вариант 2: Обработка ошибок чтения и записи файлов
    public static void copyFileVariant2(String source, String dest) {
        System.out.println("\n=== Вариант 2: Обработка чтения/записи файлов ===");
        
        // Используем try-with-resources для автоматического закрытия ресурсов
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            
            byte[] buffer = new byte[1024];
            int length;
            
            try {
                while ((length = fis.read(buffer)) > 0) {
                    try {
                        fos.write(buffer, 0, length);
                    } catch (IOException e) {
                        System.out.println("Ошибка при записи в файл!");
                        System.out.println("Детали: " + e.getMessage());
                        throw e; // Пробрасываем исключение дальше
                    }
                }
                System.out.println("Файл успешно скопирован из " + source + " в " + dest);
                
            } catch (IOException e) {
                System.out.println("Ошибка при чтении из файла!");
                System.out.println("Детали: " + e.getMessage());
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден!");
            System.out.println("Детали: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Общая ошибка ввода-вывода!");
            System.out.println("Детали: " + e.getMessage());
        }
    }
    
    // Вспомогательный метод для создания исходного файла
    private static void createSourceFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Это тестовое содержимое файла.\n");
            writer.write("Строка 2: Java Exception Handling.\n");
            writer.write("Строка 3: Лабораторная работа №4.\n");
            System.out.println("Исходный файл " + filename + " создан.");
        } catch (IOException e) {
            System.out.println("Ошибка при создании исходного файла: " + e.getMessage());
        }
    }
}