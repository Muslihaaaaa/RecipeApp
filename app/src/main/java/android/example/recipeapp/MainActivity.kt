package android.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {

            if (edUsername.text.trim().isNotEmpty() && edPassword.text.trim().isNotEmpty()) {
                //
                //Toast.makeText(this, "Input provided", Toast.LENGTH_LONG).show()
                val intent = Intent(this, RecipeList::class.java)
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()
            }

        }

        tvRegister.setOnClickListener {
            val intent = Intent (this, RegisterActivity ::class.java );
            startActivity(intent)
        }

    }


}