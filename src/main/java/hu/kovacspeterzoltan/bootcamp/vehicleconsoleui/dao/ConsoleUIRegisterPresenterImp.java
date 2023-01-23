package hu.kovacspeterzoltan.bootcamp.vehicleconsoleui.dao;

import hu.kovacspeterzoltan.bootcamp.vehicleregister.dao.VehicleRegisterPresenterInterface;
import hu.kovacspeterzoltan.bootcamp.vehicleregister.validator.InvalidJsonStringException;
import org.json.JSONException;
import org.json.JSONObject;

public class ConsoleUIRegisterPresenterImp implements VehicleRegisterPresenterInterface {
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
            String message = """
                A keresett jármű adatai:
                rendszám: %s
                nyilvántartó neve: %s
                gyártmány: %s
                típus: %s
                ülőhelyek száma: %d
                jármű kategóriája: %s
            """;
            System.out.println(message.formatted(
                    jsonObject.get("registrationNumber"),
                    jsonObject.get("vehicleRegister"),
                    jsonObject.get("make"),
                    jsonObject.get("model"),
                    jsonObject.get("numberOfSeats"),
                    jsonObject.get("vehicleType")
            ));
        } catch (JSONException e) {
            throw new InvalidJsonStringException();
        }
    }
}