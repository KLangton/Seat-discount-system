import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
public class SeatsDiscountSystem {
	static Scanner console = new Scanner (System.in);

	public static void main(String[] args) throws FileNotFoundException {

		double percent=0;
		String input;
		String retry;
		do {
			String fileName = "seats.txt";
			FileReader file = new FileReader (fileName);
			Scanner read = new Scanner (file);//scanner used to read values from .txt file

			System.out.println("----Seat discount system----");
			System.out.printf("Apply Discount?[y|n}");
			input=console.next();//used for user input to initiate assumed/user specified discount

			if(input.equalsIgnoreCase("y")){
				System.out.println("Select discount rate(%):");
			    boolean done=false;
			    while(!done) {
				try{ //try catch used to avoid InputMismatchException error (i.e user inputing a string instead of a double)
					percent = console.nextDouble();
					done=true;
				}
				catch (InputMismatchException e) { 
					System.out.println("invalid entry please re-enter");
				    console.next();
				}
			    }
				double SumTotal = 0;
				double SumDisTotal=0;
				double income;
				double discount;
				double disTotal;
				double total;
				double Price;
				int Booking;
				while (read.hasNext()) {
					String Table = read.next(); //to read values from text file provided
					Price = read.nextDouble();
					Booking= read.nextInt();
					System.out.printf("Table type:%s", Table);//prints table values into console (type, price, number of bookings)
					System.out.printf(", Price per seat:£%.2f", Price);
					System.out.printf(", No. of bookings:%d", Booking);
					income = Booking*Price; //calculated the price to the number of bookings on each line
					discount = 100 / percent;//calculated the entered percentage
					disTotal = (income / discount);
					total= (income - disTotal);
					System.out.printf(", Discounted price:£%.2f", disTotal);
					System.out.printf(", Total income:£%.2f\n", total);  
					SumTotal= SumTotal+total; //used to summarise the total amount of total price 
					SumDisTotal= SumDisTotal+disTotal;// to summarise the amount discounted from the final price
				}
				System.out.println();	
				System.out.printf("Sum total:£%.2f\n", SumTotal);	//prints summary into console
				System.out.printf("Discount Sum total:£%.2f", SumDisTotal); 
			} 

			if(input.equalsIgnoreCase("n")) {
				final double Adis= 100/20;//remains as a constant as the discount will not change due to assumed discount rate
				System.out.println("Assumed discount rate(%):20");
				String Table;
				double Price;
				int Booking;
				double SumTotal=0;
				double SumDisTotal=0;
				double income;
				double discount;
				double disTotal;
				double total;
				while (read.hasNext()) {
					Table = read.next();   
					Price = read.nextDouble();
					Booking= read.nextInt();
					System.out.printf("Table type:%s, Price per seat:£%.2f, No. of bookings:%d", Table, Price, Booking);
					income = Booking*Price;
					discount = Adis;
					disTotal = (income / discount);
					total= (income - disTotal);
					System.out.printf(" Discounted price:£%.2f", disTotal);
					System.out.printf(" Total income:£%.2f\n", total);  
					SumTotal= SumTotal+total; 
					SumDisTotal= SumDisTotal+disTotal;
				}
				System.out.println();//line spacing	
				System.out.printf("Sum total: £%.2f\n", SumTotal);	
				System.out.printf("Discount Sum total: £%.2f", SumDisTotal);   
			} 
			System.out.println();//line spacing 
			System.out.println("Press press any key to re-enter:");//used to guide user on the correct prompt to enter
			retry=console.next();//user input to initiate while loop
			read.close(); //closes the read on a text file
		}while  (!(retry.equalsIgnoreCase("")));	//used to both restart the loop at the end of correct input or to prompt the user incase an invalid input is entered
	}
}









