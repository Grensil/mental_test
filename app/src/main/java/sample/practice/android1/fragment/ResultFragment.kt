package sample.practice.android1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_result.*
import sample.practice.android1.R
import sample.practice.android1.databinding.FragmentResultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var _binding:FragmentResultBinding

    var option = -1
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        option = arguments?.getInt("index")?:-1
        _binding = FragmentResultBinding.inflate(inflater, container, false);
        return _binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        setResult(option)
        imageView2.setOnClickListener{
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }
    fun setResult(option: Int)
    {
        when(option)
        {
            1 -> {
                textView.text = "당신은 끈기와 인내가 부족합니다!"
                textView2.text = "당신은 쉽게 사람을 포기합니다."
            }
            2-> {
                textView.text = "당신은 자신에게 집중해야합니다!"
                textView2.text = "당신은 전 연인에게 집착합니다."
            }
            3-> {
                textView.text = "당신은 편안하게 생각하려 해야합니다!"
                textView2.text = "당신은 그것이 어떻게 되든지 내버려둡니다."
            }
            4 -> {
                textView.text = "당신은 꽤 성숙합니다!"
                textView2.text = "당신은 이별을 쉽게 받아들일 수 있습니다."
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}