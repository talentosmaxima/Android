package br.com.maximatech.ui.alvarasScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.maximatech.R
import br.com.maximatech.databinding.FragmentAlvarasBinding

class AlvarasFragment : Fragment() {

    private lateinit var binding: FragmentAlvarasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlvarasBinding.inflate(inflater, container, false)
        val root = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.label_alvaras)
    }
}