import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

public class ContactsRoll	{

	private static Contact[] contactRoll = new Contact[1];
	private static boolean control = true;

	//currently, this function does not work. A null pointer exception is thrown when this function is used. 
	private static int search(Name name)	{
		int i = 0;
		for (i = 0; i < contactRoll.length; i++)	{
			if (contactRoll[i].getName().equals(name))
				break;
		}
		return i;
	}

	//This function initialises a scanner, scans for two Strings, and calls the Name(String, String) constructor to create a Name object. 
	private static Name scanForName()	{
		Scanner input = new Scanner(System.in);
		Name name = null;
		String firstName = null, lastName = null;
		boolean control = true;
		while (control)	{
			System.out.println("Enter the first name of the contact, followed by <Enter>.");
			try	{
				firstName = input.nextLine();
				control = false;
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - the scanner is closed.");
				System.exit(1);
			}
		}
		
		control = true;
		while (control)	{
			System.out.println("Enter the last name of the contact, followed by <Enter>.");
			try	{
				lastName = input.nextLine();
				control = false;
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - The scanner is closed.");
				System.exit(1);
			}
		}
		name = new Name(firstName, lastName);
		return name;
	}

	//This function initialises a scanner, scans and returns a String as a home telephone number. 
	private static String scanForHomeTelephoneNumber()	{
		Scanner input = new Scanner(System.in);
		String homeTelephoneNumber = null;
		boolean control = true;
		while (control)	{
			System.out.println("Enter the contact's home telephone number, followed by <Enter>.");
			try	{
				homeTelephoneNumber = input.nextLine();
				control = false;
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - The scanner is closed.");
				System.exit(1);
			}
		}
		return homeTelephoneNumber;
	}

	//This function initialises a scanner, scan and returns a String as a work telephone number. 
	private static String scanForWorkTelephoneNumber()	{
		Scanner input = new Scanner(System.in);
		String workTelephoneNumber = null;
		boolean control = true;
		while (control)	{
			System.out.println("Enter the contact's work telephone number, followed by <Enter>.");
			try	{
				workTelephoneNumber = input.nextLine();
				control = false;
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - The scanner is closed.");
				System.exit(1);
			}
		}
		return workTelephoneNumber;
	}

	//This function initialises a scanner, scans and returns a String as a cellphone number. 
	private static String scanForCellphoneNumber()	{
		Scanner input = new Scanner(System.in);
		String cellphoneNumber = null;
		boolean control = true;
		while (control)	{
			System.out.println("Enter the contact's cellphone number, followed by <Enter>.");
			try	{
				cellphoneNumber = input.nextLine();
				control = false;
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - The scanner is closed.");
				System.exit(1);
			}
		}
		return cellphoneNumber;
	}

	//This function initialises a scanner, scans for several strings and an int, constructs and returns an Address object. 
	private static Address scanForAddress()	{
		Address address = null;
		String streetAddress = null, suburb = null, city = null, province = null, postalCode = null;
		boolean control = true;
		Scanner input = new Scanner(System.in);
		
		while (control)	{
			System.out.println("Enter the street address of the contact's address, followed by <Enter>.");
			try	{	
				streetAddress = input.nextLine();
				control = false;
			}
			catch (NumberFormatException e)	{
				System.err.println("Integer input required. Please try again.");
				input.nextLine();
			}
			catch (NoSuchElementException e)	{
				System.err.println("Integer input required. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner is closed.");
				System.exit(1);
			}
		}

		control = true;
		while (control)	{
			System.out.println("Enter the suburb of the contact's address, followed by <Enter>.");
			try	{
				suburb = input.nextLine();
				control = false;
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner is closed.");
				System.exit(1);
			}
		}

		control = true;
		while (control)	{
			System.out.println("Enter the city of the contact's address, followed by <Enter>.");
			try	{
				city = input.nextLine();
				control = false;
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner is closed.");
				System.exit(1);
			}
		}

		control = true;
		while (control)	{
			System.out.println("Enter the province of the contact's address, followed by <Enter>.");
			try	{
				province = input.nextLine();
				control = false;  
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner is closed.");
				System.exit(1);
			}
		}
		
		control = true;
		while (control)	{
			System.out.println("Enter the postal code of the contact's address, followed by <Enter>.");
			try	{
				postalCode = input.nextLine();
				control = false;	
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input.Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner is closed.");
				System.exit(1);
			}
			
		}
	
		address = new Address(streetAddress, suburb, city, province, postalCode);
		return address;
	}
	
	//This function initialises a scanner, scans for several int's, constructs and returns a date object. 
	private static Date scanForDateOfBirth()	{
		Scanner input = new Scanner(System.in);
		int day = 0, month = 0, year = 0;
		Date dateOfBirth = null;
		boolean control = true;

		while (control)	{
			System.out.println("Enter the day of the date of birth, followed by <Enter>.");
			try	{
				day = input.nextInt();
				control = false;
			}
			catch (InputMismatchException e)	{
				System.err.println("Integer input required. Please try again.");
				input.nextLine();
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner is closed.");
				System.exit(1);
			}
		}

		control = true;
		while (control)	{
			System.out.println("Enter the month of the date of bith, followed by <Enter>.");
			try	{
				month = input.nextInt();
				control = false;
			}
			catch (InputMismatchException e)	{
				System.err.println("Integer input required. Please try again.");
				input.nextLine();
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner is closed.");
				System.exit(1);
			}
		}
		
		control = true;
		while (control)	{
			System.out.println("Enter the year of the date of birth, followed by <Enter>.");
			try	{
				year = input.nextInt();
				control = false;
			}
			catch (InputMismatchException e)	{
				System.err.println("Integer input required. Please try again.");
				input.nextLine();
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner is closed.");
				System.exit(1);
			}
		}
		dateOfBirth = new Date(day, month, year);
		return dateOfBirth;	
	}
	
	//This function creates a temporary Contact[], copies all the contacts out of the existing array, creates a new contactRoll[] with size contactroll.length + 1,
	//and copies all the contacts into the new array. 
	private static void increaseArrayLength()	{
		if (contactRoll[0] == null)
			;
		else	{	
			int i = 0;
			Contact[] tempArray = new Contact[contactRoll.length];
			for (i = 0; i < contactRoll.length; i++)
				tempArray[i] = contactRoll[i];
			contactRoll = new Contact[tempArray.length+1];
			for (i = 0; i < tempArray.length; i++)
				contactRoll[i] = tempArray[i];
		}	
	}

	//This function creates a temporary Contact[], copies all the contacts out of the existing array, creates a new contactRoll[] with size contactroll.length - 1,
	//and copies all the contacts into the new array.
	private static void decreaseArrayLength()	{
		if (contactRoll[0] == null)
			System.out.println("There are no more entries in this array. ");
		else	{
			int temp = contactRoll.length;
			Contact[] tempArray = new Contact[temp];
			for (int i = 0; i < contactRoll.length - 1; i++)
				tempArray[i] = contactRoll[i];
			contactRoll = new Contact[temp-1];
			for (int i = 0; i < temp-1; i++)
				contactRoll[i] = tempArray[i];
		}
	}

	//this function creates and object input stream, casts the objects in the stream as contacts and stores them in the contactRoll. 
	private static void loadData()	{
		int index = 0;
		ObjectInputStream input = null;
		try	{
			input = new ObjectInputStream(Files.newInputStream(Paths.get("contacts.ser")));
			while (true)	{
				Contact contact = (Contact) input.readObject();
				increaseArrayLength();
				contactRoll[index++] = contact;
			}
		} catch (EOFException e)	{
			;
		} catch (IOException e)	{
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		} catch (ClassNotFoundException e)	{
			System.err.println("Invalid object type. Terminating.");
			System.exit(1);
		}
		try	{
			if (input != null)
				input.close();
		} catch (IOException e)	{
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	//this function creates an object output stream and writes each object from contactRoll into contact.ser.
	private static void storeData()	{
		ObjectOutputStream output = null;
		try	{
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("contacts.ser")));
		} catch (IOException e)	{
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
		for (Contact c : contactRoll)	{
			try	{
				output.writeObject(c);
			} catch (IOException e)	{
				System.err.println("Error opening file. Terminating.");
				System.exit(1);
			}
		}
		try	{
			if (output != null)
				output.close();
		} catch (IOException e)	{
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}
	
	//This function calls various helper functions above to input name, telephone number, address and date objects in order to create a data object. 
	//Once all of the input is received, a contact is created. Once the contact is created, contactRoll is scanned to determine if the contact is stored
	//in the contact roll already. If not, the length of the array is increased, and this contact is added to the contact roll. 
	public static void addContact()	{
							
		String homeTelephoneNumber = null, workTelephoneNumber = null, cellphoneNumber = null;
		Name name = null;
		Address homeAddress = null, workAddress = null;
		Date dateOfBirth = null;
		Contact contact = null;
		boolean control = true;

		name = scanForName();

		homeTelephoneNumber = scanForHomeTelephoneNumber();
		workTelephoneNumber = scanForWorkTelephoneNumber();
		cellphoneNumber = scanForCellphoneNumber();

		System.out.println("The following details are for the contact's home address.");
		homeAddress = scanForAddress();
		System.out.println("The following detals are for the contact's work address.");
		workAddress = scanForAddress();
		
		dateOfBirth = scanForDateOfBirth();
			
		contact = new Contact(name, homeTelephoneNumber, workTelephoneNumber, cellphoneNumber, homeAddress, workAddress, dateOfBirth);
		
		boolean isDuplicate = false;
		
		if (contactRoll.length > 1)	{
			for (Contact c : contactRoll)	{
				isDuplicate = (c.getName().equals(contact.getName())) && (c.getDateOfBirth().equals(contact.getDateOfBirth()));
				if (isDuplicate)
					break;
			}
		}

		if (isDuplicate)
			System.out.println("The contact details you are adding have already been saved. Try updating the contact.");
		else	{
				increaseArrayLength();
				contactRoll[contactRoll.length-1] = contact;
			}
				System.out.println("Contact saved to the data structure successfully. Operation terminated.");
	}

	//This function initialises a scanner, accepts two Strings, constructs a Name object and then iterates over the contactRoll to determine if a contact item
	//with the Name object created is stored in the contactRoll[]. If not, the function reports that no contact with the specified name is stored. If yes, the
	//function sets the contactRoll[index] to null, reduces the size of the array and exits the function.  
	public static void deleteContact()	{
		int tempIndex = 0;
		boolean control = true;
		String firstName = null, lastName = null;
		Name name = null;
		name = scanForName();
		tempIndex = search(name);
		if (tempIndex == -1)
			System.out.println("No record found of referenced contact.");
		else	{
			int i = tempIndex;
			for (i = tempIndex; i < contactRoll.length-1; i++)
				contactRoll[i] = contactRoll[i+1];
			contactRoll[contactRoll.length-1] = null;
			decreaseArrayLength();
			System.out.println("Contact deleted successfully.");
		}
	}

	//This function scans for two Strings, constructs a Name object, searches contactRoll[] for the Name object and if found, displays a String representation of
	//the contact. 
	public static void displayContact()	{
		int tempIndex = 0;
		boolean control = true;
		Name name = null;
		name = scanForName();
		tempIndex = search(name);
		System.out.println(tempIndex);
		if (tempIndex == -1)
			System.out.println("There is no record of the refenced contact.");
		else
			System.out.println(contactRoll[tempIndex].toString());
	}
	//This function streams all contacts in contactRoll[] and prints the String representation of each. 
	public static void viewRoll()	{
		for(Contact c : contactRoll)
			System.out.println(c.toString());
	}

	//This function accepts a Name object as input, searches the contactRoll[] and determines where in the contactRoll[] the required contact is. If not found, the
	//function returns a message asserting that no matching contact is found. If found a scanner is initialised, and integer input is accepted which determines 
	//which part of the contact is to be updated. The requisite helper function is called and the necessary set method for contactRoll[i] is called to update 
	//contact. Once updates are done, function exits. 
	public static void updateContact()	{
		Name name = null;
		int tempIndex = 0, controlValue = 0;
		boolean control = true;

		name = scanForName();
		tempIndex = search(name);
		Scanner input = new Scanner(System.in);
		if (tempIndex == -1)
			System.out.println("Name entered does not match any contacts stored.");
		else	{
			control = true;
			while (control)	{
				System.out.println("Enter <1> to update home telephone number, <2> to update work telephone number, <3> to update cellphone number, <4> to update the home address, <5> to update the work address,\n or <6> to cancel.");
				try	{
					controlValue = Integer.parseInt(input.nextLine());
				} catch (NoSuchElementException e)  { 
					System.err.println("No input - please try again.");
				} catch (NumberFormatException e)	{
					System.err.println("Integer input required. Please try again.");
				} catch (IllegalStateException e)	{
					System.err.println("Critical error - scanner closed.");
					System.exit(1);
				}
			
				if (controlValue == 1)	{
					String homeTelephoneNumber = null;
					homeTelephoneNumber = scanForHomeTelephoneNumber();
					contactRoll[tempIndex].setHomeTelephoneNumber(homeTelephoneNumber);
					System.out.println("Home telephone number updated.");
				}
				else if (controlValue == 2)	{
					String workTelephoneNumber = null;
					workTelephoneNumber = scanForWorkTelephoneNumber();
					contactRoll[tempIndex].setWorkTelephoneNumber(workTelephoneNumber);				
					System.out.println("Work telephone number updated.");
				}
				else if (controlValue == 3)	{
					String cellphoneNumber = null;
					cellphoneNumber = scanForCellphoneNumber();
					contactRoll[tempIndex].setCellphoneNumber(cellphoneNumber);
					System.out.println("Cellphone number updated.");
				}
				else if (controlValue == 4)	{
					Address homeAddress = null;
					homeAddress = scanForAddress();
					contactRoll[tempIndex].setHomeAddress(homeAddress);
					System.out.println("Home address updated.");
				}
				else if (controlValue == 5)	{
					Address workAddress = null;
					workAddress = scanForAddress();
					contactRoll[tempIndex].setWorkAddress(workAddress);
					System.out.println("Work address updated.");
				}	
				else if (controlValue == 6)	{
					System.out.println("Updated terminated.");
					control = false;
				}
				else	{
					System.out.println("Invalid input. Please try again.");		
				} 
			}	
		}
	}

	//This function controls the program. It initialises a scanner, calls loadData() to populate contactRoll[], and accepts an integer input. Based on the input, 
	//the various functions are called. The function exits and stores the contents of contactRoll[] in contacts.ser. 
	public static void main(String[] args)	{ 
		loadData();
		int controlValue = 0;
		boolean control = true;
		Scanner input = new Scanner(System.in);
		while (control)	{
			System.out.println("Enter <1> to add a contact, <2> to search for and view a contact, <3> to search for and delete a contact, <4> to display all contacts, <5> to update a contact,\nor any other integer to exit.");
			try	{
				controlValue = Integer.parseInt(input.nextLine());
			}
			catch (NumberFormatException e)	{
				System.err.println("Integer input required. Please try again.");
				input.nextLine();
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input - please try agin.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner closed.");
				System.exit(1);
			}
			if (controlValue == 1)
				addContact();
			else if (controlValue == 2)
				displayContact();
			else if (controlValue == 3)
				deleteContact();
			else if (controlValue == 4)
				viewRoll();
			else if (controlValue == 5)
				updateContact();
			else	{
				control = false;
				storeData();
			}
		}
		System.out.println("Exit option selected. Program terminated.");
		System.exit(0);
	}
}
