package com.example.nullsafetylateinitexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nullsafetylateinitexample.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    //private lateinit var address: String
    // throws UninitializedPropertyAccessException if used before initialization

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val address = "ksdkfsk"
        //address = "Roskilde"
        binding.textviewFirst.text = address

        binding.buttonFirst.setOnClickListener {
            // findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            doIt()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun doIt() {
        //val name: String = "Anders"
        var name: String? = "" // Null can not be a value of a non-null type
        //name = null

        val length: Int? = name?.length
        Log.d("APPLE", length.toString())

        val input: String = binding.editTextName.text.toString().trim()

        var name2: String? = null
        if (input.length > 2) {
            name2 = input
        }
        // var length2 = name2.length // will not compile

        val length2: Int? = name2?.length
        // if (name2 == null) length2 = null else length2=name2.length

        val length3: Int = name2?.length ?: -1
        // so-called Elvis operator (Elvis Presley hair style)
        // if (name2 == null) length3=-1 else length3=name2.length

        val length4: Int = name2!!.length
        // !! convert from String? to String
        // !! programmer responsibility: Risk of NullPointerException

        binding.textviewFirst.text =
            "name2=$name2 length2=$length2 length3=$length3 length4=$length4"
    }
}