package com.gemmausiku.mythesis


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import androidx.appcompat.content.res.AppCompatResources
import com.gemmausiku.mythesis.databinding.FragmentNoteBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@Suppress("DEPRECATION")
class NoteFragment : Fragment() {
    private var notePosition = POSITION_NOT_SET

    private var _binding: FragmentNoteBinding? = null

    // This property is only valid between onCreateView and  the onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterChapters = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            DataManager.chapters.values.toList()
        )
        // layout with  list  of   options is specified here
        adapterChapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // adapter for the spinner  is applied  here using adapterChapters
        binding.spinnerChapters.adapter = adapterChapters

        notePosition = savedInstanceState?.getInt(NOTE_POSITION, POSITION_NOT_SET)
            ?: arguments?.let { NoteFragmentArgs.fromBundle(it).myArgs }!!

        if (notePosition != POSITION_NOT_SET)
            displayNote()
        else {
            DataManager.notes.add(NoteInfo())
            notePosition = DataManager.notes.lastIndex
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NOTE_POSITION, notePosition)
    }

    private fun displayNote() {
        val note = DataManager.notes[notePosition]
        binding.textNoteTitle.setText(note.title)
        binding.textNoteText.setText(note.text)

        val chapterPosition = DataManager.chapters.values.indexOf(note.chapter)
        binding.spinnerChapters.setSelection(chapterPosition)
    }

    @Deprecated("Deprecated in Java", ReplaceWith("inflater.inflate(R.menu.menu_main, menu)"))
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // if action bar is  available items are added there
        inflater.inflate(R.menu.menu_main, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_next -> {
                if (notePosition < DataManager.notes.lastIndex)
                    moveNext()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onPrepareOptionsMenu(menu: Menu) {
        if (notePosition >= DataManager.notes.lastIndex) {
            val itemMenu = menu.findItem(R.id.action_next)
            if (itemMenu != null) {
                itemMenu.icon =
                    AppCompatResources.getDrawable(
                        requireContext().applicationContext,
                        R.drawable.ic_block_24
                    )
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    private fun saveNote() {
        val note = DataManager.notes[notePosition]
        note.title = binding.textNoteTitle.text.toString()
        note.text = binding.textNoteText.text.toString()
        note.chapter = binding.spinnerChapters.selectedItem as ChapterInfo?
    }


    private fun moveNext() {
        ++notePosition
        displayNote()
        requireActivity().invalidateOptionsMenu()
    }

    override fun onPause() {
        super.onPause()
        saveNote()
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}