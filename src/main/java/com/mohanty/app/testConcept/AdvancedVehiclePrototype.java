package com.mohanty.app.testConcept;

public class AdvancedVehiclePrototype implements VehicleContract {

	public AdvancedVehiclePrototype() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String start() {
		// TODO Auto-generated method stub
		return "Engine On Electric";
	}

	@Override
	public String stop() {
		// TODO Auto-generated method stub
		return "Eletric engine stop";
	}

	@Override
	public String maintainance() {
		// TODO Auto-generated method stub
		return "Electric engine maintenance";
	}

}
