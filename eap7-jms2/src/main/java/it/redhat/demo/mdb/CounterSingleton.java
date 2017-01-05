package it.redhat.demo.mdb;

import javax.ejb.Singleton;

@Singleton
public class CounterSingleton {
	
	private int times = 0;
	
	public int times() {
		return ++times;
	}

	public void reset() {
		times = 0;
	}
	
	public int getTimes() {
		return times;
	}

}
