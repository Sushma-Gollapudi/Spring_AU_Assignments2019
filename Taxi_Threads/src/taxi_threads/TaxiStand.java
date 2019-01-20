package taxi_threads;

import java.util.LinkedList;
import java.util.ListIterator;

public class TaxiStand {
    private int size = 5;
    static LinkedList<Taxi> taxiStand;
    LinkedList<Taxi> taxiQueue;
    LinkedList<Passenger> passengerQueue;
    boolean lock;

    public TaxiStand(int capacity, LinkedList<Taxi> q, LinkedList<Passenger> pq) {
        size = capacity;
        taxiQueue = q;
        passengerQueue = pq;
        taxiStand = new LinkedList<Taxi>();
        System.out.println("Creating a TaxiStand with capacity " + size);
        for(int i=0; i<size ; i++){
            taxiStand.add(new Taxi(taxiStand,taxiQueue));
            if(!taxiQueue.isEmpty())
            	taxiQueue.remove(0);
            System.out.println("the stand");
        }
        
    }

    public TaxiStand() {
		// TODO Auto-generated constructor stub
	}

	public void addTaxi(Taxi c){
        taxiQueue.add(c);
    }

    public boolean isFull(){
        return (taxiStand.size()<size) ? false : true;
    }
    
    public boolean isEmpty() {
        return (taxiStand.size()==0) ? true : false;
    }

    public synchronized boolean allocatePassenger(Passenger p) {
        if(p.isNew)
        	lock=true;
        else
        	lock = false;
        if(lock && p.isNew == false)
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
        
        
    	for(int i=0;i<taxiStand.size();i++){
            if(taxiStand.get(i).allocatePassenger(p))
            	return true;
        }
        
        System.out.println("Unable to find taxi for passenger with destination "+p.getDestination());
        if(p.isNew && lock==true) {
        	lock=false;
        	notifyAll();
        }
        return false;
        
    }
    
//    public boolean allocatePassenger(Passenger p) {
//    	//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+taxiStand.size());
//    	for(int i=0;i<taxiStand.size();i++){
//    		
//            if(taxiStand.get(i).allocatePassenger(p)) 
//            	return true;
//        }
//        
//        System.out.println("Unable to find taxi for passenger with destination "+p.getDestination());
//        return false;
//        
//    }

    public void processPassengerQueue(){
        System.out.println("Starting to process passengerQueue with " + passengerQueue.size() + " passengers");
        for(int i=0;i<passengerQueue.size();i++)
        {	
        	if(allocatePassenger(passengerQueue.get(i))){
        		
        		passengerQueue.remove(i);
        	}
        	
        }
        
        System.out.println("After processing passengerQueue " + passengerQueue.size() + " passengers remain in queue");
    }

    public void printStatus() {
        ListIterator<Taxi> standIterator = taxiStand.listIterator();
        int position=0;
        while(standIterator.hasNext()) {
            Taxi taxi = standIterator.next();
            position++;
            System.out.println(position + ". Taxi to " + taxi.getDestination() + " passengers=" + taxi.getpassengerCount());
        }
    }
    public static void main(String[] args) {
        System.out.println("Starting simulaion...");
        LinkedList<Taxi> taxiQueue = new LinkedList<Taxi>();
        LinkedList<Passenger> passengerQueue = new LinkedList<Passenger>();
        TaxiStand lot = new TaxiStand(5, taxiQueue, passengerQueue);

        TaxiQueueRunnable taxicreator = new TaxiQueueRunnable(taxiQueue, lot);
        PassengerRunnable passengerCreator = new PassengerRunnable(passengerQueue, lot);
        PassengerQueueRunnable passengerQueueCreator = new PassengerQueueRunnable(passengerQueue, lot);
        TaxiRemoveRunnable taxiremover=new TaxiRemoveRunnable(taxiStand);
        
        Thread taxiThread = new Thread(taxicreator);
        Thread passengerThread = new Thread(passengerCreator);
        Thread passengerQueueThread = new Thread(passengerQueueCreator);
        Thread taxiRemoverThread= new Thread(taxiremover);
        
        taxiThread.start();
        passengerThread.start();
        
        taxiThread.setPriority(7);
        passengerThread.setPriority(7);
        
        passengerQueueThread.start();
        passengerQueueThread.setPriority(6);
        
        taxiRemoverThread.start();
        taxiRemoverThread.setPriority(10);
    }
}
