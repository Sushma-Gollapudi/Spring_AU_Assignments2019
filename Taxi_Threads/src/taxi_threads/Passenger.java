package taxi_threads;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Passenger {


    public static enum DESTINATION {
        WHITEFIELD, SARJAPUR, KRPURAM, INDIRANAGAR, MGROAD, HEBBAL, JAYANAGAR, PEENYA, HSRLAYOUT, KORAMANGLA
    }
    public static final DESTINATION[] DESTINATION_VALUES = DESTINATION.values();


    private DESTINATION destination;
    boolean isNew;

    public Passenger(DESTINATION dest, boolean isNew){
        destination = dest;
        this.isNew = isNew;
    }
    public DESTINATION getDestination() {
        return destination;
    }
}
