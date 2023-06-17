package eclipTip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Getter_Setter {
private String carName;
private String carType;
private String carColor;
private String carMachine;
public String getCarName() {
	return carName;
}
public void setCarName(String carName) {
	this.carName = carName;
}
public String getCarType() {
	return carType;
}
public void setCarType(String carType) {
	this.carType = carType;
}
public String getCarColor() {
	return carColor;
}
public void setCarColor(String carColor) {
	this.carColor = carColor;
}
public String getCarMachine() {
	return carMachine;
}
public void setCarMachine(String carMachine) {
	this.carMachine = carMachine;
}


}