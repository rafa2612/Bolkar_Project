package com.internshala.bolkar_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList

class horizontaladapter(val context:Context, var horizontallist:ArrayList<horizontal>)
    : RecyclerView.Adapter<horizontaladapter.horizontalviewholder>() {


    var newlist:ArrayList<horizontal> =horizontallist


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): horizontalviewholder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.horizontal_recycler_layout,parent,false)
        return horizontalviewholder(view)
    }

    override fun getItemCount(): Int {
       return horizontallist.size
    }

    override fun onBindViewHolder(holder: horizontalviewholder, position: Int) {
        val horizontallist1=horizontallist[position]

        holder.textviewhorizontal1.text=horizontallist1.t
        Picasso.get().load(horizontallist1.p).error(R.drawable.ic_launcher_background).into(holder.imageview1);


        holder.clicklistener.setOnClickListener {
            remove(position,holder.adapterPosition)
        }


    }



    class horizontalviewholder(view:View):RecyclerView.ViewHolder(view){

        val textviewhorizontal1:TextView=view.findViewById(R.id.txttitlehorizontal1)
        val imageview1:ImageView=view.findViewById(R.id.imagehorizontalrecycler1)
        val clicklistener: RelativeLayout =view.findViewById(R.id.relativemainhorizontalrecycler)

    }



    fun remove(i:Int,j:Int){
        horizontallist.removeAt(j)
       diffutil(horizontallist)
        notifyItemRemoved(j)
        Toast.makeText(context,"position $i item removed",Toast.LENGTH_LONG).show()
    }

    fun diffutil(horizontallist2: ArrayList<horizontal>){
        val diff:diffutils=diffutils(newlist,horizontallist2)

        val diffresult:DiffUtil.DiffResult=DiffUtil.calculateDiff(diff)

        horizontallist=horizontallist2

        diffresult.dispatchUpdatesTo(this)

    }



}