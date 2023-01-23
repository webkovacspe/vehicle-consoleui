package hu.kovacspeterzoltan.bootcamp.vehicleconsoleui.dao;

import hu.kovacspeterzoltan.bootcamp.vehicleconsoleui.view.ConsoleUIView;
import hu.kovacspeterzoltan.bootcamp.vehicleregister.api.VehicleRegisterPresenter;
import hu.kovacspeterzoltan.bootcamp.vehicleregister.validator.InvalidJsonStringException;
import org.json.JSONException;
import org.json.JSONObject;

public class ConsoleUIRegisterPresenterImp implements VehicleRegisterPresenter {
    ConsoleUIView view;

    public ConsoleUIRegisterPresenterImp() {
        view = new ConsoleUIView();
    }
    @Override
    public void displayMessage(String responseMessage) {
        System.out.println(responseMessage);
    }

    @Override
    public void displayJsonRequest(String jsonString) {
        try {
            //TODO szét kell szedni az alábbi részekre:
            //- Validálás
            //- Model: ami parsol-ja a kapott json stringet
            //- View: ami CSAK megjeleníti (System.out.println)
            JSONObject jsonObject = new JSONObject(jsonString);
            if (jsonObject.has("errorMessage")) {
                view.displayError(jsonObject);
            } else {
                view.displayVehicle(jsonObject);
            }
        } catch (JSONException e) {
            throw new InvalidJsonStringException();
        }
    }
}