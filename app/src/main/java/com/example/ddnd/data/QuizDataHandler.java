package com.example.ddnd.data;

public class QuizDataHandler {

    private int image_res;
    private StringBuilder answer;
    private StringBuilder jumbled;

    public int getImage_res() {
        return image_res;
    }

    public StringBuilder getAnswer() {
        return answer;
    }

    public StringBuilder getJumbled() {
        return jumbled;
    }


    public QuizDataHandler(int image_res , String answer){
        this.answer = new StringBuilder(answer);
        this.image_res = image_res;


        this.jumbled = makeJumbledWord(this.answer);
    }
    //make this function better later
    private StringBuilder makeJumbledWord(StringBuilder answer){
        StringBuilder jumbledAnswer = new StringBuilder();
        for(int i=0; i<answer.length(); i++){
            if(i%2 != 0){
                jumbledAnswer.append(answer.charAt(i));
            }
        }
        for(int i=0; i<answer.length(); i++){
            if(i%2 == 0){
                jumbledAnswer.append(answer.charAt(i));
            }
        }

        return jumbledAnswer;
    }
}
