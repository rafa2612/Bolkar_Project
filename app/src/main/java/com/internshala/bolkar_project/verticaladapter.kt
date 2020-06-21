package com.internshala.bolkar_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject


class verticaladapter (val context:Context, val verticallist:ArrayList<vertical>) : RecyclerView.Adapter<verticaladapter.verticalviewholder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): verticalviewholder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.vertical_recycler_layout,parent,false)
        return verticalviewholder(view)
    }

    override fun getItemCount(): Int {
        return verticallist.size
    }

    override fun onBindViewHolder(holder: verticalviewholder, position: Int) {
        val verticallist1=verticallist[position]
        holder.textview.text=verticallist1.title


        val horizontallist:JSONArray = verticallist1.data
        val horizontallist1:ArrayList<horizontal>
        val layoutmanagerhorizontal=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        horizontallist1= ArrayList()
        for (i in 0 until horizontallist.length())
        {
            val horizontallistobj: JSONObject =horizontallist.getJSONObject(i)
            val horizontalobject=horizontal(
                horizontallistobj.getString("t"),
                horizontallistobj.getString("cat"),
                horizontallistobj.getString("d"),
                horizontallistobj.getString("p"),
                horizontallistobj.getString("pF"),
                horizontallistobj.getString("pFBig"),
                horizontallistobj.getString("id")

            )
            horizontallist1.add(horizontalobject)
            val recycleradapterhorizontal = horizontaladapter(context,horizontallist1)

            holder.recyclerhorizontal.adapter=recycleradapterhorizontal
            holder.recyclerhorizontal.layoutManager=layoutmanagerhorizontal

        }
    }

    class verticalviewholder(view: View):RecyclerView.ViewHolder(view){
        val textview:TextView=view.findViewById(R.id.txttitlevertical)
        val recyclerhorizontal:RecyclerView=view.findViewById(R.id.horizontalrecyclerview)

    }

}