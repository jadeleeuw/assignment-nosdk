package nosdk.main;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Example {

    public static double distanceBetween(int stationA, int stationB, int idKey) throws UnirestException {
        String url = String.format("http://localhost:8080/distance/stations?from=%d&to=%d", stationA, stationB);

        return Unirest.get(url)
                .header("x-id-key", String.valueOf(idKey))
                .asObject(Distance.class)
                .getBody().getDistance();
    }
}

class Distance {

    private double distance;

    // This setter is mandatory for Unirest (using Jackson) to perform deserialization
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }
}
