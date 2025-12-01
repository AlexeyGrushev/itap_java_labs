package lab5;

import java.util.Scanner;
import java.util.regex.*;

/**
 * Задание 2. Проверка корректности ввода пароля
 * Пароль должен:
 * - Состоять из латинских букв и цифр
 * - Быть длиной от 8 до 16 символов
 * - Содержать хотя бы одну заглавную букву
 * - Содержать хотя бы одну цифру
 */
public class Task2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            // Демонстрация с примерами

            System.out.println("Введите пароль для проверки (или 'exit' для выхода):");

            while (true) {
                System.out.print("> ");
                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }

                boolean result = validatePassword(userInput);
                System.out.println("Password: " + userInput + " -> " + (result ? "Valid" : "Invalid"));
            }

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean validatePassword(String password) {
        try {
            Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])[0-9a-zA-Z]{8,16}$");
            return pattern.matcher(password).matches();
        } catch (Exception e) {
            System.err.println("Ошибка при проверке: " + e.getMessage());
            return false;
        }
    }
}
