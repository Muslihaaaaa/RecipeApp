package android.example.recipeapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_recipe_list.*
import kotlinx.android.synthetic.main.mylayout.*
import kotlinx.android.synthetic.main.mylayout.view.*

class RecipeList : AppCompatActivity() {
    var adapter : FoodAdapter? = null
    var foodlist = ArrayList<Food> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)


        foodlist.add(Food("Burnt Cheesecake", "ingredients: Unsalted butter (for pan), cream cheese, 1½ cups sugar, 6 large eggs, " +
                "2 cups heavy cream, 1 tsp salt, 1 tsp vanilla extract, 1/3 cup all purpose flour", R.drawable.bcc))
        foodlist.add (Food("Kek batik", "ingredients: 1 pek biskut Marie, 250g mentega/butter, 200g serbuk Milo, 3 sudu besar serbuk koko, ayak, 3/4 tin susu pekat", R.drawable.kek_batik))
        foodlist.add (Food("Apple Juice", "ingredients: 1 green apple, 1 stalk of celery or 1/3 cucumber, 1/4 cup of water, 1 teaspoon honey", R.drawable.jusapple))

        adapter = FoodAdapter(this, foodlist)
        gridView.adapter = adapter

    }
    class FoodAdapter: BaseAdapter {
        var foodlist = ArrayList<Food> ()
        var context: Context? = null

        constructor(context: Context?, foodlist: ArrayList<Food> ) : super() {
            this.foodlist = foodlist
            this.context = context
        }

        override fun getCount(): Int {
           return foodlist.size
        }

        override fun getItem(p0: Int): Any {
            return p0
        }

        override fun getItemId(p0: Int): Long {
           return p0.toLong()
        }

        override fun getView(index: Int, p1: View?, p2: ViewGroup?): View {
            var food = this.foodlist[index]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodview =inflater.inflate(R.layout.mylayout, null)
            foodview.imageView.setImageResource(food.image!!)
            foodview.textView3.text = food.name!!

            foodview.imageView.setOnClickListener {
                var intent = Intent (context, RecipeDetails ::class.java)
                intent.putExtra("name", food.name!!)
                intent.putExtra("description", food.des!!)
                intent.putExtra("image", food.image!!)
                context!!.startActivity(intent)
            }

            return foodview
        }


    }
}


