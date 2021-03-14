package com.cuongtd.navigationapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.cuongtd.navigationapp.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false
        )
        binding.nextMatchButton.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_gameWonFragment_to_titleFragment)
        }
        var args = GameWonFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(
            context,
            "Number of Correct: ${args.numCorrect}" + "\n\n" +
                    "Number of Questions: ${args.numQuestions}",
            Toast.LENGTH_LONG
        ).show()
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)
        if (getShareItent()!!.resolveActivity(requireActivity().packageManager) == null) {
            // hide share item
            menu.findItem(R.id.share).setVisible(false);
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> startShare()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun startShare() {
        startActivity(getShareItent())
    }

    private fun getShareItent(): Intent? {
        var args = GameWonFragmentArgs.fromBundle(requireArguments())
        var shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(
            Intent.EXTRA_TEXT,
            getString(R.string.share_success_text, args.numCorrect, args.numQuestions)
        )
        return shareIntent
    }
}
