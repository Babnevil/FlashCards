public class NoteCard{
    private String answer;
    private String question;

    public NoteCard(String ques, String ans){
        question = ques;
        answer = ans;
    }
    public String getAnswer(){
        return answer;
    }
    public String getQuestion(){
        return question;
    }
}