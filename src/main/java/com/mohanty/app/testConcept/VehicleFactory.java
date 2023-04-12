package com.mohanty.app.testConcept;

public class VehicleFactory {

	public static VehicleContract getElectricVehicle() {
		return new AdvancedVehiclePrototype();
	}
	
	public static VehicleContract getDieselVehicle() {
		return new DieselAutomobileCar();
	}
	
	public static VehicleContract getNavalVehicle() {
		return new AircrafCarrierShip();
	}
	
	public static AutomobileContract getDieselAutomobile() {
		return new DieselAutomobileCar();
	}
	
	public static NavalshipContract getNavalAircraftCarrier() {
		return new AircrafCarrierShip();
	}
	
	/**
	 * will throw {@link ClassCastException}
	 * @return
	 */
	public static AutomobileContract getAdvancedAutomobile() {
		return (AutomobileContract) new AdvancedVehiclePrototype();
	}
}
