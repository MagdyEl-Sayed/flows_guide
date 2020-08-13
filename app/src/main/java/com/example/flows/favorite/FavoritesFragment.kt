package com.example.flows.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.flows.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_favorites.*

@AndroidEntryPoint
class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private val viewModel: FavoriteDogViewModel by viewModels()
    private val adapter by lazy(LazyThreadSafetyMode.NONE) { FavoriteAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeLiveData()
        fav_recycler.adapter = adapter
    }

    private fun observeLiveData() {
        viewModel.dogListLiveData.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}