package lab3;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== ЗАДАНИЕ 1: Собственная реализация HashTable ===\n");
        
        HashTable<String, Integer> customHashTable = new HashTable<>();
        
        customHashTable.put("apple", 5);
        customHashTable.put("banana", 3);
        customHashTable.put("orange", 7);
        
        System.out.println("Размер таблицы: " + customHashTable.size());
        System.out.println("Значение для 'apple': " + customHashTable.get("apple"));
        System.out.println("Значение для 'banana': " + customHashTable.get("banana"));
        
        customHashTable.remove("banana");
        System.out.println("После удаления 'banana', размер: " + customHashTable.size());
        System.out.println("Таблица пуста? " + customHashTable.isEmpty());
        
        System.out.println("\n=== ЗАДАНИЕ 2: Система управления заказами ресторана ===\n");
        
        RestaurantOrderSystem restaurant = new RestaurantOrderSystem();
        
        List<Dish> dishes1 = Arrays.asList(
            new Dish("Борщ", 350.0),
            new Dish("Котлета по-киевски", 450.0),
            new Dish("Компот", 100.0)
        );
        Order order1 = new Order(dishes1, "12:30");
        
        List<Dish> dishes2 = Arrays.asList(
            new Dish("Салат Цезарь", 420.0),
            new Dish("Стейк", 890.0),
            new Dish("Сок апельсиновый", 150.0)
        );
        Order order2 = new Order(dishes2, "13:15");
        
        List<Dish> dishes3 = Arrays.asList(
            new Dish("Суп-лапша", 280.0),
            new Dish("Пельмени", 320.0),
            new Dish("Чай", 80.0)
        );
        Order order3 = new Order(dishes3, "14:00");
        
        restaurant.addOrder(5, order1);
        restaurant.addOrder(12, order2);
        restaurant.addOrder(7, order3);
        
        System.out.println("\nКоличество активных заказов: " + restaurant.getOrderCount());
        
        restaurant.findOrder(12);
        restaurant.findOrder(99);
        
        restaurant.displayAllOrders();
        
        System.out.println("\nОбщая выручка: " + 
            String.format("%.2f", restaurant.getTotalRevenue()) + " руб.");
        
        System.out.println();
        restaurant.removeOrder(5);
        
        System.out.println("\nПосле удаления заказа:");
        System.out.println("Количество активных заказов: " + restaurant.getOrderCount());
        System.out.println("Общая выручка: " + 
            String.format("%.2f", restaurant.getTotalRevenue()) + " руб.");
        
        System.out.println("\n=== Демонстрация equals() и hashCode() ===\n");
        
        List<Dish> testDishes = Arrays.asList(new Dish("Тест", 100.0));
        Order testOrder1 = new Order(testDishes, "10:00");
        Order testOrder2 = new Order(testDishes, "10:00");
        Order testOrder3 = testOrder1;
        
        System.out.println("testOrder1.equals(testOrder2): " + testOrder1.equals(testOrder2));
        System.out.println("testOrder1.equals(testOrder3): " + testOrder1.equals(testOrder3));
        System.out.println("testOrder1.hashCode(): " + testOrder1.hashCode());
        System.out.println("testOrder2.hashCode(): " + testOrder2.hashCode());
        System.out.println("Хэш-коды равны: " + (testOrder1.hashCode() == testOrder2.hashCode()));
    }
}
