package android.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister.setOnClickListener {
            if (editUsername.text.trim().isNotEmpty() && editEmail.text.trim().isNotEmpty() && editPassword.text.trim().isNotEmpty() && editCPassword.text.trim().isNotEmpty()){
                Toast.makeText(this, "Input provided", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()
            }
        }

        tvLogin.setOnClickListener {
            val intent = Intent (this, MainActivity :: class.java);
            startActivity(intent);
        }


    }

}