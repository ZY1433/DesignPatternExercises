import java.io.*;
import java.net.URL;
import java.net.URI;
import javax.swing.*;
import java.util.*;

public class CarModel implements Observable {
	private Vector<Observer> observersList;
	private ImageIcon imgIcon;
	private URL url;
	private String[] carNameList;
	private String carSelected;
	private double[] currentBitPrices; // 用于记录当前拍卖价格
	private double[] preBitPrices; // 用于记录之前的拍卖价格
	private boolean isBitBtnClicked = false;
	private boolean isSearchBtnClicked = false;
	static final String CARFILES = "【作业6.5-1】-MVC/src/CarFiles/";
	static final String CARIMAGES = "CarImages/";

	public CarModel() {
		observersList = new Vector<Observer>();
		carNameList = new String[200];
		currentBitPrices = new double[4];
		preBitPrices = new double[4];
	}

	public void setCarList(String[] cars) {
		carNameList = cars;
	}

	public String[] getCarList() {
		return carNameList;
	}

	public void setSelectedCar(String sCar) {
		carSelected = sCar;
	}

	public String getSelectedCar() {
		return carSelected;
	}

	public void setBitPrice(String bPrice) {
		double newPrice = Double.parseDouble(bPrice);
		int index = getCarIndex(carSelected);
		if (index != -1) {
			preBitPrices[index] = currentBitPrices[index];
			currentBitPrices[index] = newPrice;
		}
	}

	public String getBitPrice() {
		int index = getCarIndex(carSelected);
		return index != -1 ? String.valueOf(currentBitPrices[index]) : "";
	}

	private int getCarIndex(String car) {
		switch (car.toLowerCase()) {
			case "honda accord-2005":
				return 0;
			case "honda civic-2006":
				return 1;
			case "toyota camry-2003":
				return 2;
			case "toyota corolla-2002":
				return 3;
			default:
				return -1;
		}
	}

	public boolean validateAuctionPrice(String car, double offeredPrice) {
		int index = getCarIndex(car);
		if (index != -1) {
			System.out.println("current price: " + currentBitPrices[index] + " offered price: " + offeredPrice);
			return offeredPrice > currentBitPrices[index];
		}
		return false;
	}

	public void setFileUrl() {
		try {
			String fileURLStr = CARFILES + carSelected + ".html";
			URI uri = (new File(fileURLStr)).toURI();
			url = uri.toURL();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public URL getCarFileURL() {
		return url;
	}

	public void setupImageIcon() {
		String iconStr = CARIMAGES + carSelected + ".jpg";
		imgIcon = createImageIcon(iconStr);
	}

	public ImageIcon getImageIcon() {
		return imgIcon;
	}

	public void setBitBtnClickInfo(boolean opt) {
		isBitBtnClicked = opt;
	}

	public boolean isBitBtnClicked() {
		return isBitBtnClicked;
	}

	public void setSearchBtnClickInfo(boolean opt) {
		isSearchBtnClicked = opt;
	}

	public boolean isSearchBtnClicked() {
		return isSearchBtnClicked;
	}

	public void register(Observer obs) {
		observersList.addElement(obs);
	}

	public void notifyObservers() {
		for (int i = 0; i < observersList.size(); i++) {
			Observer observer = (Observer)observersList.get(i);
			observer.update(this);
		}
	}

	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}