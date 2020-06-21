package com.internshala.bolkar_project.activity.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.internshala.bolkar_project.*
import org.json.JSONObject
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var recyclervertical: RecyclerView
    lateinit var layoutmanagervertical: RecyclerView.LayoutManager
    lateinit var verticallist1:ArrayList<vertical>
    lateinit var recycleradaptervertical:verticaladapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclervertical = findViewById(R.id.verticalrecyclerview)

        layoutmanagervertical = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val queue = Volley.newRequestQueue(baseContext)

        val url = "https://d51md7wh0hu8b.cloudfront.net/android/v1/prod/Radio/hi/show.json"

        val jsonArrayRequest = object : JsonArrayRequest(Method.GET, url, null,
            Response.Listener {
                verticallist1= ArrayList()

                try{
                for (i in 0 until it.length())
                {

                    val verticallist:JSONObject=it.getJSONObject(i)
                    val verticalobject=vertical(
                        verticallist.getString("title"),
                        verticallist.getJSONArray("data")
                        )
                    verticallist1.add(verticalobject)
                   recycleradaptervertical = verticaladapter(baseContext,verticallist1)

                    recyclervertical.adapter=recycleradaptervertical
                    recyclervertical.layoutManager=layoutmanagervertical

                }}
                catch (e:Exception){
                    Toast.makeText(baseContext,"Error Occured",Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener {

                Toast.makeText(this@MainActivity,"${it.toString()}",Toast.LENGTH_SHORT).show()
            }
        ){

        }

                queue.add(jsonArrayRequest)
    }

}
