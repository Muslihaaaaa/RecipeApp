package android.example.recipeapp

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media.getBitmap
import kotlinx.android.synthetic.main.activity_recipe_types.*

class RecipeTypes : AppCompatActivity() {
    lateinit var filepath: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_types)

        button.setOnClickListener{
            startFileChooser ()
        }

    }

    private fun startFileChooser() {
        var i = Intent ()
        i.setType("images/*")
        startActivityForResult(Intent.createChooser(i, "Choose Image"), 111)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 111 && resultCode == RESULT_OK && data !=null){
            filepath = data.data !!
            var bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filepath)
            imageView2.setImageBitmap(bitmap)

        }
    }
}