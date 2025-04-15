package com.digitele.template.presentation.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitele.template.domain.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _postUiState = MutableStateFlow<PostUiState>(PostUiState.Loading)
    val postUiState: StateFlow<PostUiState> = _postUiState

    init {
        viewModelScope.launch {
            try {
                val posts = repository.getPosts()
                _postUiState.value = PostUiState.Success(posts)
            } catch (e: Exception) {
                _postUiState.value = PostUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

