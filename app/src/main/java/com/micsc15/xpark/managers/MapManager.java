package com.micsc15.xpark.managers;

import com.micsc15.xpark.models.maps.Pin;
import java.util.ArrayList;
import java.util.UUID;

public class MapManager {

    // -------------- Objects, Variables -------------- //


    // --------------- Public Methods ----------------- //

    public static ArrayList<Pin> GetMapPins(){
        ArrayList<Pin> pins = new ArrayList<Pin>();
        pins.addAll(GetAttractionsPin());
        return pins;
    }

    // --------------- Private Methods ---------------- //

    private static ArrayList<Pin> GetAttractionsPin(){
        ArrayList<Pin> pins = new ArrayList<Pin>();
        pins.add(new Pin(UUID.randomUUID(), "http://www.clker.com/cliparts/n/T/j/m/1/z/map-pin-green-hi.png", 12.12,12.12));
        pins.add(new Pin(UUID.randomUUID(), "https://openclipart.org/image/800px/svg_to_png/169839/map-pin.png", 12.12,12.12));
        pins.add(new Pin(UUID.randomUUID(), "http://www.clker.com/cliparts/n/T/j/m/1/z/map-pin-green-hi.png", 12.12,12.12));
        pins.add(new Pin(UUID.randomUUID(), "http://www.clker.com/cliparts/n/T/j/m/1/z/map-pin-green-hi.png", 12.12,12.12));
        pins.add(new Pin(UUID.randomUUID(), "http://www.clker.com/cliparts/n/T/j/m/1/z/map-pin-green-hi.png", 12.12,12.12));
        pins.add(new Pin(UUID.randomUUID(), "https://openclipart.org/image/800px/svg_to_png/169839/map-pin.png", 12.12,12.12));
        pins.add(new Pin(UUID.randomUUID(), "https://openclipart.org/image/800px/svg_to_png/169839/map-pin.png", 12.12,12.12));
        pins.add(new Pin(UUID.randomUUID(), "https://openclipart.org/image/800px/svg_to_png/169839/map-pin.png", 12.12,12.12));
        pins.add(new Pin(UUID.randomUUID(), "http://www.clker.com/cliparts/n/T/j/m/1/z/map-pin-green-hi.png", 12.12,12.12));

        return pins;
    }

    // ----------------- Miscellaneous ---------------- //

}
