package com.example.ddnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ddnd.data.QuizDataHandler;

import java.util.ArrayList;

public class Quiz_activity extends AppCompatActivity {

    private TextView otv1,otv2,otv3,otv4,otv5,otv6;
    private TextView ttv1,ttv2,ttv3,ttv4,ttv5,ttv6;

    private TextView ohtv1,ohtv2,ohtv3,ohtv4,ohtv5,ohtv6;
    private TextView thtv1,thtv2,thtv3,thtv4,thtv5,thtv6;

    private ImageView quizImage;

    private Button reset,done;

    private ArrayList<TextView> ansTextviews;
    private ArrayList<TextView> hintTextviews;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_activity);
        getSupportActionBar().setTitle("Quiz Round");
        allFindViewByIds();
        makeArraylists();
        final ArrayList<QuizDataHandler> quizDataArray = quizDataset();
        setQuizData(quizDataArray,index++);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do clean previous settings
                // essential
                for(int j=0; j<ansTextviews.size(); j++){
                    hintTextviews.get(j).setText("");
                    ansTextviews.get(j).setText("");
                    hintTextviews.get(j).setVisibility(TextView.GONE);
                    ansTextviews.get(j).setVisibility(TextView.GONE);
                }

                if(index<quizDataArray.size()){
                    setQuizData(quizDataArray,index);
                    index++;
                } else {
                    startActivity(new Intent(Quiz_activity.this,animal_count.class));
                    finish();
                }
            }
        });

    }


    private void setQuizData(ArrayList<QuizDataHandler> quizDataArray , int pos){

            QuizDataHandler instance = quizDataArray.get(pos);
            quizImage.setImageResource(instance.getImage_res());
            String thisString = instance.getJumbled().toString();
            for(int j=0; j<thisString.length(); j++){
                StringBuilder temp = new StringBuilder();
                temp.append(thisString.charAt(j));
                String p = temp.toString();
                hintTextviews.get(j).setText(p);
                hintTextviews.get(j).setVisibility(TextView.VISIBLE);
                ansTextviews.get(j).setVisibility(TextView.VISIBLE);
            }
            //Toast.makeText(Quiz_activity.this , "jumbled ="+instance.getJumbled().toString(),Toast.LENGTH_SHORT).show();

    }

    private ArrayList<QuizDataHandler> quizDataset(){
        ArrayList<QuizDataHandler> quizInstanceArray = new ArrayList<>();
        quizInstanceArray.add(new QuizDataHandler(R.drawable.amoebaready , "AMOEBA"));
        quizInstanceArray.add(new QuizDataHandler(R.drawable.harps , "HARPS"));
        quizInstanceArray.add(new QuizDataHandler(R.drawable.shear , "SHEAR"));

        //addd more here....


        return quizInstanceArray;

    }





    private void makeArraylists(){
        //ans
        ansTextviews = new ArrayList<>();
        ansTextviews.add(otv1);
        ansTextviews.add(otv2);
        ansTextviews.add(otv3);
        ansTextviews.add(otv4);
        ansTextviews.add(otv5);
        ansTextviews.add(otv6);
        ansTextviews.add(ttv1);
        ansTextviews.add(ttv2);
        ansTextviews.add(ttv3);
        ansTextviews.add(ttv4);
        ansTextviews.add(ttv5);
        ansTextviews.add(ttv6);

        //hint
        hintTextviews = new ArrayList<>();
        hintTextviews.add(ohtv1);
        hintTextviews.add(ohtv2);
        hintTextviews.add(ohtv3);
        hintTextviews.add(ohtv4);
        hintTextviews.add(ohtv5);
        hintTextviews.add(ohtv6);
        hintTextviews.add(thtv1);
        hintTextviews.add(thtv2);
        hintTextviews.add(thtv3);
        hintTextviews.add(thtv4);
        hintTextviews.add(thtv5);
        hintTextviews.add(thtv6);

    }






    private void allFindViewByIds(){
        //answers tvs all
        otv1=findViewById(R.id.ans_tv1);
        otv2=findViewById(R.id.ans_tv2);
        otv3=findViewById(R.id.ans_tv3);
        otv4=findViewById(R.id.ans_tv4);
        otv5=findViewById(R.id.ans_tv5);
        otv6=findViewById(R.id.ans_tv6);

        ttv1=findViewById(R.id.ans_tv7);
        ttv2=findViewById(R.id.ans_tv8);
        ttv3=findViewById(R.id.ans_tv9);
        ttv4=findViewById(R.id.ans_tv10);
        ttv5=findViewById(R.id.ans_tv11);
        ttv6=findViewById(R.id.ans_tv12);

        //hints tvs all
        ohtv1=findViewById(R.id.op1);
        ohtv2=findViewById(R.id.op2);
        ohtv3=findViewById(R.id.op3);
        ohtv4=findViewById(R.id.op4);
        ohtv5=findViewById(R.id.op5);
        ohtv6=findViewById(R.id.op6);

        thtv1=findViewById(R.id.op7);
        thtv2=findViewById(R.id.op8);
        thtv3=findViewById(R.id.op9);
        thtv4=findViewById(R.id.op10);
        thtv5=findViewById(R.id.op11);
        thtv6=findViewById(R.id.op12);

        //image
        quizImage = findViewById(R.id.quiz_imageview);
        //buttons
        reset = findViewById(R.id.reset_button);
        done = findViewById(R.id.done_button);

    }
}
