package racinggame.domain;

public class Car {

	private final CarName name;

	public Car(CarName name) {
		this.name = name;
	}

	public static Car from(CarName name) {
		return new Car(name);
	}

	public boolean isNameOf(CarName otherCarName) {
		return name.equals(otherCarName);
	}

}
