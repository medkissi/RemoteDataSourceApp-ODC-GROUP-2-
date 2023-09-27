package com.medkissi.remotedatasourceappgroup2.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.medkissi.remotedatasourceappgroup2.data.model.Photo
import com.medkissi.remotedatasourceappgroup2.data.model.Post
import com.medkissi.remotedatasourceappgroup2.data.repository.PostRepository
import com.medkissi.remotedatasourceappgroup2.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel:ViewModel() {
    private val  repository = PostRepository()
    private val _posts= MutableLiveData<List<Post>>()
    val posts:LiveData<List<Post>> = _posts

    private val _photos= MutableLiveData<List<Photo>>()
    val photos:LiveData<List<Photo>> = _photos




    private  fun getPosts(){
        viewModelScope.launch (Dispatchers.IO){
            _posts.postValue(repository.getPosts())
        }

    }
     fun getAllPhotos() = liveData(Dispatchers.IO){
        emit(Resource.Loading(data = null))
        try {
            val photos = repository.getAllPhotos()
            emit(Resource.Success(data=photos))
        }catch (e:Exception){
            emit(Resource.Error(data = null, message = "Une erreur est survenue"))
        }


    }
}