Main exe file: TaxiStand.java

4 threads:

	1. PassengerRunnable.java
		This creates new passenger every 3sec and checks for the availability of the taxis in the stand.

	2.TaxiQueueRunnable.java
		Thread to generate taxi every minute.

	2.TaxiRemoveRunnable.java
		Thread to remove taxi from the stand when its time limit(1 min) exceeds.

	4. PassengerQueueRunnable.java
			This is used to iterate over passenger queue every 2sec.
