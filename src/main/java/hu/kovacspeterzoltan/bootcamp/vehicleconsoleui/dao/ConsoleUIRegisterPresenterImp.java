package hu.kovacspeterzoltan.bootcamp.vehicleconsoleui.dao;

import hu.kovacspeterzoltan.bootcamp.vehicleregister.dao.VehicleRegisterPresenterInterface;

public class ConsoleUIRegisterPresenterImp implements VehicleRegisterPresenterInterface {
    @Override
    public void displaySaveMessage(String responseMessage) {
        System.out.println(responseMessage);
    }
}