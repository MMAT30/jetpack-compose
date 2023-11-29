package tor.anonymous.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import tor.anonymous.notes.data.NoteData
import tor.anonymous.notes.model.Note
import tor.anonymous.notes.screen.NoteScreen
import tor.anonymous.notes.ui.theme.NotesTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val notes = remember {
                        mutableListOf<Note>()
                    }


                    NoteScreen(
                        notes = notes,
                        onAddNote = {
                              notes.add(it)
                        },
                        onRemoveNote = {
                            notes.remove(it)
                        }
                    )
                }
            }
        }
    }
}




