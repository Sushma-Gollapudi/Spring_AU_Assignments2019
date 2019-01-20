package taxi_threads;

import java.util.LinkedList;


public class PassengerQueueRunnable implements Runnable {
    TaxiStand lot;
    LinkedList<Passenger> passengerQueue;
    int queueNumber=0;
    public PassengerQueueRunnable(LinkedList<Passenger> queue, TaxiStand l) {
        passengerQueue = queue;
        lot = l;
    }

    @Override
    public void run() {
        while(true) {
            lot.processPassengerQueue();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {

            }
        }
    }
}

