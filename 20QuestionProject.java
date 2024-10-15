import java.util.*;
class TwentyQuestions{

        //string array of all possible answers
        //String[] pa = new String[]
        //booleans
        Boolean plant = false;

        Boolean mammal = false;
      
        Boolean tree = false ;
     
        Boolean input = false;

        //answer
        String ans = "";

        //arraylist of possible answer
        ArrayList<String> a = new ArrayList<String>();


        int qa = 0;
        String[] pa = {"fish", "snake", "bear", "monkey", "sunflower", "grass", "apple tree", "pine tree"};
        String q = "";
        String playagain = "yes";





 


 
    public TwentyQuestions() {

        
        //arraylist of possible answer
        for (String i: pa){
            a.add(i);
        }
        




    }
    public String askQuestion() {
        if (qa == 0){
            q = "Is it a Plant?";
    
    
        } 

        else if (qa == 1) {
            if (a.contains("monkey") && a.contains("bear") && a.contains("snake") && a.contains("fish")){
                q = "is it a mamall";
        
            }
            else if (a.contains("sunflower") && a.contains("grass") && a.contains("pine tree") && a.contains("apple tree")) {
                q = "is it a tree?";
             
         
            }

        }

        else if (qa == 2) {
            if (a.contains("monkey") && a.contains("bear")){
                q = "does it eat bananas?";
        
     
            }

            else if (a.contains("fish") && a.contains("snake")){
                q = "does it live in the water?";
 
     
            }

            else if (a.contains("sunflower") && a.contains("grass")){
                q = "is it tall";
      
    
            }
            else if (a.contains("pine tree") && a.contains("apple tree")){
                q = "does it have fruit";
             
            }

        }

        







        return q;

    }
    public void updateAnswers(){
        if (qa == 0){
            if (input == true){
                a.remove("snake");
                a.remove("fish");
                a.remove("monkey");
                a.remove("bear");
                
                plant = true;


            }
            else if (input == false){
                a.remove("sunflower");
                a.remove("grass");
                a.remove("apple tree");
                a.remove("pine tree");
                
                plant = false;

            }

        }

        else if (qa == 1){
            if (input == true && plant == true){
                a.remove("sunflower");
                a.remove("grass");
                tree = true;
            }

            else if (input == false && plant == true){
                a.remove("apple tree");
                a.remove("pine tree");
                tree = false;
            }

            else if (input == true && plant == false){
                a.remove("snake");
                a.remove("fish");
                mammal = true;

            }

            else if (input == false && plant == false){
                a.remove("monkey");
                a.remove("bear");
                mammal = false;
            }
        }
        else if (qa == 2){
                if (input == true && mammal == true){
                    a.remove("bear");
                }
                else if (input == false && mammal == true){
                    a.remove("monkey");
                }
                else if (input == true && mammal == false){
                    a.remove("snake");
                }
                else if (input == true && mammal == false){
                    a.remove("fish");
                }
                else if (input == true && tree == true){
                    a.remove("pine tree");
                }
                else if (input == false && tree == true){
                    a.remove("apple tree");
                }
                else if (input == true && tree == false){
                    a.remove("grass");
                }
                else if (input == false && tree == false){
                    a.remove("sunflower");

                }   
            }

            qa++;
        }

    public String guess(){
        ans = "it is a " + a.get(0) + "!";
        return ans;    
    }
        
        



public static void main(String[] args) {
    boolean playing = true;
    Scanner s = new Scanner(System.in);
    TwentyQuestions game = new TwentyQuestions();


    while (playing == true){
    
    
        System.out.println("Choose an organism from the following list and I will guess");
        System.out.println("Fish, Snake, Monkey, Bear, Sunflower, grass, pine tree, or apple tree");
        System.out.println(game.askQuestion());
        game.input = s.nextBoolean();
        game.updateAnswers();
        System.out.println(game.askQuestion());
        game.input = s.nextBoolean();
        game.updateAnswers();
        System.out.println(game.askQuestion());
        game.input = s.nextBoolean();
        game.updateAnswers();
        System.out.println(game.guess());

        game.a.clear();
        game.qa = 0;
        game.plant = false;

        game.mammal = false;
      
        game.tree = false ;
     
        game.input = false;

        for (String i: game.pa){
            game.a.add(i);
        }


        System.out.println("play again?");

        game.playagain = s.nextLine();
        System.out.println("play again?");



        if (game.playagain.contains("no")){
            break;
            }





        }
    
    

      
    }
}