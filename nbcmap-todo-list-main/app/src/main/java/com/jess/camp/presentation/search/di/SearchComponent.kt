package com.jess.camp.presentation.search.di

import androidx.lifecycle.ViewModel
import com.jess.camp.data.remote.SearchRemoteDatasource
import com.jess.camp.data.repository.SearchRepositoryImpl
import com.jess.camp.di.DaggerViewModelFactoryModule
import com.jess.camp.di.ViewModelKey
import com.jess.camp.domain.repository.SearchRepository
import com.jess.camp.presentation.search.SearchFragment
import com.jess.camp.presentation.search.SearchViewModel
import com.jess.camp.retorift.RetrofitClient
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Component(
    modules = [
        DaggerViewModelFactoryModule::class,
        SearchViewModelModule::class,
        SearchBindModule::class,
        SearchProvideModule::class
    ]
)
interface SearchComponent {

    fun inject(fragment: SearchFragment)

    @Component.Factory
    interface Factory {
        fun create(): SearchComponent
    }
}

@Module
interface SearchViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindsSearchViewModel(viewModel: SearchViewModel): ViewModel
}

@Module
interface SearchBindModule {

    @Binds
    fun bindSearchRepository(
        repository: SearchRepositoryImpl
    ): SearchRepository
}

@Module
class SearchProvideModule {

    @Provides
    fun provideSearchRemoteDatasource(): SearchRemoteDatasource {
        return RetrofitClient.search
    }
}