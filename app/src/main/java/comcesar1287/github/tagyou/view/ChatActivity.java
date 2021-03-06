package comcesar1287.github.tagyou.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import comcesar1287.github.tagyou.R;
import comcesar1287.github.tagyou.controller.domain.UserDetails;


public class ChatActivity extends AppCompatActivity implements View.OnClickListener, com.google.firebase.database.ChildEventListener{
    LinearLayout layout;
    RelativeLayout layout_2;
    ImageView sendButton;
    EditText messageArea;
    ScrollView scrollView;

    private DatabaseReference mReference1, mReference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(UserDetails.chatWithName);
        }

        mReference1 = FirebaseDatabase.getInstance().getReference().child(UserDetails.username + "_" + UserDetails.chatWith);
        mReference2 = FirebaseDatabase.getInstance().getReference().child(UserDetails.chatWith + "_" + UserDetails.username);

        layout = (LinearLayout) findViewById(R.id.layout1);
        layout_2 = (RelativeLayout)findViewById(R.id.layout2);

        sendButton = (ImageView)findViewById(R.id.sendButton);
        sendButton.setOnClickListener(this);

        messageArea = (EditText)findViewById(R.id.messageArea);
        scrollView = (ScrollView)findViewById(R.id.scrollView);

        mReference1.addChildEventListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.sendButton:
                String messageText = messageArea.getText().toString();
                String time = hora();

                if(!messageText.equals("")){
                    Map<String, Object> map = new HashMap<>();
                    map.put("message", messageText);
                    map.put("user", UserDetails.username);
                    map.put("timeCurrent", time);
                    mReference1.push().setValue(map);
                    mReference2.push().setValue(map);
                    messageArea.setText("");
                }
                break;
        }
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        Map map = (Map) dataSnapshot.getValue();
        String message = map.get("message").toString();
        String userName = map.get("user").toString();
        String time = map.get("timeCurrent").toString();

        if(userName.equals(UserDetails.username)){
            addMessageBox("Você:-\n" + message, 1, time );
        }
        else{
            addMessageBox(UserDetails.chatWithName + ":-\n" + message, 2, time);
        }
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }


    public String hora(){
        Calendar currentTime = Calendar.getInstance();
        final int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        final int minute = currentTime.get(Calendar.MINUTE);

        return (hour + ":" + minute);
    }


    public void addMessageBox(String message, int type, String time){
        TextView textView = new TextView(ChatActivity.this);
        textView.setText(message);
        textView.setPadding(40, 20, 40, 20);
        textView.setMaxWidth(500);


        TextView textView1 = new TextView(ChatActivity.this);
        textView1.setText(time);
        textView1.setPadding(35, 0, 35, 5);

        LinearLayout linear = new LinearLayout(ChatActivity.this);
        linear.addView(textView);
        linear.addView(textView1);
        linear.setOrientation(LinearLayout.VERTICAL);


        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp2.weight = 1.0f;

        if(type == 1) {
            lp2.gravity = Gravity.START;
            linear.setBackgroundResource(R.drawable.balloon_incoming_normal);

        }

        else{
            lp2.gravity = Gravity.END;
            linear.setBackgroundResource(R.drawable.balloon_outgoing_normal);
        }

        linear.setLayoutParams(lp2);
        layout.addView(linear);
        scrollView.fullScroll(View.FOCUS_DOWN);
    }
}
