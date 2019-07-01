package com.example.viewpagerinfinity.views


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.Face
import com.squareup.picasso.Picasso


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BlankFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        val tvAge = view.findViewById<TextView>(R.id.tvAge)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val ivPicture = view.findViewById<ImageView>(R.id.ivProfile)
        val args = arguments
////        Log.d("haha", args.getString("AGE") + args.getString("NAME"))
        tvAge.text = args?.getString("AGE")
        tvName.text = args?.getString("NAME")
        Picasso.with(context).load(args?.getString("PICTURE")).into(ivPicture)
//
                return view
    }

    companion object {
        fun newInstanceFragmet(face: Face): BlankFragment {
            val fragment: BlankFragment =
                BlankFragment()
            val args = Bundle()
            args.putString("AGE",face.name)
            args.putString("NAME",face.age)
            args.putString("PICTURE", face.picture)
            fragment.arguments = args
            return fragment
        }
    }


}
