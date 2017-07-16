package com.example.xiao5.tee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mtureButton;
    private Button mfalseButton;
    private Button mnextButton;
    private TextView  mQuestionTextView;
    private Question[] mQuestionBank =new Question[]{
            new Question(R.string.question_text,true),
            new Question(R.string.question_1,true),
            new Question(R.string.question_2,true),
            new Question(R.string.question_3,true)

    };
    private int mCurrentIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtureButton=(Button)findViewById(R.id.button_true);
        mfalseButton=(Button)findViewById(R.id.button_false);
        mnextButton=(Button)findViewById(R.id.button_next) ;
        mQuestionTextView=(TextView)findViewById(R.id.question_text_view) ;
        int question=mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);





        mfalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentIndex==0) {
                    Toast.makeText(MainActivity.this, R.string.wrong_toast, Toast.LENGTH_SHORT).show();
                }
                else
                    checkAnswer(false);
            }
        });

        mtureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mnextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
                updateQuestion();

            }
        });



    }
    public void updateQuestion(){
        int question=mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
    public  void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue=mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId=0;
        if(userPressedTrue==answerIsTrue){
            messageResId=R.string.correct_toast;

        }else {
            messageResId=R.string.error;

        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();

    }

}
