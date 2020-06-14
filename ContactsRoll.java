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

	private static int index = 0;
	private static Contact[] contactRoll = new Contact[index+1];
	private static boolean control = true;
	private static ObjectOutputStream output;
	private static ObjectInputStream input;

	private static void openFile()	{
		try	{
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("contacts.ser")));
			input = new ObjectInputStream(Files.newInputStream(Paths.get("contacts.ser")));
		}
		catch (IOException e)	{
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	private static void closeFile()	{
		try	{
			if (output != null)
				output.close();
			if (input != null)
				input.close();
		}
		catch	(IOException ioException)	{
			System.err.println("Error closing file. Terminating.");
			System.exit(1);
		}
	}

	private static void readFile()	{
		try	{
			while (true)	{
				Contact contact = (Contact) input.readObject();
				contactRoll[index++] = contact;
			}
		}
		catch (EOFException e)	{
			;
		}
		catch (ClassNotFoundException e)	{
			System.err.println("Invalid object type. Terminating.");
			System.exit(1);
		}
		catch (IOException e)	{
			System.err.println("Error reading from file. Terminating.");
			System.exit(1);
		}
	}

	private static int search(Contact[] contactArray, Name name)	{
		Arrays.sort(contactArray);
		int tempIndex = Arrays.binarySearch(contactArray, name);
		return tempIndex;
	}

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

	private static Address scanForAddress()	{
		Address address = null;
		String roadName = null, roadType = null, suburb = null, city = null, province = null, postalCode = null;
		int houseNumber = 0;
		boolean control = true;
		Scanner input = new Scanner(System.in);
		
		while (control)	{
			System.out.println("Enter the house number of the contact's address, followed by <Enter>.");
			try	{	
				houseNumber = Integer.parseInt(input.nextLine());
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
			System.out.println("Enter the road name of the contact's address, followed by <Enter>.");
			try	{
				roadName = input.nextLine();
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
		System.out.println("Enter the road type of the contact's address, followed by <Enter>.");
			try	{
				roadType = input.nextLine();
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
	
		address = new Address(houseNumber, roadName, roadType, suburb, city, province, postalCode);
		return address;
	}

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

	private static void increaseArraySize()	{

		if (contactRoll[0] == null)
			;
		else	{	
			int i = 0;
			Contact[] tempArray = new Contact[contactRoll.length];
			for (i = 0; i < contactRoll.length; i++)
				tempArray[i] = contactRoll[i];
			contactRoll = new Contact[tempArray.length+1];
			for (i = 0; i < contactRoll.length; i++)
				contactRoll[i] = tempArray[i];
		}	
	}

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
		
		if (index > 0)	{
			for (Contact c : contactRoll)	{
				isDuplicate = (c.getName().equals(contact.getName())) && (c.getDateOfBirth().equals(contact.getDateOfBirth()));
				if (isDuplicate)
					break;
			}
		}

		if (isDuplicate)
			System.out.println("The contact details you are adding have already been saved. Try updating the contact.");
		else	{
				increaseArraySize();
				contactRoll[index++] = contact;
				try	{
					output.writeObject(contact);
				}
				catch (IOException e)	{
					System.err.println("Error writing to file. Terminating.");
					System.exit(1);
				}
				System.out.println("Contact saved to the data structure successfully. Operation terminated.");
		}
	}

	public static void deleteContact()	{
		int tempIndex = 0;
		boolean control = true;
		String firstName = null, lastName = null;
		Name name = null;
		Scanner input = new Scanner(System.in);
		
		while (control)	{
			System.out.println("Enter the last name followed by <Enter>.");
			try	{
				lastName = input.nextLine();
				control = false;
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner closed.");
				System.exit(1);
			}
		}

		while (control)	{
			System.out.println("Enter the first name, followed by <Enter>.");
			try	{
				firstName = input.nextLine();
				control = false;
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input. Please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner closed.");
				System.exit(1);
			}
		}
		name = new Name(firstName, lastName);
		
		tempIndex = search(contactRoll, name);
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

	public static void displayContact()	{
		int tempIndex = 0;
		boolean control = true;
		String firstName = null, lastName = null;
		Name name = null;
		Scanner input = new Scanner(System.in);
		
		while (control)	{
			System.out.println("Enter the last name followed by <Enter>.");
			try	{
				lastName = input.nextLine();
				control = false;
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input - please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner closed.");
				System.exit(1);
			}
		}

		while (control)	{
			System.out.println("Enter the first name, followed by <Enter>.");
			try	{
				firstName = input.nextLine();
				control = false;
			}
			catch (NoSuchElementException e)	{
				System.err.println("No input - please try again.");
			}
			catch (IllegalStateException e)	{
				System.err.println("Critical error - scanner closed.");
				System.exit(1);
			}
		}
		name = new Name(firstName, lastName);
		
		Arrays.sort(contactRoll);
		tempIndex = search(contactRoll, name);
		if (tempIndex == -1)
			System.out.println("There is no record of the refenced contact.");
		else
			System.out.println(contactRoll[tempIndex].toString());
	}

	public static void viewRoll()	{
		for(Contact c : contactRoll)
			System.out.println(c.toString());
	}

	public static void updateContact()	{
		Name name = null;
		int tempIndex = 0, controlValue = 0;
		boolean control = true;

		name = scanForName();
		Arrays.sort(contactRoll);
		tempIndex = search(contactRoll, name);
		Scanner input = new Scanner(System.in);
		while (control)	{
			}
		if (tempIndex == -1)
			System.out.println("Name entered does not match any contacts stored.");
		else	{
			control = true;
			while (control)	{
				System.out.println("Enter <1> to update home telephone number, <2> to update work telephone number, <3> to update cellphone number, <4> to update the home address, <5> to update the work address, or any other integer to cancel.");
				try	{
					controlValue = Integer.parseInt(input.nextLine());
					control = false;
				} catch (NoSuchElementException e)  { 
					System.err.println("No input - please try again.");
				} catch (NumberFormatException e)	{
					System.err.println("Integer input required. Please try again.");
				} catch (IllegalStateException e)	{
					System.err.println("Critical error - scanner closed.");
					System.exit(1);
				}
		
				if (controlValue == 1)	{
					contactRoll[tempIndex].setHomeTelephoneNumber(scanForHomeTelephoneNumber());
					try	{
						output.writeObject(contactRoll[tempIndex]);
					} catch (IOException e)	{
						System.err.println("Error writing to file. Terminating.");
						System.exit(1);
					}	
				}
				else if (controlValue == 2)	{
					contactRoll[tempIndex].setWorkTelephoneNumber(scanForWorkTelephoneNumber());
					try	{
						output.writeObject(contactRoll[tempIndex]);
					} catch (IOException e)	{
						System.err.println("Error writing to file. Terminating.");
						System.exit(1);
					}

				}
				else if (controlValue == 3)	{
					contactRoll[tempIndex].setCellphoneNumber(scanForCellphoneNumber());
					try	{
						output.writeObject(contactRoll[tempIndex]);
					} catch (IOException e)	{
						System.err.println("Error writing to file. Terminating.");
						System.exit(1);
					}
				
				}
				else if (controlValue == 4)	{
					contactRoll[tempIndex].setHomeAddress(scanForAddress());
					try	{
						output.writeObject(contactRoll[tempIndex]);
					} catch (IOException e)	{
						System.err.println("Error writing to file. Terminating.");
						System.exit(1);
					}
				}
				else if (controlValue == 5)	{
					contactRoll[tempIndex].setWorkAddress(scanForAddress());
					try	{
						output.writeObject(contactRoll[tempIndex]);
					} catch (IOException e)	{
						System.err.println("Error writing to file. Terminating.");
						System.exit(1);
					}
				}
				else	{
					System.out.println("Invalid input. Update terminated.");
					control = false;		
				}
			}	
		}
	}

	public static void main(String[] args)	{
		openFile(); 
		readFile();
		int controlValue = 0;
		boolean control = true;
		Scanner input = new Scanner(System.in);
		while (control)	{
			System.out.println("Enter <1> to add a contact, <2> to search for and view a contact, <3> to search for and delete a contact, <4> to display all contacts, or any other integer to exit.");
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
				closeFile();
			}
		}
		System.out.println("Exit option selected. Program terminated.");
		System.exit(0);
	}
}
