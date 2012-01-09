package com.parousia.dealscout.logic;

import android.app.Application;

import com.parousia.dealscout.network.DealScoutCommunicator;

public class DealScoutController extends Application {

	private static DealScoutController instance;
	private DealScoutCommunicator communicator;
	private DealScoutApplicationState applicationState;

	public static DealScoutController getInstance() {
		if (instance == null) {
			instance = new DealScoutController();
		}
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		setCommunicator(new DealScoutCommunicator());
		setApplicationState(new DealScoutApplicationState());
		// initiate(); for tracker

	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
		// release(); for tracker
	}

	public DealScoutCommunicator getCommunicator() {
		return communicator;
	}

	public void setCommunicator(DealScoutCommunicator communicator) {
		this.communicator = communicator;
	}

	public DealScoutApplicationState getApplicationState() {
		return applicationState;
	}

	public void setApplicationState(DealScoutApplicationState applicationState) {
		this.applicationState = applicationState;
	}

}
