package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddStoryActivity : AppCompatActivity() {

    private var editTextTitle:EditText?=null
    private var editTextSubTitle:EditText?=null
    private var editTextDesc:EditText?=null
    private var buttonAddStory:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)

        connectViews()
        fieldsValidation()

    }//override fun onCreate(savedInstanceState: Bundle?) {

    private fun connectViews(){
        editTextTitle = findViewById(R.id.etTitleii)
        editTextSubTitle = findViewById(R.id.etSubTitleii)
        editTextDesc = findViewById(R.id.etDescriptionii)
        buttonAddStory = findViewById(R.id.buttonAddi)
    }
    private fun fieldsValidation(){
        buttonAddStory?.setOnClickListener {
            val title = editTextTitle?.text.toString()
            val subTitle = editTextSubTitle?.text.toString()
            val desc = editTextDesc?.text.toString()
            when {
                title.isEmpty() -> { editTextTitle?.error = getString(R.string.enter_title)}
                subTitle.isEmpty() -> {editTextSubTitle?.error = getString(R.string.enter_subtitle)}
                desc.isEmpty() -> {editTextDesc?.error = getString(R.string.enter_description)}
                else -> {this.finish()
                val i = Intent(this,MainActivity::class.java)
                i.putExtra("title",title)
                i.putExtra("subtitle",subTitle)
                i.putExtra("desc",desc)
                startActivity(i)}
            }
        }
    }

}//class AddStoryActivity : AppCompatActivity() {