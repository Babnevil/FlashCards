import java.util.Scanner;
import java.util.ArrayList;
public class Study{
    /* public static void main(String [] args){
        public NoteCard nc = new NoteCard();
        public CardSet sc = CardSet(); */
        private ArrayList<CardSet> master = new ArrayList<>();
        Scanner s = new Scanner(System.in);

    public void makeSet(String setName){
        boolean halt = false;
        String ques = null;
        String ans = null;
        //CardSet con = new CardSet();
        //try (Scanner s = new Scanner(System.in)){
        
        
        // if(setName == null)
        //     System.out.println("Please enter a valid name");
        //if(setName != null)
        CardSet set = new CardSet(setName);
        
        //get the values for the card from the user, then create and add the card to the set
        do{
        System.out.println("\nEnter a question");
            ques = s.nextLine();

        System.out.println("\nEnter the answer");
            ans = s.nextLine();

        set.addCard(ques, ans);
        //check if the user wants to create another card
        System.out.println("\nCreat another card Y/N?");
        String check = s.nextLine();
        if (check.equals("n")||check.equals("N")){
            halt =true;
            addToMaster(set);
        }
        }while(halt == false);
    //}
    }

    public void start(){
        boolean halt = false;
        //try (Scanner s = new Scanner(System.in)){
        do{
            System.out.println("------WELCOME------");
            System.out.println("Please enter a corresponding number");
            System.out.println("1. Create a new set of cards");
            System.out.println("2. \tReview a current set");
            System.out.println("3. \t\tQuit");

            int select = s.nextInt();
            s.nextLine();

            if(select==1){
            System.out.println("Please enter a name");
            String setName = s.nextLine();
            makeSet(setName);
            }
            
            if(select==2 && master.isEmpty()){
                System.out.println("You have not created any card sets yet\n" + 
                                   "Please create at least one set first");
                start();
                }
            
            
            else if(select ==2)
                runSet();
            //If the user selects to quit, we end the loop, letting control go back to the main method
            //and reach the end of the code. 
            //However, this could be a good spot to trigger shutdown procedures
            if(select==3)
                halt=true;
                
          
        }while(halt == false);
    //}
    }

    public void runSet(){
        System.out.println("Please select a set");
        int counter = 1;
        for(CardSet set: master){
            String name = set.getName();
            System.out.println(counter +" :" + name);
            counter++;
        }
        //try(Scanner s = new Scanner(System.in)){
            int select = s.nextInt();
            if(select>master.size()){
               System.out.println("Sorry, that set number wasnt right\n"+
                                  "Please enter only one of the numbers shown");
               runSet();
            }
            if(select ==1)
               select =0;
            else
               select -=1;
            CardSet printMe = master.get(select);
            printMe.runSet();
        //}
    }

    public void addToMaster(CardSet set){
        master.add(set);
    }

}