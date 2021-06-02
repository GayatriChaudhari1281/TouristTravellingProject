package projectGraph;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		ClearScreen clear = new ClearScreen();

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(in);

		Scanner sc = new Scanner(System.in);
		AVL a = new AVL(); // creating object of AVL class
		a.create(); // craeting avl tree

		char choice;
		Spot ptr1; // to store address of returing ptr
		String spot; // to store the spot name
		char city; // to store city name

		Graph mumbaiCity = new Graph();
		mumbaiCity.addEdge("FILM CITY", new ConnectingSpot("JUHU BEACH", 13));
		mumbaiCity.addEdge("FILM CITY", new ConnectingSpot("SIDDHIVINAYAK TEMPLE", 18.5));
		mumbaiCity.addEdge("JUHU BEACH", new ConnectingSpot("SIDDHIVINAYAK TEMPLE", 12.2));
		mumbaiCity.addEdge("JUHU BEACH", new ConnectingSpot("CHOWPATTY BEACH", 18.4));
		mumbaiCity.addEdge("CHOWPATTY BEACH", new ConnectingSpot("MUMBADEVI MANDIR", 3));
		mumbaiCity.addEdge("CHOWPATTY BEACH", new ConnectingSpot("JEHANGIR ART GALLERY", 5));
		mumbaiCity.addEdge("CHOWPATTY BEACH", new ConnectingSpot("MARINE DRIVE", 2));
		mumbaiCity.addEdge("MARINE DRIVE", new ConnectingSpot("GATEWAY OF INDIA", 4.4));
		mumbaiCity.addEdge("JEHANGIR ART GALLERY", new ConnectingSpot("CHATTRAPATI SHIVAJI MAHARAJ MUSEUM", 0.45));
		mumbaiCity.addEdge("CHATTRAPATI SHIVAJI MAHARAJ MUSEUM", new ConnectingSpot("MUMBADEVI MANDIR", 4.4));
		mumbaiCity.addEdge("CHATTRAPATI SHIVAJI MAHARAJ MUSEUM", new ConnectingSpot("SIDDHIVINAYAK TEMPLE", 17.3));
		mumbaiCity.addEdge("CHATTRAPATI SHIVAJI MAHARAJ MUSEUM", new ConnectingSpot("ELEPHANTA CAVES", 0.65));
		mumbaiCity.addEdge("CHATTRAPATI SHIVAJI MAHARAJ MUSEUM", new ConnectingSpot("GATEWAY OF INDIA", 0.6));
		mumbaiCity.addEdge("SIDDHIVINAYAK TEMPLE", new ConnectingSpot("MUMBADEVI MANDIR", 14.7));
		mumbaiCity.addEdge("SIDDHIVINAYAK TEMPLE", new ConnectingSpot("ELEPHANTA CAVES", 17.7));

		Graph kolkataCity = new Graph();
		kolkataCity.addEdge("BIRLA MANDIR", new ConnectingSpot("SCIENCE CITY", 6.9));
		kolkataCity.addEdge("BIRLA MANDIR", new ConnectingSpot("KALIGHAT KALI TEMPLE", 3.5));
		kolkataCity.addEdge("BIRLA MANDIR", new ConnectingSpot("ST. PAUL’S CATHEDRAL", 3.5));
		kolkataCity.addEdge("SCIENCE CITY", new ConnectingSpot("INDIAN MUSEUM", 8.2));
		kolkataCity.addEdge("SCIENCE CITY", new ConnectingSpot("DAKSHINESHWAR KALI TEMPLE", 20.6));
		kolkataCity.addEdge("KALIGHAT KALI TEMPLE", new ConnectingSpot("ST. PAUL’S CATHEDRAL", 3));
		kolkataCity.addEdge("ST. PAUL’S CATHEDRAL", new ConnectingSpot("INDIAN MUSEUM", 1.9));
		kolkataCity.addEdge("ST. PAUL’S CATHEDRAL", new ConnectingSpot("VICTORIA MEMORIAL", 0.7));
		kolkataCity.addEdge("INDIAN MUSEUM", new ConnectingSpot("HOWRAH BRIDGE", 4.6));
		kolkataCity.addEdge("INDIAN MUSEUM", new ConnectingSpot("JORASANKO THAKUR BAN", 3.9));
		kolkataCity.addEdge("HOWRAH BRIDGE", new ConnectingSpot("BELUR MATH", 6.3));
		kolkataCity.addEdge("HOWRAH BRIDGE", new ConnectingSpot("JORASANKO THAKUR BAN", 1.8));
		kolkataCity.addEdge("BELUR MATH", new ConnectingSpot("DAKSHINESHWAR KALI TEMPLE", 5));
		kolkataCity.addEdge("BELUR MATH", new ConnectingSpot("JORASANKO THAKUR BAN", 5));
		kolkataCity.addEdge("VICTORIA MEMORIAL", new ConnectingSpot("HOWRAH BRIDGE", 5.4));

		Graph delhiCity = new Graph();
		delhiCity.addEdge("RED FORT", new ConnectingSpot("GANDHI SMRITI & MAHATMA GANDHI MEMORIAL", 2.2));
		delhiCity.addEdge("RED FORT", new ConnectingSpot("GURUDWARA BANGLA SAHIB", 7.5));
		delhiCity.addEdge("GANDHI SMRITI & MAHATMA GANDHI MEMORIAL", new ConnectingSpot("AGRASEN KI BAOLI", 4.2));
		delhiCity.addEdge("GANDHI SMRITI & MAHATMA GANDHI MEMORIAL", new ConnectingSpot("HUMAYUN’S TOMB", 12));
		delhiCity.addEdge("GANDHI SMRITI & MAHATMA GANDHI MEMORIAL", new ConnectingSpot("AKSHARDHAM MANDIR", 10.1));
		delhiCity.addEdge("AGRASEN KI BAOLI", new ConnectingSpot("GURUDWARA BANGLA SAHIB", 2.2));
		delhiCity.addEdge("GURUDWARA BANGLA SAHIB", new ConnectingSpot("NATIONAL MUSEUM", 2.2));
		delhiCity.addEdge("NATIONAL MUSEUM", new ConnectingSpot("INDIA GATE", 1.3));
		delhiCity.addEdge("INDIA GATE", new ConnectingSpot("DILLI HAAT", 7.3));
		delhiCity.addEdge("DILLI HAAT", new ConnectingSpot("HUMAYUN’S TOMB", 3));
		delhiCity.addEdge("DILLI HAAT", new ConnectingSpot("QUTUB MINAR", 7.6));
		delhiCity.addEdge("QUTUB MINAR", new ConnectingSpot("AKSHARDHAM MANDIR", 20));
		delhiCity.addEdge("QUTUB MINAR", new ConnectingSpot("HUMAYUN’S TOMB", 10.8));
		delhiCity.addEdge("HUMAYUN’S TOMB", new ConnectingSpot("AKSHARDHAM MANDIR", 7));

		Graph chennaiCity = new Graph();
		chennaiCity.addEdge("MARINA BEACH", new ConnectingSpot("VALLUR KOTTAM", 5.3));
		chennaiCity.addEdge("MARINA BEACH", new ConnectingSpot("THOUSAND LIGHT MOSQUE", 4.8));
		chennaiCity.addEdge("MARINA BEACH", new ConnectingSpot("DAKSHINCHITRA", 26.3));
		chennaiCity.addEdge("VALLUR KOTTAM", new ConnectingSpot("DAKSHINCHITRA", 29.9));
		chennaiCity.addEdge("THOUSAND LIGHT MOSQUE", new ConnectingSpot("ELLIOT BEACH", 9.3));
		chennaiCity.addEdge("THOUSAND LIGHT MOSQUE", new ConnectingSpot("GUINDY NATIONAL PARK", 9.0));
		chennaiCity.addEdge("ELLIOT BEACH", new ConnectingSpot("DAKSHINCHITRA", 28.1));
		chennaiCity.addEdge("ELLIOT BEACH", new ConnectingSpot("ASHTALAKSHMI TEMPLE", 1.4));
		chennaiCity.addEdge("DAKSHINCHITRA", new ConnectingSpot("MYLAPORE", 25.7));
		chennaiCity.addEdge("ASHTALAKSHMI TEMPLE", new ConnectingSpot("MYLAPORE", 8.7));
		chennaiCity.addEdge("ASHTALAKSHMI TEMPLE", new ConnectingSpot("GOVERNMENT MUSEUM", 31.0));
		chennaiCity.addEdge("GOVERNMENT MUSEUM", new ConnectingSpot("GUINDY NATIONAL PARK", 9.5));
		chennaiCity.addEdge("GUINDY NATIONAL PARK", new ConnectingSpot("MGR FILM CITY", 5.8));
		chennaiCity.addEdge("MGR FILM CITY", new ConnectingSpot("MYLAPORE", 8.5));

		System.out.println("\t\t\t\t\t!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!");
		System.out.println("\n\t\t\t\t\t                         विश्वयात्री");
		System.out.println("\n\t\t\t\t\t                               ~आपका तकनीकी संदर्शक");

		System.out.println("\n\t\t\t\t\t!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!\n");

		char ch;
		do {
			
			System.out.println(
					"\n\t\t\t\t\t===========================================================================\n");
			System.out.println("\t\t\t\t\t                                 MAIN MENU");
			System.out
					.println("\n\t\t\t\t\t==========================================================================");
			System.out.println(
					"\n\n\t\t\t\t\t--------------------------------ADVISOR------------------------------------");
			System.out
					.println("\n\t\t\t\t\t  ? --> Plan your next tour by exploring cities and their intersting spots");
			System.out.println("\t\t\t\t\t  @ --> Get the detailed information of all the packages that we offer");
			System.out.println("\n\t\t\t\t\t-------------------------------------------------------------------------");
			System.out.println(
					"\n\n\t\t\t\t\t---------------------------------GUIDER-------------------------------------");
			System.out.println("\n\t\t\t\t\t Select the city you are in to avail our guider facilitites");
			System.out.println("\t\t\t\t\t---------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t  D -->Delhi");
			System.out.println("\t\t\t\t\t  M -->Mumbai");
			System.out.println("\t\t\t\t\t  K -->Kolkata");
			System.out.println("\t\t\t\t\t  C -->Chennai");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------");
			System.out.println("\n\t\t\t\t\t  X -->EXIT");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------");
			
			do {
				System.out.println("\n\t\t\t\t\t  Enter your choice");
				System.out.print("\t\t\t\t\t  --->");
				ch = (char) buf.read();// Accepting the choice from the user
				buf.readLine();
				if (!(ch == 'D') && !(ch == 'M') && !(ch == 'K') && !(ch == 'C')&& !(ch == '@') && !(ch == '?') && !(ch == 'X')) {
					{
						System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
						System.out.println("\n\t\t\t\t\t\t\t\t!!!***INVALID INPUT***!!!\n");
						System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
					}
				}
			} while (!(ch== 'D') && !(ch == 'M') && !(ch == 'K') && !(ch == 'C')&& !(ch == '@') && !(ch == '?') && !(ch == 'X'));
			
			System.out
					.println("\n\t\t\t\t\t---------------------------------------------------------------------------");
			switch (ch) {

			case '?': {
				clear.clearScreen();
				do {
					System.out.println("\n\t\t\t\t\t S --> Search a Spot and get its details");
					System.out.println("\n\t\t\t\t\t C --> Search all Spots in particular city");
					System.out.println("\n\t\t\t\t\t X --> EXIT");
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");
					System.out.print("\n\t\t\t\t\tEnter your choice from above list : ");
					choice = sc.next().charAt(0);
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");
					switch (choice) {
					case 'S':
						clear.clearScreen();
						if (a.root == null) {
							System.out.println("List is empty\n");
							System.out.println(
									"\n\t\t\t\t\t---------------------------------------------------------------------------");
						} else {
							System.out.print("\t\t\t\t\tEnter spot name: ");
							System.out.print("\n\n\t\t\t\t\t\t  --->");
							sc.nextLine();
							spot = sc.nextLine();
							System.out.println(
									"\n=========================================================================================================================================================================================\n");
							ptr1 = a.searchSpot(spot);
							try {
								File myObj = new File("E:\\SpotHistory\\" + ptr1.info + ".txt"); // file object
																									// represents the
																									// file path on disk
								Scanner myReader = new Scanner(myObj); // object of scanner class read the data from
																		// file object
								while (myReader.hasNextLine()) { // it will traverse one by one line from file
									String data = myReader.nextLine();
									System.out.println("\t\t\t\t\t " + data); // printing one by one line
								}
								myReader.close(); // object close
								System.out.println(
										"\n======================================================================================================================================================================================\n");
							} catch (FileNotFoundException e) { // if file not found
								System.out.println("File Not Found\n");
								System.out.println(
										"\t\t\t\t\t============================================================================================================================================================================\n");
							} catch (NullPointerException e) { // if null is returned
								System.out.println("\t\t\t\t\t\t\tSpot Not Found\n");
								System.out.println(
										"\n=============================================================================================================================================================================\n");
							}
							System.out.println();
						}
						break;
					case 'C':
						clear.clearScreen();
						if (a.root == null) {
							System.out.println("List is empty\n");
						}
						System.out.println("\n\t\t\t\t\tSelect the city whose spots you wish to explore");
						System.out.println(
								"\t\t\t\t\t---------------------------------------------------------------------------");
						System.out.println("\t\t\t\t\t  D -->Delhi");
						System.out.println("\t\t\t\t\t  M -->Mumbai");
						System.out.println("\t\t\t\t\t  K -->Kolkata");
						System.out.println("\t\t\t\t\t  C -->Chennai");
						System.out.println(
								"\n\t\t\t\t\t-------------------------------------------------------------------------");
						System.out.print("\n\t\t\t\t\tEnter city name from above list: ");

						do {
							sc.nextLine();
							city = sc.next().charAt(0); // city to store city name
							if (!(city == 'D') && !(city == 'M') && !(city == 'K') && !(city == 'C')) {
								System.out.print("\n\t\t\t\t\tINVALID INPUT!!! Kindly enter correct Option :");
							}
						} while (!(city == 'D') && !(city == 'M') && !(city == 'K') && !(city == 'C'));
						switch (city) {
						case 'D': {
							clear.clearScreen();

							System.out.println(
									"\n----------------------------------------------------------------------------------WELCOME TO DELHI------------------------------------------------------------------------------------------------------\n");
							a.searchCity("Delhi", a.root);// calling searchCity function
							System.out.println(
									"\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						}
							break;
						case 'M':
							clear.clearScreen();
							System.out.println(
									"\n---------------------------------------------------------------------------------WELCOME TO MUMBAI--------------------------------------------------------------------------------------------------\n");
							a.searchCity("Mumbai", a.root);// calling searchCity function
							System.out.println(
									"\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
							break;
						case 'K':
							clear.clearScreen();
							System.out.println(
									"\n---------------------------------------------------------------------------------WELCOME TO KOLKATA--------------------------------------------------------------------------------------------------------------\n");
							a.searchCity("Kolkata", a.root);// calling searchCity function
							System.out.println(
									"\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
							break;
						case 'C':
							clear.clearScreen();

							System.out.println(
									"\n---------------------------------------------------------------------------------WELCOME TO CHENNAI--------------------------------------------------------------------------------------------------------------------\n");
							a.searchCity("Chennai", a.root);// calling searchCity function
							System.out.println(
									"\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
							break;
						default:
							System.out.println("\t\t\t\t\t!!!***INVALID INPUT***!!!");
							System.out.println(
									"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
							break;
						}
						break;
					case 'X':
						System.out.println(
								"\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						break;
					default:
						System.out.println("\t\t\t\t\t\t\t\t!!!***INVALID INPUT***!!!");
						System.out.println(
								"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						break;
					}

				} while (choice != 'X');
				clear.clearScreen();
			}
				break;

			case '@': {

				clear.clearScreen();
				ArrayList<String> virt_tour_city = null; // variable to store bfs sequence of spots in a city
				double pack_cost = 0; // variable to store cost of a package
				String pack_name = ""; // variable to store name of package
				char city_ch; // variable to store city choice of user
				// do while loop to drive the @ sub menu
				do {
					clear.clearScreen();
					System.out.println(
							"\n\t\t\t\t\t============================================================================\n");
					System.out.println("\t\t\t\t\t                   Pick a city to view the Sponsored Packages");
					System.out.println(
							"\n\t\t\t\t\t==============================================================================");
					System.out.println("\t\t\t\t\t  D -->Delhi");
					System.out.println("\t\t\t\t\t  M -->Mumbai");
					System.out.println("\t\t\t\t\t  K -->Kolkata");
					System.out.println("\t\t\t\t\t  C -->Chennai");
					System.out.println("\t\t\t\t\t  X -->GO BACK TO MAIN MENU");
					System.out.println(
							"\n\t\t\t\t\t------------------------------------------------------------------------------");
					System.out.println("\n\t\t\t\t\t  Enter your choice");
					System.out.print("\t\t\t\t\t  --->");
					do {
						
						city_ch = sc.next().charAt(0); // city to store city name
						sc.nextLine();
						if (!(city_ch == 'D') && !(city_ch == 'M') && !(city_ch == 'K') && !(city_ch == 'C')&& !(city_ch == 'X')) {
							System.out.print("\n\t\t\t\t\tINVALID INPUT!!! Kindly enter correct Option :");
						}
					} while (!(city_ch == 'D') && !(city_ch == 'M') && !(city_ch == 'K') && !(city_ch == 'C')&& !(city_ch == 'X'));
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");
					// switch case to handle user choice

					switch (city_ch) {
					case 'D':
					case 'd':

						virt_tour_city = delhiCity.bfs("RED FORT");
						pack_cost = (delhiCity.MST_ByPrims("RED FORT"));
						pack_name = "\n\t\t\t\t\t\\|/\\|/....DILLI HINDUSTAN KI Sponsored by BALMER LAWRIE TOURS & TRAVELS ....\\|/\\|/\n";
						break;
					case 'M':
					case 'm':

						virt_tour_city = mumbaiCity.bfs("FILM CITY");
						pack_cost = mumbaiCity.MST_ByPrims("FILM CITY");
						pack_name = "\n\t\t\t\t\t\\|/\\|/....SWAPNANCHI MAYANAGRI Sponsored by MUMBAI DARSHAN TOURS & TRAVELS ....\\|/\\|/\n";
						break;
					case 'K':
					case 'k':

						virt_tour_city = kolkataCity.bfs("SCIENCE CITY");
						pack_cost = kolkataCity.MST_ByPrims("SCIENCE CITY");
						pack_name = "\n\t\t\t\t\t\\|/\\|/....KOLKATA MISHTIDOI Sponsored by WESTERN TOURS & TRAVELS ....\\|/\\|/\n";
						break;
					case 'C':
					case 'c':

						virt_tour_city = chennaiCity.bfs("GOVERNMENT MUSEUM");
						pack_cost = chennaiCity.MST_ByPrims("GOVERNMENT MUSEUM");
						pack_name = "\n\t\t\t\t\t\\|/\\|/....MADRAS ARUMAI Sponsored by TRINITY TOURS & TRAVELS ....\\|/\\|/\n";
						break;
					case 'X':
						virt_tour_city = null;
						break;
					default: {
						virt_tour_city = null;
						System.out.println("\t\t\t\t\t!!!***INVALID INPUT***!!!");
					}
					}// switch ends here
						// If user selected a valid city
					if (virt_tour_city != null) {
						System.out.println(
								"\n====================================================================================================================================================================================================================================================================");
						System.out.println(
								"\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/");
						System.out.println(
								"/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\");
						System.out.println(
								"====================================================================================================================================================================================================================================================================");

						pack_cost = pack_cost * 250;
						System.out.println(
								"\t\t\t\t\t=======================================================================");
						System.out.println("\t\t\t\t\t\t           ***THE COST PER KM IS Rs.250***");
						System.out.println(
								"\t\t\t\t\t\t     " + pack_name + "\t\t\t\t\t\t\tCost of Package: " + pack_cost);
						System.out.println("\n\t\t\t\t\t\tLocations that will be a part of the itinerary:\n");
						// for loop to display all locations in package
						for (int i = 0; i < virt_tour_city.size(); i++) {
							System.out.println(
									"\t\t\t\t\t-------|-------------------------------------------------------------|-------");
							System.out.println("\t\t\t\t\t\t          " + virt_tour_city.get(i));
						}
						System.out.println(
								"\t\t\t\t\t-------|-------------------------------------------------------------|-------");

						System.out.println(
								"\n====================================================================================================================================================================================================================================================================");
						System.out.println(
								"\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/");
						System.out.println(
								"/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\");
						System.out.println(
								"====================================================================================================================================================================================================================================================================");
						System.out.print("Enter 0 to return back and view other packages :");
						int exit1;
						do {
							exit1 = sc.nextInt();
							if (exit1 != 0)
								System.out.print("INVALID INPUT!!! Enter 0 to return back and view other packages :");
						} while (exit1 != 0);
					}
				} while (city_ch != 'X');
				clear.clearScreen();
			}
				break;

			case 'D': {
				clear.clearScreen();
				int in_ch;
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");
				System.out.println("\t\t\t\t\t                         दिल्ली");
				System.out.println("\t\t\t\t\t                              ~जो है इस देश की धड़कन");

				do {
					System.out.println(
							"\n\t\t\t\t\t============================================================================\n");
					System.out.println("\t\t\t\t\t                                        MENU");
					System.out.println(
							"\n\t\t\t\t\t==============================================================================");
					System.out.println(
							"\t\t\t\t\t  1--> Tell us your current location and get to know the shortest distance to all other spots");
					System.out.println("\t\t\t\t\t  2--> Explore all the spots within the required range");
					System.out.println("\t\t\t\t\t  3--> Return back to main menu");
					System.out.println(
							"\n\t\t\t\t\t------------------------------------------------------------------------------");
					System.out.println("\n\t\t\t\t\t  Enter your choice");
					System.out.print("\t\t\t\t\t  --->");
					
					do {
						
						in_ch = Integer.parseInt(buf.readLine());
						if (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) ) {
							System.out.print("\n\t\t\t\t\tINVALID INPUT!!! Kindly enter correct Option :");
						}
					} while (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) );
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");
					switch (in_ch) {

					case 1:
						delhiCity.shortCutDisplayer("DELHI", 0);
						clear.clearScreen();
						break;
					case 2:
						delhiCity.shortCutDisplayer("DELHI", 1);
						clear.clearScreen();
						break;
					case 3:
						break;
			
					}// switch ends here

				} while (in_ch != 3);// do-while ends here
				clear.clearScreen();
			}
				break;

			case 'M': {
				clear.clearScreen();
				int in_ch;
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");
				System.out.println("\t\t\t\t\t\t                           मुंबई");
				System.out.println("\t\t\t\t\t\t                                 ~जहां सृजनात्मकता ही आचरण है");
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");

				do {
					System.out.println(
							"\n\t\t\t\t\t============================================================================\n");
					System.out.println("\t\t\t\t\t                                        MENU");
					System.out.println(
							"\n\t\t\t\t\t==============================================================================");
					System.out.println(
							"\t\t\t\t\t  1--> Tell us your current location and get to know the shortest distance to all other spots");
					System.out.println("\t\t\t\t\t  2--> Explore all the spots within the required range");
					System.out.println("\t\t\t\t\t  3--> Return back to main menu");
					System.out.println(
							"\n\t\t\t\t\t------------------------------------------------------------------------------");
					System.out.println("\n\t\t\t\t\t  Enter your choice");
					System.out.print("\t\t\t\t\t  --->");
					do {
						
						in_ch = Integer.parseInt(buf.readLine());
						if (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) ) {
							System.out.print("\n\t\t\t\t\tINVALID INPUT!!! Kindly enter correct Option :");
						}
					} while (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) );
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");
					switch (in_ch) {

					case 1:
						mumbaiCity.shortCutDisplayer("MUMBAI", 0);
						clear.clearScreen();
						break;
					case 2:
						mumbaiCity.shortCutDisplayer("MUMBAI", 1);
						clear.clearScreen();
						break;
					case 3:
						break;
					
					}// switch ends here

				} while (in_ch != 3);// do-while ends here
				clear.clearScreen();
			}
				break;

			case 'K': {
				clear.clearScreen();
				int in_ch;
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");
				System.out.println("\t\t\t\t\t                            कोलकाता");
				System.out.println(
						"\t\t\t\t\t\t                                ~जहां से आज़ादी की पुकार ने कई शूरवीरों को जन्मा");
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");
				do {
					System.out.println(
							"\n\t\t\t\t\t============================================================================\n");
					System.out.println("\t\t\t\t\t                                        MENU");
					System.out.println(
							"\n\t\t\t\t\t==============================================================================");
					System.out.println(
							"\t\t\t\t\t  1--> Tell us your current location and get to know the shortest distance to all other spots");
					System.out.println("\t\t\t\t\t  2--> Explore all the spots within the required range");
					System.out.println("\t\t\t\t\t  3--> Return back to main menu");
					System.out.println(
							"\n\t\t\t\t\t------------------------------------------------------------------------------");
					System.out.println("\n\t\t\t\t\t  Enter your choice");
					System.out.print("\t\t\t\t\t  --->");
					do {
						
						in_ch = Integer.parseInt(buf.readLine());
						if (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) ) {
							System.out.print("\n\t\t\t\t\tINVALID INPUT!!! Kindly enter correct Option :");
						}
					} while (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) );
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");

					switch (in_ch) {

					case 1:
						kolkataCity.shortCutDisplayer("KOLKATA", 0);
						clear.clearScreen();
						break;
					case 2:
						kolkataCity.shortCutDisplayer("KOLKATA", 1);
						clear.clearScreen();
						break;
					case 3:
						break;
					
					}// switch ends here

				} while (in_ch != 3);// do-while ends here
				clear.clearScreen();
			}
				break;

			case 'C': {
				clear.clearScreen();
				int in_ch;
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");
				System.out.println("\t\t\t\t\t                               चेन्नई ");
				System.out.println("\t\t\t\t\t\t                                ~जहां संग्रहित है भारत की प्राचीनता");
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");
				do {
					System.out.println(
							"\n\t\t\t\t\t============================================================================\n");
					System.out.println("\t\t\t\t\t                                        MENU");
					System.out.println(
							"\n\t\t\t\t\t==============================================================================");
					System.out.println(
							"\t\t\t\t\t  1--> Tell us your current location and get to know the shortest distance to all other spots");
					System.out.println("\t\t\t\t\t  2--> Explore all the spots within the required range");
					System.out.println("\t\t\t\t\t  3--> Return back to main menu");
					System.out.println(
							"\n\t\t\t\t\t------------------------------------------------------------------------------");
					System.out.println("\n\t\t\t\t\t  Enter your choice");
					System.out.print("\t\t\t\t\t  --->");
					do {
						
						in_ch = Integer.parseInt(buf.readLine());
						if (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) ) {
							System.out.print("\n\t\t\t\t\tINVALID INPUT!!! Kindly enter correct Option :");
						}
					} while (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) );
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");

					switch (in_ch) {

					case 1:
						chennaiCity.shortCutDisplayer("CHENNAI", 0);
						clear.clearScreen();
						break;
					case 2:
						chennaiCity.shortCutDisplayer("CHENNAI", 1);
						clear.clearScreen();
						break;
					case 3:
						break;
					
					}// switch ends here

				} while (in_ch != 3);// do-while ends here
				clear.clearScreen();
			}
				break;
			case 'X':
				break;
					
			}// switch ends here

			
		} while (ch != 'X');// do-while ends here
		
		
		/*
		 * ____________________________TIMER CODE BEGINS
		 * HERE____________________________
		 */
		clear.clearScreen();
		System.out
				.println("\n\t\t\t\t\t============================================================================\n");
		System.out.println("\t\t\t\t\t           SELECT YOUR FAVOURITE CITY TO GO ON OUR SPECIAL VIRTUAL TOUR");
		System.out
				.println("\n\t\t\t\t\t==============================================================================");
		System.out.println("\t\t\t\t\t  1 -->Delhi");
		System.out.println("\t\t\t\t\t  2 -->Mumbai");
		System.out.println("\t\t\t\t\t  3 -->Kolkata");
		System.out.println("\t\t\t\t\t  4 -->Chennai");
		System.out.println("\t\t\t\t\t  0 -->EXIT");
		System.out
				.println("\n\t\t\t\t\t------------------------------------------------------------------------------");
		System.out.println("\n\t\t\t\t\t  Enter your choice");
		System.out.print("\t\t\t\t\t  --->");
		int final_ch = Integer.parseInt(buf.readLine());
		ArrayList<String> traversal = null;

		switch (final_ch) {
		case 1:
			traversal = delhiCity.bfs("INDIA GATE");
			break;
		case 2:
			traversal = mumbaiCity.bfs("FILM CITY");
			break;
		case 3:
			traversal = kolkataCity.bfs("HOWRAH BRIDGE");
			break;
		case 4:
			traversal = chennaiCity.bfs("MGR FILM CITY");
			break;
		case 0:
			clear.clearScreen();
			System.out.println("\t\t\t\t\t          ****ViSwaYatri wishes you a safe journey ahead!****");
			System.exit(0);

		}
		clear.clearScreen();
		System.out.println("\n\t\t\t\t\t\tYour mini tour will start in few moments......\n");
		Timer timer = new Timer();
		TimerTask task = new Tour_Feel(traversal);
		timer.schedule(task, 3000, 4500);

		/* ___________________________TIMER ENDS HERE_______________________________ */

	}// main method ends here
}// Main class ends here
