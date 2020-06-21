package com.internshala.bolkar_project

import androidx.recyclerview.widget.DiffUtil

class diffutils(val oldhorizontallist:ArrayList<horizontal>,val newhorizontallist:ArrayList<horizontal>): DiffUtil.Callback() {




    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldhorizontallist.get(oldItemPosition).id==newhorizontallist.get(newItemPosition).id
    }

    override fun getOldListSize(): Int {
        return oldhorizontallist.size
    }

    override fun getNewListSize(): Int {
     return newhorizontallist.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return oldhorizontallist.get(oldItemPosition).t.equals(newhorizontallist.get(newItemPosition).t)
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}