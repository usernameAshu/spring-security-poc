package com.mohanty.app.testConcept;

public class DriverClass {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VehicleContract vehicle = VehicleFactory.getDieselVehicle();
		
		vehicle = VehicleFactory.getNavalAircraftCarrier();
		
//		System.out.println(vehicle.start());
		
//		AutomobileContract advancedAutomobile = VehicleFactory.getAdvancedAutomobile();
//		
//		System.out.println(advancedAutomobile.start());
		
//		DieselAutomobileCar dieselCar = new AircrafCarrierShip();
		
	}

}
