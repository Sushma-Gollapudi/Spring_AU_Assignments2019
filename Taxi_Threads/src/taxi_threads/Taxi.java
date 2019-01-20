package taxi_threads;

import java.util.LinkedList;
import java.util.List;

public class Taxi {
    private Passenger.DESTINATION destination;
    public int passenger_count;
    
    private LinkedList<Taxi> taxiQueue;
    private LinkedList<Taxi> taxiStand;
    long startTime ;
    
    public Taxi(LinkedList<Taxi> q, LinkedList<Taxi> l){
        taxiQueue = q;
        taxiStand = l;
        System.out.print("New taxi added to ");
        passenger_count = 0;
        destination = null;
        startTime = System.currentTimeMillis();
    }

    
    public Taxi() {
        System.out.print("New taxi added to ");
        passenger_count = 0;
        destination = null;
        startTime = System.currentTimeMillis();
    }

    boolean timecheck() {
    	
    	if(System.currentTimeMillis()-startTime>=10000) {
    		System.out.println(".....................................");
    		return true;
    	}
    	return false;
    }
    
    public Passenger.DESTINATION getDestination() {
        return destination;
    }

    public int getpassengerCount() {
        return passenger_count;
    }

    public boolean isFull() {
        if(passenger_count<4)
            return false;
        else
            return true;
    }

    public boolean addPassenger() {
//        if(isFull()){
//            System.out.println("Taxi is full");
//            return false;
//        } else {
            passenger_count++;
            System.out.println("Passenger boards taxi to " + destination + "- passenger count " + passenger_count);
            if(isFull()){
            	System.out.println("Taxi to destination "+ destination+" left the stand");
            	//((List<Taxi>) taxiStand).remove(this);
                //((List<Taxi>) taxiStand).add(new Taxi());
            	//Passenger.DESTINATION taxiDest = destination;
            	int i;
                for(i = 0; i < taxiStand.size(); i++) {
                	if(taxiStand.get(i).getDestination() == destination) {
                		taxiStand.remove(i);
                		taxiStand.add(i,new Taxi());
                    	passenger_count=0;
                    	System.out.println("the slot");
                		break;
                	}
                }
                	
            }
            return true;
//        }
    }

    public boolean allocatePassenger(Passenger p) {
        if(destination==null) {
            System.out.println("Empty Taxi - set Destination " + p.getDestination());
            destination = p.getDestination();
            return addPassenger();
        } else {
        	//System.out.println("Destination of taxi issssssssssss "+destination+" and of passenger is "+p.getDestination());
            if(destination==p.getDestination()){
           
                System.out.println("Found taxi to " + destination);
                return addPassenger();
            } else {
                
                return false;
            }
        }
    }
}
