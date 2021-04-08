/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import nhinh.car.CarDTO;

/**
 *
 * @author PC
 */
public class CartObject implements Serializable{
    private Map<CarDTO, Integer> cars;

    public Map<CarDTO, Integer> getCars() {
        return cars;
    }

    public void addProductToCart(CarDTO dto, int amount) {
        if (this.cars == null) {
            this.cars = new HashMap<>();
        }
        boolean isExist = false;
        for (CarDTO cDTO : cars.keySet()) {
            if (dto.getCarID().equals(cDTO.getCarID())) {
                int quantity = this.cars.get(cDTO);
                quantity = this.cars.get(cDTO) + amount;
                this.cars.replace(cDTO, quantity);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            this.cars.put(dto, amount);
        }
    }

    public void increaseProductToCart(String carID) {
        if (this.cars == null) {
            return;
        }
        for (CarDTO cdto : cars.keySet()) {
            if (cdto.getCarID().equals(carID)) {
                int quantity = this.cars.get(cdto);
                if (quantity < cdto.getQuantity()) {
                    quantity = this.cars.get(cdto) + 1;
                    this.cars.replace(cdto, quantity);
                    break;
                }
            }
        }
    }

    public void minusProductFromCart(String carID) {
        if (this.cars == null) {
            return;
        }
        for (CarDTO cdto : cars.keySet()) {
            if (cdto.getCarID().equals(carID)) {
                int quantity = this.cars.get(cdto);
                if (quantity > 1) {
                    quantity = this.cars.get(cdto) - 1;
                    this.cars.replace(cdto, quantity);
                    break;
                }
            }
        }
    }

    public void removeProductFromCart(String carID) {
        if (this.cars == null) {
            return;
        }
        for (CarDTO cdto : cars.keySet()) {
            if (cdto.getCarID().equals(carID)) {
                this.cars.remove(cdto);
                if (this.cars.isEmpty()) {
                    this.cars = null;
                }
                break;
            }
        }
    }
}
