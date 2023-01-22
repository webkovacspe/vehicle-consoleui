package hu.kovacspeterzoltan.bootcamp.vehicleconsoleui.controller;

import hu.kovacspeterzoltan.bootcamp.vehicleregister.dao.VehicleRegisterInteractorInterface;

public class VehicleConsoleUI {
    VehicleRegisterInteractorInterface registerInteractor;

    public void setRegisterInteractorImp(VehicleRegisterInteractorInterface registerInteractorImp) {
        registerInteractor = registerInteractorImp;
    }
    public void start() {
        String jsonString = """
            {
              "registrationNumber":"XX:YY-999",
              "vehicleRegister":"Cseresznye",
              "vehicle":"vehicle",
              "make":"Opel",
              "model":"Astra",
              "numberOfSeats":5,
              "vehicleType":"m1"
            }
            """;
        registerInteractor.saveVehicle(jsonString);
    }
}