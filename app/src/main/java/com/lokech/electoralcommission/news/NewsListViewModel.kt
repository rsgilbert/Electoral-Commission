package com.lokech.electoralcommission.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lokech.electoralcommission.data.News
import com.lokech.electoralcommission.util.withNewsList


class NewsListViewModel : ViewModel() {
    val newsListLiveData = MutableLiveData<List<News>>()

    init {
        setNewsListLiveData()
    }
}

fun NewsListViewModel.setNewsListLiveData() {
    withNewsList { newsListLiveData.value = it }
}