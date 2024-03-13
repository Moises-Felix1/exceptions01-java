package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkin = LocalDate.parse(sc.next(), fmt);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkout = LocalDate.parse(sc.next(), fmt);
			
			Reservation reserv = new Reservation(number, checkin, checkout);
			System.out.println("reservation: "+reserv.toString());
			
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(sc.next(), fmt);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(sc.next(), fmt);
			
			reserv.updateDate(checkin, checkout);
			System.out.println(reserv.toString());
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
		catch(DateTimeParseException y) {
			System.out.println("Invalid date format!");
		}
		catch(RuntimeException p) {
			System.out.println("Unexpected error");
		}
		sc.close();

	}

}
