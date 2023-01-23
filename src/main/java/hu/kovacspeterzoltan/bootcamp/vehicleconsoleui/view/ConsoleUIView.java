package hu.kovacspeterzoltan.bootcamp.vehicleconsoleui.view;

import hu.kovacspeterzoltan.bootcamp.vehicleregister.validator.InvalidJsonStringException;
import org.json.JSONException;
import org.json.JSONObject;

public class ConsoleUIView {
    public void displayError(JSONObject jsonObject) {
        try {
            System.out.println(jsonObject.get("errorMessage"));
        } catch (JSONException e) {
            throw new InvalidJsonStringException();
        }
    }
    public void displayVehicle(JSONObject jsonObject) {
        try {
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
