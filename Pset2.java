class Pset2 {
	public static void main(String[] args) {
		String name = "Andrew Pham";
		String date = "September 7th 2024";

		System.out.println(name + " " + date);
		System.out.println(" ");
        System.out.println(" ");


        int students = 9;

        students = ++students;
        System.out.println("A new student has enrolled in the class");
       	System.out.println(students);

       	if (students < 4) {
       		System.out.println("class is cancelled");
       		}
       
       	int andrew = 6;

       	if (students - andrew < 4) {
       		System.out.println("class is cancelled");
       		}
     
     	boolean equal;


        if (students % 3 == 0) {
            equal = true;
        	}

     	else {
     		equal = false;
     		}

       	 	
       	if (equal == true) {
       		System.out.println(students / 3);
       		}
       	if (equal == false) {
       		System.out.println(students % 3);
       		}

    }
}



