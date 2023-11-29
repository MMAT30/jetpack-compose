package tor.anonymous.unscramble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import tor.anonymous.unscramble.data.MAX_NO_OF_WORDS
import tor.anonymous.unscramble.data.SCORE_INCREASE
import tor.anonymous.unscramble.data.allWords

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState>
        get() {
            TODO()
        }
}