import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Hotel_MatthewThornton {
	public static void main(String[] args) {
		try {

			// collection of guest families
			// array version
			 Guests[] disney2 = new Guests[34]; 
			 
			// ArrayList<Guests> disney = new ArrayList<Guests>();
			String primaryFamilyMembersName = null;
			String streetAddress = null;
			String city = null;
			String state = null;
			int numberOfGuests = -1;
			String secondGuestName = null;
			String thirdGuestName = null;
			String fourthGuestName = null;

			BufferedReader bf = new BufferedReader(new FileReader("GuestList.txt"));
			String current;
			// while current line is not null
			int roomNumber = 101;

			// continue adding more familes
			while ((current = bf.readLine()) != null) {
				// split by /
				String[] sp = current.split("/");
				// get room number first
				// primaryFamilyMembersName/streetAddress/city/state
				// numberOfGuests/secondGuestName/thirdGuestName
				// Matthew/Thornton/125 Vista Street/Atlyanta, Ga/3/Edward/Nick
				Guests gg = null;
				// 5 + room number
				if (sp.length == 5) {
					primaryFamilyMembersName = sp[0] + " " + sp[1];
					streetAddress = sp[2];
					city = sp[3].split(",")[0];
					state = sp[3].split(",")[1];
					numberOfGuests = Integer.parseInt(sp[4]);

					gg = new Guests(primaryFamilyMembersName, streetAddress, city, state, numberOfGuests, roomNumber);

				}

				else if (sp.length == 6) {
					primaryFamilyMembersName = sp[0] + " " + sp[1];
					streetAddress = sp[2];
					city = sp[3].split(",")[0];
					state = sp[3].split(",")[1];
					numberOfGuests = Integer.parseInt(sp[4]);
					secondGuestName = sp[5];

					gg = new Guests(primaryFamilyMembersName, streetAddress, city, state, numberOfGuests, roomNumber,
							secondGuestName);

				}

				else if (sp.length == 7) {
					primaryFamilyMembersName = sp[0] + " " + sp[1];
					streetAddress = sp[2];
					city = sp[3].split(",")[0];
					state = sp[3].split(",")[1];
					numberOfGuests = Integer.parseInt(sp[4]);
					secondGuestName = sp[5];
					thirdGuestName = sp[6];

					gg = new Guests(primaryFamilyMembersName, streetAddress, city, state, numberOfGuests, roomNumber,
							secondGuestName, thirdGuestName);
				} else if (sp.length == 8) {

					primaryFamilyMembersName = sp[0] + " " + sp[1];
					streetAddress = sp[2];
					city = sp[3].split(",")[0];
					state = sp[3].split(",")[1];
					numberOfGuests = Integer.parseInt(sp[4]);
					secondGuestName = sp[5];
					thirdGuestName = sp[6];
					fourthGuestName = sp[7];

					gg = new Guests(primaryFamilyMembersName, streetAddress, city, state, numberOfGuests, roomNumber,
							secondGuestName, thirdGuestName, fourthGuestName);
				} else {
					System.out.println("line not understood");

				}
				// arrays version
				disney2[roomNumber - 101] = gg;
				
				// add guests to list
				// disney.add(gg);

				// print first value
				// System.out.println(sp[0]);
				roomNumber += 1;
			}
			// arrays version
			for (Guests g : disney2)
			{   
			    System.out.println(g.toString());
			    System.out.println();
			}
			
// 			for (Guests g : disney)
// 			{   
// 			    System.out.println(g.toString());
// 			    System.out.println();
// 			}
			bf.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}