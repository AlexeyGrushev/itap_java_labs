package lab3;

import java.util.*;

/**
 * Система управления заказами ресторана с использованием HashMap
 */
public class RestaurantOrderSystem {
    private HashMap<Integer, Order> orders;
    
    public RestaurantOrderSystem() {
        orders = new HashMap<>();
    }
    
    /**
     * Добавляет заказ для столика
     */
    public void addOrder(int tableNumber, Order order) {
        orders.put(tableNumber, order);
        System.out.println("Заказ для столика №" + tableNumber + " добавлен.");
    }
    
    /**
     * Ищет заказ по номеру столика
     */
    public Order findOrder(int tableNumber) {
        Order order = orders.get(tableNumber);
        if (order != null) {
            System.out.println("\nНайден заказ для столика №" + tableNumber + ":");
            System.out.println(order);
        } else {
            System.out.println("Заказ для столика №" + tableNumber + " не найден.");
        }
        return order;
    }
    
    /**
     * Удаляет заказ по номеру столика
     */
    public void removeOrder(int tableNumber) {
        Order removed = orders.remove(tableNumber);
        if (removed != null) {
            System.out.println("Заказ для столика №" + tableNumber + " удален.");
        } else {
            System.out.println("Заказ для столика №" + tableNumber + " не найден.");
        }
    }
    
    /**
     * Выводит все активные заказы
     */
    public void displayAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("Нет активных заказов.");
            return;
        }
        System.out.println("\n=== Все активные заказы ===");
        for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
            System.out.println("\nСтолик №" + entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("------------------------");
        }
    }
    
    /**
     * Вычисляет общую выручку
     */
    public double getTotalRevenue() {
        double total = 0;
        for (Order order : orders.values()) {
            total += order.getTotalCost();
        }
        return total;
    }
    
    /**
     * Возвращает количество активных заказов
     */
    public int getOrderCount() {
        return orders.size();
    }
}
