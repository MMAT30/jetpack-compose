package tor.anonymous.notes.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import tor.anonymous.notes.R
import tor.anonymous.notes.components.NoteButton
import tor.anonymous.notes.components.NoteCard
import tor.anonymous.notes.components.NoteInputText
import tor.anonymous.notes.model.Note


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {

    var heading by rememberSaveable {
        mutableStateOf("")
    }

    var body by rememberSaveable {
        mutableStateOf("")
    }




    Scaffold(modifier = Modifier, topBar = { NoteScreenTopBar() }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            NoteInputText(
                value = heading, maxLines = 1, onValueChange = {
                    if (it.all { char -> char.isLetter() || char.isWhitespace() }) {
                        heading = it
                    }
                }, label = "Enter Heading"
            )

            NoteInputText(value = body, maxLines = 1, onValueChange = {
                if (it.all { char -> char.isLetter() || char.isWhitespace() }) {
                    body = it
                }
            }, label = "Enter Body")


            NoteButton(onClick = {
                if (heading.isNotEmpty() && body.isNotEmpty()) {
                    onAddNote(Note(
                        heading = heading,
                        body = body
                    ))
                    heading = ""
                    body = ""
                }
            }, label = "Save")


            LazyColumn {
                items(notes) {
                    NoteCard(heading = it.heading, body = it.body, entryDate = it.entryDate, onClick = {})
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreenTopBar() {
    TopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
    })
}


