package com.digitele.template.presentation.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitele.template.domain.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _postUiState = MutableStateFlow<PostUiState>(PostUiState.Loading)
    val postUiState: StateFlow<PostUiState> = _postUiState

    init {
      getPostsFromServer()
    }


    private fun getPostsFromServer(){
        viewModelScope.launch {
            try {
                  //get posts from network
                val posts = repository.getPosts()
                //save to local database
                repository.savePostsToLocal(posts)
                //get posts from local database
                val postsDB = repository.getPosts();
                Timber.tag("LocalDB").d("Posts from DB: $postsDB")
                _postUiState.value = PostUiState.Success(postsDB)
            } catch (e: Exception) {
                _postUiState.value = PostUiState.Error(e.message ?: "Unknown error")
            }
        }
    }

}

