package android.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recipe_details.*

class RecipeDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        var bundle = intent.extras
        imageView3.setImageResource(bundle!! .getInt ("image"))
        textView4.text = bundle!!.getString ("name")
        textView5.text = bundle!!.getString ("description")

        tvEdit.setOnClickListener {
            val intent = Intent (this, RecipeTypes ::class.java );
            startActivity(intent)
        }
    }
}