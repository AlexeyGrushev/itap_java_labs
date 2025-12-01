package lab5;

import java.util.regex.*;
import java.util.Scanner;

/*
Тестовые строки для проверки регулярного выражения:
"The price of the product is $19.99"
"В корзине 5 яблок, 3.5 кг апельсинов и 12 бананов"
"Температура: -15.7 градусов, влажность 80%"
"Цены: 100, 250.50, 1000.99 рублей"
"Нет чисел в этой строке!"
"123 0.456 -78"
*/

/**
 * Задание 1. Поиск всех чисел в тексте
 * Программа ищет все числа в заданном тексте и выводит их на экран.
 */
public class Task1 {
	public static void main(String[] args) {
		String text;
        System.out.println("Введите строку для проверки:");
		if (args.length > 0) {
			text = String.join(" ", args);
		} else {
			try (Scanner scanner = new Scanner(System.in)) {
				if (!scanner.hasNextLine()) {
					return;
				}
				text = scanner.nextLine();
			}
		}
		findNumbers(text);
	}

	private static void findNumbers(String text) {
		try {
			System.out.println("Текст: " + text);
			Pattern pattern = Pattern.compile("-?\\d+(?:\\.\\d+)?");
			Matcher matcher = pattern.matcher(text);

			boolean found = false;
			while (matcher.find()) {
				System.out.println(matcher.group());
				found = true;
			}
			if (!found) {
				System.out.println("Числа не найдены");
			}
		} catch (PatternSyntaxException e) {
			System.err.println("Неверное регулярное выражение: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Ошибка при обработке текста: " + e.getMessage());
		}
	}
}
