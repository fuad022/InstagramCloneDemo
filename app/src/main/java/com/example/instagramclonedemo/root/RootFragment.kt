package com.example.instagramclonedemo.root

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentRootBinding
import com.example.instagramclonedemo.util.Util.dpToPx
import com.google.android.material.bottomnavigation.BottomNavigationView

class RootFragment : Fragment() {
    private val binding by lazy { FragmentRootBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val navView: BottomNavigationView = binding.bottomNav

        val navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        binding.bottomNav.setupWithNavController(navController)
        navView.itemIconTintList = null

        val menu = binding.bottomNav.menu
        val menuItem = menu.findItem(R.id.profile)
        Glide.with(this)
            .asBitmap()
            .load(R.drawable.user_img_12)
            .apply(
                RequestOptions.circleCropTransform()
            ).into(object :
//                CustomTarget<Bitmap>(dpToPx(24), dpToPx(24)) {
                CustomTarget<Bitmap>(dpToPx(24, requireContext()), dpToPx(24, requireContext())) {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    menuItem?.icon = BitmapDrawable(resources, resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {}
            })

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.directMessagesFragment -> hideBottomNav()
                R.id.profileEditFragment -> hideBottomNav()
//                R.id.igtvFragment -> hideBottomNav()
                else -> showBottomNav()
            }
        }
    }

    private fun hideBottomNav() {
//        binding.bottomNav.visibility = View.GONE
        binding.bottomNav.isVisible = false
    }

    private fun showBottomNav() {
//        binding.bottomNav.visibility = View.VISIBLE
        binding.bottomNav.isVisible = true
    }

//    fun dpToPx(dp: Int): Int {
//        val r = requireContext().resources
//        return TypedValue.applyDimension(
//            TypedValue.COMPLEX_UNIT_DIP,
//            dp.toFloat(),
//            r.displayMetrics
//        ).toInt()
//    }
}