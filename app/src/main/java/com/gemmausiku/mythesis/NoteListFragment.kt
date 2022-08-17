package com.gemmausiku.mythesis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gemmausiku.mythesis.databinding.FragmentNoteListBinding



/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NoteListFragment : Fragment() {

    private var _binding: FragmentNoteListBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listNotes.layoutManager = LinearLayoutManager(this.requireContext())
        binding.listNotes.adapter = NoteRecyclerViewAdapter(DataManager.notes, ::onNoteClick)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_NoteListFragment_to_NoteFragment)
        }   //fragment navigation code, navigation is managed automatically
    }

    private fun onNoteClick(noteId:Int) {
        val action = NoteListFragmentDirections.actionNoteListFragmentToNoteFragment(noteId)
        activity?.findNavController(R.id.nav_host_fragment_content_main)?.navigate(action)
    }



    override fun onResume() {
        super.onResume()
        binding.listNotes.adapter?.hasObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
