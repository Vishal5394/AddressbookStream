package com.Bridgelabz.Stream;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;



public class AddressBook {

        static Scanner scanner = new Scanner(System.in);
        static StringBuilder stringBuilder=new StringBuilder();
    	static ArrayList<Contact> contacts = new ArrayList<Contact>();

    	public static void main(String[] args) throws Exception {
    		System.out.println("Welcome to the Address Book Problem");
    		AddressBook contacts = new AddressBook();
    		boolean condition = true;

    		while (condition == true) {
    			System.out.println("1.AddContact & Write The File" + "\n" +"2.Reader of The JSON File" );
    			int option = scanner.nextInt();

    			switch (option) {
    			case 1:
    				contacts.addContactDetails();
    				break;
    			case 2:
    			    contacts.ReaderJSON();
    			default:
    				System.out.println("Invalid Input");
    			}
    		}
    	}
    	
    	// Method to add contact
    	public void addContactDetails() throws IOException  {
    		Contact details = new Contact();
    		System.out.println("Enter a first name:");
    		details.setFirstName(scanner.next());
    		System.out.println("Enter a last name:");
    		details.setLastName(scanner.next());
    		System.out.println("Enter a Address:");
    		details.setAddress(scanner.next());
    		System.out.println("Enter a City name:");
    		details.setCity(scanner.next());
    		System.out.println("Enter a state:");
    		details.setState(scanner.next());
    		System.out.println("Enter a email:");
    		details.setEmail(scanner.next());
    		System.out.println("Enter a zip code:");
    		details.setZip(scanner.next());
    		System.out.println("Enter a phone number:");
    		details.setPhoneNumber(scanner.next());

    		contacts.add(details);
    		System.out.println(contacts);
    		System.out.println("successfully added new contacts");
    		JSONObject obj = new JSONObject();
    		
    		// creating key value pairs
    		obj.put("First Name",details.getFirstName());
    		obj.put("Last Name",details.getLastName());
    		obj.put("Address",details.getAddress());
    		obj.put("City",details.getCity());
    		obj.put("State",details.getState());
    		obj.put("Zip",details.getZip());
    		obj.put("Phone Number",details.getPhoneNumber());
    		
    		FileWriter file = new FileWriter("C:\\Users\\JADYAL.DESKTOP-UGD6SS3\\Desktop\\RFP167\\AddressbookStream");
    		file.flush();
    		System.out.println("File has been created......");
    }
    	public void ReaderJSON() throws FileNotFoundException  {
    		JSONParser jsonparser=new JSONParser();
    		//  location of the file 
    		FileReader reader=new FileReader("D:\\Java Learning\\addressbook.json");
    	    
    		try {
    		Object obj = jsonparser.parse(reader);
    		JSONObject empjsonobj=(JSONObject)obj;
    		String fname=(String) empjsonobj.get("First Name");
    		String lname=(String) empjsonobj.get("Last Name");
    		String address=(String) empjsonobj.get("Address");
    		String city=(String) empjsonobj.get("City");
    		String state=(String) empjsonobj.get("State");
    		String zip=(String) empjsonobj.get("Zip");
    		String phoneNumber=(String) empjsonobj.get("Phone Number");
    	    System.out.println("First Name :"+fname+" "+"Last Name :"+lname+" "+
    	    		"State :"+state+" "+"Address :"+address+" "+"Zip :"+zip+" "+"Phone Number :"+phoneNumber);
    	    
    	    
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (ParseException e) {
    			
    			e.printStackTrace();
    		}
    	}
    	}
