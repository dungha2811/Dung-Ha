/*ALGORITHM TRADER CLASS*/
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class AlgorithmTrader {
	
	//constant variable
	final private double SELL_SIGNAL_THREASHOLD = 0.0012;      //the signal for user to sell stocks
 	final private double BUY_SIGNAL_THREASHOLD = 5;            //the signal for user to buy stocks
	
	//normal variable
	private ArrayList<Stock> array;           //the ArrayList of Stock object
	private String Status = "NONE";           //the status of user holding stock a not
	private int fileLine = 0 ;                //calculate the line of the file
	private int count = 0;                    //the counter for the entry strategy
	private int sharesBought = 0;             //the total shares that user bought
	private int countMinute = 0;              //counter to get the last minute of the day
	private double profitLost=0;              //the profit or lost after every minute 
	private double realizedProfit;            //the actual profit or lost
	private double purchaseCost;              //the total cost for all the shares
	private double priceChange;               //the price change after every minute in percentage
	private double purchasePrice = 0;         //the price that user purchase or sell stock
	private double currentPrice;              //the current price in every minute
	private double lastPrice;                 //the price in the minute before (use to compare)

	/**
	 * @return the array
	 */
	public ArrayList<Stock> getArray() {
		return array;
	}

	/**
	 * @param array the array to set
	 */
	public void setArray(ArrayList<Stock> array) {
		this.array = array;
	}

	public void ReadInputData() throws IOException {

		//ask user to input their file
		System.out.print("Input your file (.csv): ");
		Scanner input = new Scanner (System.in);
		String inputFile = input.nextLine();
		
		//create an object to input the file
		File file = new File(inputFile);
		
		//define if file exits or not
		if(file.exists() == false) {
			System.out.print("File does not exist!");
			System.exit(0);
		}
		
		//read the input from file
		Scanner inputFromFile = new Scanner(file);
		
		//read the first line (title line)
		inputFromFile.nextLine();
		
		//create an arrayList of stock object
		array = new ArrayList<Stock>();
		
		//store the file into the ArrayList
		while (inputFromFile.hasNextLine()) {
	
			//read the file
			String line = inputFromFile.nextLine();
			String mainTime = line.split(",")[0];                              //read the time stamp of the file
			double mainClosePrice = Double.parseDouble(line.split(",")[1]);    //read the close price of the file
			double mainLowPrice = Double.parseDouble(line.split(",")[2]);      //read the high price of the file  
			double mainHighPrice = Double.parseDouble(line.split(",")[3]);     //read the low price of the file  
			double mainOpenPrice = Double.parseDouble(line.split(",")[4]);     //read the open price of the file  
			int mainVolume = Integer.parseInt(line.split(",")[5]);             //read the volume of the file
			
			//add the variables into the ArrayList
			array.add(new Stock(mainTime,mainClosePrice,mainOpenPrice,mainLowPrice,mainHighPrice, mainVolume));                   
			

			//count the line
			fileLine++;
		}
				
		//close the input object
		inputFromFile.close();	
		input.close();
		
	}
	
	/**
	 * the EntryStratergy methods use to return the status of the Stock is being held or not after buying
	 * @return the boolean for the user to decide to buy stock or not
	 */
	public boolean EntryStrategy() {
		
		//create a counter to count the number of the next price greater than the last price
		if(currentPrice > lastPrice) {
			count ++;
			
			//the next price greater than the last price
			if(count >= BUY_SIGNAL_THREASHOLD) {
				return true;      //return true when the user decide to buy stock
			}
		}
		
		//when the next price is not greater than the last price
		else {
			count = 0;          //reset the counter to 0
			return false;       //return false when the conditions is not enough for user to buy stock
		}
		return false;         //return false when the conditions is not enough
	}
	
	/**
	 * the ExitStratergy methods use to return the status of the Stock is held or not after selling 
	 * @return the boolean for the user to decide to sell stock or not
	 */
	public boolean ExitStrategy() {
		
		//when user not purchasing stock, the price change will always be 0 
		 if(purchasePrice == 0) {
			 priceChange = 0;
		 }
		 
		 //when user purchased stock
		 else {
			 
			 //calculate the price change every minute
			 priceChange = (currentPrice - purchasePrice)/purchasePrice;
			 
			 //if the price is changing too much the user will sell it (Exit Strategy)
			 if(-1*SELL_SIGNAL_THREASHOLD > priceChange
				|| SELL_SIGNAL_THREASHOLD <priceChange) {
				 return true;         //return true to sell stock
			 }
		 }
		 
		 //when the user still holding stock in the last minute
		 if(countMinute == fileLine-1) {
			return true;              //return true to sell stock
		}
			return false;             //return false 
	}
	
	/**
	 * The Run function read the input file, calculate price include all strategy and print out to a file
	 * @throws IOException
	 */
	public void Run() throws IOException {
		//read the file
		ReadInputData();
		
		//create a PrintWriter object so that
		PrintWriter pw = new PrintWriter("tradingSummary.csv");
		
		//for loop to run the data in every minute of the day
		for(int i = 0; i< array.size(); i++) {
			
			//count the loop to a class member variable
			countMinute = i;
			
			//if the counter is less than 0
			if(i != 0) {
				lastPrice = array.get(i-1).getClosePrice();
				currentPrice = array.get(i).getClosePrice();
				//System.out.println(lastPrice +" "+ currentPrice);
			}
			
			//when the user is not having any shares and the entry strategy condition is fit
			if( Status.equals("NONE") && EntryStrategy() == true) {
				
				//Change status to holding
				Status ="HOLD";
				
				//calculation
				purchasePrice = currentPrice;
				sharesBought = 10000;
				purchaseCost = purchasePrice * 10000;
			}
			
			//when the user holding stock
			if(Status.equals("HOLD")){
				
				//calculate the profit lost after having stock after every minute 
				profitLost = (currentPrice - purchasePrice)*10000;
			}
			
			//when the user is not holding stock
			else if(Status.equals("NONE")) {
				
				//bring the profit lost 
				profitLost = 0;
			}
			boolean exit = ExitStrategy();
			//when the user holding stock and the selling condition fit
			if(Status.equals("HOLD") && exit == true){
				
				//change the status to NONE holding
				Status ="NONE";
				
				//calculation
				sharesBought = 0;
				purchasePrice = currentPrice;
				realizedProfit += profitLost;
			}
			
			//print out to the file
			pw.printf("%s,%.2f,%d,%.6f,$%.2f,$%.2f,%s,$%.2f,$%.2f%n"
					,array.get(i).getTimeStamp(),array.get(i).getClosePrice()
					,sharesBought,priceChange,profitLost,realizedProfit,Status,purchasePrice,purchaseCost);
		}
		
		//Print out to let the user know that the program print succesfully
		System.out.println("Program run succesfully, print succesfully to tradingSummary.csv !");
		pw.close();
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * @return the fileLine
	 */
	public int getFileLine() {
		return fileLine;
	}

	/**
	 * @param fileLine the fileLine to set
	 */
	public void setFileLine(int fileLine) {
		this.fileLine = fileLine;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the sharesBought
	 */
	public int getSharesBought() {
		return sharesBought;
	}

	/**
	 * @param sharesBought the sharesBought to set
	 */
	public void setSharesBought(int sharesBought) {
		this.sharesBought = sharesBought;
	}

	/**
	 * @return the countMinute
	 */
	public int getCountMinute() {
		return countMinute;
	}

	/**
	 * @param countMinute the countMinute to set
	 */
	public void setCountMinute(int countMinute) {
		this.countMinute = countMinute;
	}

	/**
	 * @return the profitLost
	 */
	public double getProfitLost() {
		return profitLost;
	}

	/**
	 * @param profitLost the profitLost to set
	 */
	public void setProfitLost(double profitLost) {
		this.profitLost = profitLost;
	}

	/**
	 * @return the realizedProfit
	 */
	public double getRealizedProfit() {
		return realizedProfit;
	}

	/**
	 * @param realizedProfit the realizedProfit to set
	 */
	public void setRealizedProfit(double realizedProfit) {
		this.realizedProfit = realizedProfit;
	}

	/**
	 * @return the purchaseCost
	 */
	public double getPurchaseCost() {
		return purchaseCost;
	}

	/**
	 * @param purchaseCost the purchaseCost to set
	 */
	public void setPurchaseCost(double purchaseCost) {
		this.purchaseCost = purchaseCost;
	}

	/**
	 * @return the priceChange
	 */
	public double getPriceChange() {
		return priceChange;
	}

	/**
	 * @param priceChange the priceChange to set
	 */
	public void setPriceChange(double priceChange) {
		this.priceChange = priceChange;
	}

	/**
	 * @return the purchasePrice
	 */
	public double getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * @return the currentPrice
	 */
	public double getCurrentPrice() {
		return currentPrice;
	}

	/**
	 * @param currentPrice the currentPrice to set
	 */
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	/**
	 * @return the lastPrice
	 */
	public double getLastPrice() {
		return lastPrice;
	}

	/**
	 * @param lastPrice the lastPrice to set
	 */
	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

	/**
	 * @return the sELL_SIGNAL_THREASHOLD
	 */
	public double getSELL_SIGNAL_THREASHOLD() {
		return SELL_SIGNAL_THREASHOLD;
	}

	/**
	 * @return the bUY_SIGNAL_THREASHOLD
	 */
	public double getBUY_SIGNAL_THREASHOLD() {
		return BUY_SIGNAL_THREASHOLD;
	}
}

/* ========================================================================== */ 
/*                      E N D   O F   ALGORITHM                             */
/* ========================================================================== */