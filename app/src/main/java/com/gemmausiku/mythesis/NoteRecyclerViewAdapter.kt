package com.gemmausiku.mythesis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class NoteRecyclerViewAdapter(private val notes: List<NoteInfo>,
                              private val onNoteClick: (Int) -> Unit
) :
    RecyclerView.Adapter<NoteRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_notes, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.apply {
            textChapter?.text = note.chapter?.title
            textTitle?.text = note.title
            notePosition = position
            itemView.setOnClickListener { onNoteClick(holder.notePosition) }
        }


    }

    override fun getItemCount() = notes.size

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val textChapter = itemView?.findViewById<TextView>(R.id.textChapter)
        val textTitle = itemView?.findViewById<TextView>(R.id.textTitle)
        var notePosition = 0
    }
}