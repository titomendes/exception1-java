package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number");
		int number = sc.nextInt();
		System.out.print("Check-in date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out date: ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: "+ reservation);
			
			System.out.println();
			System.out.println("Enter a date to update the reservation");
			System.out.print("Check-in date: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date: ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)){
				System.out.println("Error in reservation: Reservation dates for updates must be future dates");
			}
			else if (!checkOut.after(checkIn)){
				System.out.println("Error in reservation");
			}
			else {
				reservation.updateDate(checkIn, checkOut);
				System.out.println("Reservation: "+ reservation);
			}
			
			
			
		}
		
	
	
	
	}

}
