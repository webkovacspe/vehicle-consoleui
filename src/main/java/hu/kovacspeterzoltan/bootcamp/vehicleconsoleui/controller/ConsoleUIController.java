package hu.kovacspeterzoltan.bootcamp.vehicleconsoleui.controller;

import hu.kovacspeterzoltan.bootcamp.vehicleregister.api.VehicleRegisterFindAPI;
import hu.kovacspeterzoltan.bootcamp.vehicleregister.api.VehicleRegisterSaveVehicleAPI;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Scanner;

public class ConsoleUIController {
    VehicleRegisterSaveVehicleAPI vehicleRegisterSaveVehicleInteractor;
    VehicleRegisterFindAPI vehicleRegisterFindInteractor;
    Scanner scanner;

    public void setSaveVehicleInteractorImp(VehicleRegisterSaveVehicleAPI saveVehicleInteractorImp) {
        vehicleRegisterSaveVehicleInteractor = saveVehicleInteractorImp;
    }

    public void setFindInteractorImp(VehicleRegisterFindAPI findInteractorImp) {
        vehicleRegisterFindInteractor = findInteractorImp;
    }

    public void start() {
        scanner = new Scanner(System.in);
        String action = null;
        do {
            action = getAction();

            if ("r".equals(action)) {
                saveAction();
            } else if ("l".equals(action)) {
                findAction();
            }
        } while (!"k".equals(action));

        System.out.println("Sikeres kilépés");
    }

    private void findAction() {
        try {
            JSONObject jsonObject = new JSONObject();
            System.out.println("Adja meg a rendszámot:");
            jsonObject.put("registrationNumber", scanner.next());

            vehicleRegisterFindInteractor.findVehicleByRegistrationNumber(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void saveAction() {
        try {
            //TODO szét kell szedni validálás, parsolás és View részekre
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("vehicle", "vehicle");

            System.out.println("Adja meg a rendszámot:");
            jsonObject.put("registrationNumber", scanner.next());
            System.out.println("Adja meg a nyilvántartó nevét:");
            jsonObject.put("vehicleRegister", scanner.next());
            System.out.println("Adja meg a gyártmányt:");
            jsonObject.put("make", scanner.next());
            System.out.println("Adja meg a típust:");
            jsonObject.put("model", scanner.next());
            System.out.println("Adja meg az ülőhelyek számát:");
            jsonObject.put("numberOfSeats", scanner.next());
            System.out.println("Adja meg a jármű kategóriáját:");
            jsonObject.put("vehicleType", scanner.next());

            vehicleRegisterSaveVehicleInteractor.saveVehicle(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String getAction() {
        String action;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Válasszon funkciót: Rögzít (r); Lekérdez (l); Kilép (k)");
        action = scanner.next();
        return action;
    }
}