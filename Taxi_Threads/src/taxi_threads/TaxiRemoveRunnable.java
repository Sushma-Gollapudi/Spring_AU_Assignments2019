package taxi_threads;

import java.util.LinkedList;

public class TaxiRemoveRunnable implements Runnable{
	//private Taxi t;
	LinkedList<Taxi> taxiStand;
	public TaxiRemoveRunnable(LinkedList<Taxi> l){
        taxiStand = l;
    }
	
	@Override
	public void run() {
		
		for(int i=0;i<taxiStand.size();i++) {
			if((taxiStand.get(i)).timecheck()) {
				System.out.println("Taxi left after its time limit reached");
				taxiStand.remove(i);
				taxiStand.add(i,new Taxi());
				System.out.println("the slot");
				
			}
		}
	}

}