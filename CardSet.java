import java.util.Scanner;
import java.util.ArrayList;
public class CardSet{
    ArrayList<NoteCard> deck;
    private String name;
    Scanner s = new Scanner(System.in);
    //Create a cardset with a name meant to represent the set, that the user can search for
    //Create an ArrayList to hold the individual cards so we can reference and call from them
    public CardSet(String name){
        this.name = name;
        deck = new ArrayList<>();
    }

    public CardSet(){
        
    }

    public void addCard(String ques, String ans){
        NoteCard card = new NoteCard(ques, ans);
        deck.add(card);
    }

    public String getQuestion(int index){
        NoteCard read = deck.get(index);
        String q = read.getQuestion();
        return q;
    }

    public String getAnswer(int index){
        NoteCard read = deck.get(index);
        String a = read.getAnswer();
        return a;
    }

    public String getName(){
        return name;
    }

    public void runSet(){
        for(int i=0; i<deck.size(); i++){
            String ques = getQuestion(i);
            System.out.println("\nQuestion: "+ ques);
            //try(Scanner s = new Scanner(System.in)){
                System.out.println("\nEnter any character when ready for answer");
                String ahead = s.next();
                if(ahead!= null){
                    String ans = getAnswer(i);
                    System.out.println("\nAnswer: "+ans);
                }
            //}
        }
    }
}