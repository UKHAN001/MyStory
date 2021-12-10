package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActtivity : AppCompatActivity() {

    private var editTextUsername:EditText?=null
    private var editTextPassword:EditText?=null
    private var buttonLogin:Button?=null
    private var checkBoxViews:CheckBox?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_acttivity)

        connectViews()
        login()
      //  checkFields()
    }
    private fun connectViews(){

        editTextUsername = findViewById(R.id.Usernamei)
        editTextPassword = findViewById(R.id.Passwordi)
        buttonLogin = findViewById(R.id.buttoni)
        checkBoxViews = findViewById(R.id.CheckBoxi)
    }
    private fun login(){
        val arr:ArrayList<DataClassUser> = ArrayList()
        arr.add(DataClassUser("a@1.com","1234"))
        arr.add(DataClassUser("b@2.com","12345"))
        arr.add(DataClassUser("c@3.com","12346"))

        buttonLogin?.setOnClickListener {
            val username = editTextUsername?.text.toString()
            val password = editTextPassword?.text.toString()

            val user = DataClassUser(username,password)

            for(userArray in arr){
                if(userArray.email == user.email && userArray.password == user.password){
                 //   Toast.makeText(this,"Welcome${user.email}",Toast.LENGTH_LONG).show()
                     finish()
                     val i = Intent(this,MainActivity::class.java)
                    i.putExtra("email",userArray.email)
                    startActivity(i)
                    break
                }else{Toast.makeText(this,"Check your data",Toast.LENGTH_LONG).show()}
                                 }
                                         }
                       }
    private fun checkFields(){
        buttonLogin?.setOnClickListener {  if (editTextUsername?.text?.isEmpty() == true ){
            editTextUsername?.error = "Enter yor email"
        }
        else if(editTextPassword?.text?.isEmpty() == true){editTextPassword?.error = ""}
            {/*Toast.makeText(this,"success",Toast.LENGTH_LONG).show()*/}
                                        }
                             }
}