
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.digitele.template.presentation.post.PostUiState
import com.digitele.template.presentation.post.PostViewModel
import timber.log.Timber


@Composable
fun PostScreen(viewModel: PostViewModel = hiltViewModel()) {
    val state = viewModel.postUiState.collectAsStateWithLifecycle().value

    when (state) {
        is PostUiState.Loading -> CircularProgressIndicator()

        is PostUiState.Success -> {
            val posts = state.posts

            LaunchedEffect(Unit) {
                Timber.tag("PostScreen").d("Loaded Posts: $posts")
            }

//            LazyColumn {
//                items(posts) { post ->
//                    PostListItem(post)
//                }
//            }


        }

        is PostUiState.Error -> Text("Error: ${state.message}")
    }
}





@Composable
fun PostListItem(post: Post) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = post.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = post.body,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
