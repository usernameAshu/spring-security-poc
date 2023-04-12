package com.mohanty.app.testConcept;

public class DieselAutomobileCar implements AutomobileContract {

	public DieselAutomobileCar() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String start() {
		// TODO Auto-generated method stub
		return "Diesel engine start";
	}

	@Override
	public String stop() {
		// TODO Auto-generated method stub
		return "Diesel engine stop";
	}

	@Override
	public String maintainance() {
		// TODO Auto-generated method stub
		return "Diesel engine maintenance";
	}

	@Override
	public String pollutionCheckPetrolEngine() {
		// TODO Auto-generated method stub
		return "Not valid";
	}

	@Override
	public String pollutionCheckDieselEngine() {
		// TODO Auto-generated method stub
		return "Diesel engine check";
	}

}
