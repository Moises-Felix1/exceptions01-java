package application;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkin = LocalDate.parse(sc.next(), fmt);
		//Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		//String dto = sc.next();
		LocalDate checkout = LocalDate.parse(sc.next(), fmt);
		
		if(!checkout.isAfter(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reserv = new Reservation(number, checkin, checkout);
			System.out.println(reserv.toString());
			
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(sc.next(), fmt);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(sc.next(), fmt);
			
			LocalDate now = LocalDate.now();
			if(checkin.isBefore(now) || checkout.isBefore(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}else {
				if(!checkout.isAfter(checkin)) {
					System.out.println("Error in reservation: Check-out date must be after check-in date");
				}else {
					reserv.updateDate(checkin, checkout);
					System.out.println(reserv.toString());
				}
			}
			
		}
		
		sc.close();

	}

}
