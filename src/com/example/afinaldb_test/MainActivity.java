package com.example.afinaldb_test;

import java.util.List;



import net.tsz.afinal.FinalDb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private String spellString,pronounString,meaningString;
    private EditText spell,pronoun,meaning;
    private TextView textView1,textView_bool;
    private FinalDb db;
    private Button button_edit;
    private List<words> wordList;
    private int id_temp;
    private words word_apple;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spell = (EditText)findViewById(R.id.spell);
		pronoun = (EditText)findViewById(R.id.pronoun);
		meaning = (EditText)findViewById(R.id.meaning);
		textView1 = (TextView)findViewById(R.id.show_text);
		textView_bool = (TextView)findViewById(R.id.textView_bool);
		Button button = (Button)findViewById(R.id.confirm);
	    button_edit = (Button)findViewById(R.id.button_edit);
		db = FinalDb.create(getApplicationContext());
		wordList = db.findAll(words.class);//查询所有的用户
		word_apple = new words();
		word_apple.setSpell("apple");
		word_apple.setPronoun("app");
		word_apple.setMeaning("mean");
		word_apple.setId(1);
		//words word_find = db.findById(id_temp, words.class);
		//db.deleteById(words.class, id_temp);
		for (int i = 0; i < wordList.size(); i++) {
			if(wordList.get(i).getSpell().equals("banana"))
				{
				id_temp = wordList.get(i).getId();
				textView_bool.setText("true");
				}
		}
		db.update(word_apple);
		//Log.e("words_find", word_find.getSpell());
		for (int i = 0; i <wordList.size(); i++) {
			Log.i("xx",wordList.get(i).getSpell());
			//textView1.setText(wordList.get(i).getSpell());
		}
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				spellString =  spell.getText().toString();
				pronounString  =  pronoun.getText().toString();
				meaningString = meaning.getText().toString();
				
				words word_1 = new  words();
				word_1.setSpell(spellString);
				word_1.setMeaning(meaningString);
				word_1.setPronoun(pronounString);
				db.save(word_1);
				
				
			
			}
		});
		button_edit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	words word1;
			//	word1 = new words();
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, Editpage.class);
			//	intent.putExtra("word", word1);
				startActivity(intent);
			

			}
		});
		

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
