package com.micsc15.xpark.managers;

import com.mapbox.mapboxsdk.api.ILatLng;
import com.micsc15.xpark.models.Card;

import java.util.UUID;

public class PairiDaizaManager {

    // -------------- Objects, Variables -------------- //

    public static ILatLng iLatLng = new ILatLng() {
        @Override
        public double getLatitude() {
            return 50.584768;
        }

        @Override
        public double getLongitude() {
            return 3.886962;
        }

        @Override
        public double getAltitude() {
            return 0;
        }
    };


    // --------------- Public Methods ----------------- //

    public static Card GetAttractionCard(UUID attractionID){

        Card card = new Card();
        card.CardID = attractionID;
        card.Description = "TODO";
        card.Url = "http://www.pairidaiza.eu/cache/im/activity_banner/uploads/activity_banners/4fb65db7645ef.jpg";
        card.Name = "LES OISEAUX ET PLATANES DE LA LAGUNE";

        return card;
    }

    // --------------- Private Methods ---------------- //


    // ----------------- Miscellaneous ---------------- //

}
