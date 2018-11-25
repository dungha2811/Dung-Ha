/*STOCK CLASS*/
public class Stock {
	private String TimeStamp;         //the time of the file
	private double openPrice;         //the open price of the minute
	private double closePrice;        //the last price of the minute
	private double lowPrice;          //the lowest price in the minute
 	private double highPrice;         //the highest price in the minute
	private int volume;               //the volume that price change in the minute
	
	/**
	 * Constructor
	 */
	Stock(){
		TimeStamp = "NA:NA:NA:AM/PM";
		openPrice = 0.0;
		closePrice = 0.0;
		lowPrice = 0.0;
		highPrice = 0.0;
		volume = 0;
	}
	
	/**
	 * Constructor
	 * @param TimeStamp the variable in the String TimeStamp field
	 * @param openPrice the variable in the double openPrice field
	 * @param closePrice the variable in the double closePrice field
	 * @param lowPrice the variable in the double lowPrice field
	 * @param highPrice the variable in the double highPrice field
	 * @param volum the variable in the int volume field
	 */
	Stock(String TimeStamp, double closePrice, double lowPrice, double highPrice, double openPrice,int volume){
		this.TimeStamp = TimeStamp;
		this.closePrice = closePrice;
		this.lowPrice = lowPrice;
		this.highPrice = highPrice;
		this.openPrice = openPrice;
		this.volume = volume;
	}
    
	/**
	 * The getVolume method return the variable in the volume field
	 * @return volume the variable in the Volume field
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * the setVolume method get the variable and store in the int Volume field
	 * @param volume the variable that will be store in the volume field method
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}

	/**
	 * The setTimeStamp method get the variable and store in the String TimeStamp field
	 * @param TimeStamp the variable that will be store in the String TimeStamp field
	 */
	public void setTimeStamp(String TimeStamp) {
		this.TimeStamp = TimeStamp;
	}
	
	/**
	 * the setOpenPrice method get the variable and store in the double openPrice field
	 * @param price the variable that will be store in the openPrice field method
	 */
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	
	/**
	 * the setLowPrice method get the variable and store in the double lowPrice field
	 * @param lowPrice the variable that will be store in the lowPrice field method
	 */
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	
	/**
	 * the setHighPrice method get the variable and store in the double highPrice field
	 * @param highPrice the variable that will be store in the highPrice field method
	 */
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	
	/**
	 * the setClosePrice method get the variable and store in the double closePrice field
	 * @param closePrice the variable that will be store in the closePrice field method
	 */
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	
	/**
	 * The getTimeStamp method return the variable in the TimeStamp field
	 * @return TimeStamp the variable in the TimeStamp field
	 */
	public String getTimeStamp() {
		return TimeStamp;
	}
	
	/**
	 * The getOpenPrice method get the variable and store in the openPrice field
	 * @return Price the variable in the openPrice field
	 */
	public double getOpenPrice() {
		return openPrice;
	}
	
	/**
	 * The getClosePrice method get the variable and store in the closePrice field
	 * @return closePrice the variable in the closePrice field
	 */
	public double getClosePrice() {
		return closePrice;
	}
	
	/**
	 * The getHighPrice method get the variable and store in the highPrice field
	 * @return highPrice the variable in the highPrice field
	 */
	public double getHighPrice() {
		return highPrice;
	}
	
	/**
	 * The getLowPrice method get the variable and store in the lowPrice field
	 * @return lowPrice the variable in the lowPrice field
	 */
	public double getLowPrice() {
		return lowPrice;
	}
}

/* ========================================================================== */ 
/*                      E N D   O F   STOCK CLASS                             */
/* ========================================================================== */