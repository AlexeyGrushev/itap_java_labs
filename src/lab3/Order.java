package lab3;

import java.util.*;

/**
 * Класс Order для хранения информации о заказе
 */
public class Order {
    private List<Dish> dishes;
    private double totalCost;
    private String orderTime;
    
    public Order(List<Dish> dishes, String orderTime) {
        this.dishes = new ArrayList<>(dishes);
        this.orderTime = orderTime;
        calculateTotalCost();
    }
    
    private void calculateTotalCost() {
        totalCost = 0;
        for (Dish dish : dishes) {
            totalCost += dish.getPrice();
        }
    }
    
    public List<Dish> getDishes() {
        return new ArrayList<>(dishes);
    }
    
    public double getTotalCost() {
        return totalCost;
    }
    
    public String getOrderTime() {
        return orderTime;
    }
    
    public void addDish(Dish dish) {
        dishes.add(dish);
        calculateTotalCost();
    }
    
    public void removeDish(String dishName) {
        dishes.removeIf(dish -> dish.getName().equals(dishName));
        calculateTotalCost();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Order other = (Order) obj;
        return Double.compare(other.totalCost, totalCost) == 0
                && dishes.equals(other.dishes)
                && orderTime.equals(other.orderTime);
    }
    
    @Override
    public int hashCode() {
        int result = dishes.hashCode();
        result = 31 * result + Double.hashCode(totalCost);
        result = 31 * result + orderTime.hashCode();
        return result;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Заказ [Время: ").append(orderTime).append("]\n");
        sb.append("Блюда:\n");
        for (Dish dish : dishes) {
            sb.append("  - ").append(dish).append("\n");
        }
        sb.append("Общая стоимость: ").append(String.format("%.2f", totalCost)).append(" руб.");
        return sb.toString();
    }
}
