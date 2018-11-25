/* ========================================================================== */
/*	PROGRAM Simple Algorithm Trader

    AUTHOR: <Zackary Griffith, Dung Ha>
    COURSE NUMBER: <CIS 210>
    COURSE SECTION NUMBER: <02D>
    INSTRUCTOR NAME: <Dr. Tian>
    PROJECT NUMBER: 8
    DUE DATE: 11/13/2018
SUMMARY

- This program read the price of the stock from a file minute by minute on a day and then test 3 trading strategy that user can use for
trading stock throughout the day:
 - Entry position strategy: buy 10,000 shares if the price increase 10 times
 - Exit position strategy: sell all the shares if the price change 0.12% in the next minute
 - Special exit strategy: sell all shares if the user still hold the shares on the last minute

INPUT

- The input file Name
- A file with a list of Stocks minute by minute

OUTPUT

All the output will be minute by minute
- The time stamp of the day 
- The current price
- The price change percentage after the next minute coming
- The shares that user are holding
- The money that user lost after every minute
- The actual money that user lost
- The status of user holding shares or not
- The price of one stock that user holding 
- The price that user spend to buy all 10,000 stocks

ASSUMPTION
- The Stocks on the file must be in the following order : String NameStamp, String closePrice, double highPrice,
double lowPrice, double openPrice, double volume
*/

/*MAIN FUNCTION*/
import java.io.*;
public class SimpleAlgorithmTradingPlatform {
	public static void main(String[] args) throws IOException {
		
		//create an object to call Algorithm Trader
		AlgorithmTrader object = new AlgorithmTrader() ;	
		
		//call the Run method
		object.Run();
	}
}
/* ========================================================================== */ 
/*                      E N D   O F   P R O G R A M                           */
/* ========================================================================== */