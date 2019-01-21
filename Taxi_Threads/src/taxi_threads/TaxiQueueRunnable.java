package taxi_threads;

import java.util.LinkedList;

public class TaxiQueueRunnable implements Runnable {

    private LinkedList<Taxi> taxiQueue;
    private TaxiStand taxiStand;

    public TaxiQueueRunnable(LinkedList<Taxi> q, TaxiStand l){
        taxiQueue = q;
        taxiStand = l;
    }

    @Override
    public void run() {
        System.out.println("Starting taxiQueue Thread...");
        while(true) {
            try {
                Thread.sleep(60000);
                taxiQueue.add(new Taxi());
                System.out.println("the queue");
             } catch (InterruptedException ie) {

            }
        }
    }
}
