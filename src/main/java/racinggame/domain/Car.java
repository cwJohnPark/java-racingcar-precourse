package racinggame.domain;

public class Car {

	private final CarName name;
	private final CarDriver driver;

	public Car(CarName name, CarDriver driver) {
		this.name = name;
		this.driver = driver;
	}

	public static Car of(CarName name, CarDriver driver) {
		return new Car(name, driver);
	}

	public boolean isNameOf(CarName otherCarName) {
		return name.equals(otherCarName);
	}

	public MovementType move() {
		return driver.steer();
	}
}
