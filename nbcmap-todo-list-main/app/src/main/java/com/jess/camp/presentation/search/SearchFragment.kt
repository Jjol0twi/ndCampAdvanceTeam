package com.jess.camp.presentation.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.jess.camp.databinding.SearchFragmentBinding
import com.jess.camp.presentation.search.di.DaggerSearchComponent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private var _binding: SearchFragmentBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SearchViewModel by viewModels { viewModelFactory }

    private val adapter: SearchListAdapter by lazy {
        SearchListAdapter { item ->
            viewModel.onClickSearchItem(item)
        }
    }

    override fun onAttach(context: Context) {
        DaggerSearchComponent.factory().create().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()

        // test
        viewModel.search("kotlin")
    }

    private fun initView() = with(binding) {
        searchList.adapter = adapter
    }

    private fun initViewModel() = with(viewModel) {
        // collect : 새로운 데이터가 발행 되면 끝날 때 까지 기다림
        // collectLatest : 새로운 데이터가 발행되면 이전 처리르 취소하고 새로운 데이터 처리
        viewLifecycleOwner.lifecycleScope.launch {
            uiState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collectLatest { state ->
                    onBind(state)
                }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            event.flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collectLatest { event ->
                    onEvent(event)
                }
        }
    }

    private fun onBind(
        uiState: SearchUiState
    ) = with(binding) {
        adapter.submitList(uiState.list)
    }

    private fun onEvent(
        event: SearchEvent
    ) {
        when (event) {
            is SearchEvent.OpenDetail -> {
                Log.d("jess", event.item.toString())
            }
        }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}