 class Enclosure {

	//these are like "slots " in the enclosure for bears 
	// gonna set it at 6 for now

	Bear bear1;
	Bear bear2;
	Bear bear3;
	Bear bear4;
	Bear bear5;
	Bear bear6;

	// variable is neccessary for enclosure methods 

	int numbears;

	// used for creating enclosure 


	// method for adding bear, basically creates an instance of the bear class if you pass in the slot in the
	// enclosure u want to put it in. also for every animal created it adds to animal count

	public void addbear(int slotnum, String BearName, String BearSpecies, int age) {

			if (slotnum == 1) {
				if (bear1 == null){
				bear1 = new Bear(BearName, BearSpecies, age);
				}

			}

			else if (slotnum == 2){

			    if (bear2 == null) {
				bear2 = new Bear(BearName, BearSpecies, age);
			    }

			}

			else if (slotnum == 3){

			    if (bear3 == null) {
				bear3 = new Bear(BearName, BearSpecies, age);
			    }

			}

			else if (slotnum == 4){

			    if (bear4 == null) {
				bear4 = new Bear(BearName, BearSpecies, age);
			    }

			}

			else if (slotnum == 5){

			    if (bear5 == null) {
				bear5 = new Bear(BearName, BearSpecies, age);
			    }

			}

			else if (slotnum == 6){

			    if (bear6 == null) {
				bear6 = new Bear(BearName, BearSpecies, age);
			    }

			}


			numbears = numbears + 1;
			

	}


	public String getbear(int slotnum){
		if (slotnum == 1 && bear1 != null) {
			return bear1.BearAllInfo();
		}

		else if (slotnum == 2 && bear2 != null) {
			return bear2.BearAllInfo();
		}

		else if (slotnum == 3 && bear3 != null) {
			return bear3.BearAllInfo();
		}

		else if (slotnum == 4 && bear4 != null) {
			return bear4.BearAllInfo();
		}

		else if (slotnum == 5 && bear5 != null) {
			return bear5.BearAllInfo();
		}

		else if (slotnum == 6 && bear6 != null) {
			return bear6.BearAllInfo();
		}

		else {

			return null;
		}






	}



	// simple method to return number of bears 

	public int numberofbears(){
		return numbears;
		}

	//constructor for enclosure method

	Enclosure() {

		bear1 = null;
		bear2 = null;
		bear3 = null;
		bear4 = null;
		bear5 = null;
		bear6 = null;
		numbears = 0;

	}
	


	public static void main(String[] args) {

		Enclosure AndrewEnclosure = new Enclosure();

		AndrewEnclosure.addbear(1, "Winnie the pooh", "Cartoon", 200);
		AndrewEnclosure.addbear(2, "fozzy", "muppet", 40);
		AndrewEnclosure.addbear(3, "smokey", "brown", 56);
		AndrewEnclosure.addbear(4, "ted", "stuffed", 24);

		System.out.println(AndrewEnclosure.numberofbears());
		System.out.println(AndrewEnclosure.getbear(1));
		System.out.println(AndrewEnclosure.getbear(2));
		
		System.out.println(AndrewEnclosure.getbear(3));
		System.out.println(AndrewEnclosure.getbear(4));
		


		
	}
















}