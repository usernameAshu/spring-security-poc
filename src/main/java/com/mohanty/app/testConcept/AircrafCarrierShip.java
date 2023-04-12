package com.mohanty.app.testConcept;

public class AircrafCarrierShip implements NavalshipContract {

	public AircrafCarrierShip() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String start() {
		// TODO Auto-generated method stub
		return "Aircraft carrier start";
	}

	@Override
	public String stop() {
		// TODO Auto-generated method stub
		return "Aircraft carrier stop";
	}

	@Override
	public String maintainance() {
		// TODO Auto-generated method stub
		return "Aircraft carrier maintenance";
	}

	@Override
	public String seaFitnessCertificate() {
		// TODO Auto-generated method stub
		return "Aircraft carrier certified for sea trials";
	}

	@Override
	public String engineType() {
		// TODO Auto-generated method stub
		return "Aircraft carrier engine 2 stroke diesel";
	}

}
