package tor.anonymous.notes.data

import tor.anonymous.notes.model.Note

class NoteData {

    fun loadData(): List<Note> {
        return listOf(
            Note(heading = "1", body = "testing"),
            Note(heading = "2", body = "testing"),
            Note(heading = "3", body = "testing"),
            Note(heading = "4", body = "testing"),
            Note(heading = "5", body = "testing"),
            Note(heading = "6", body = "testing"),
            Note(heading = "7", body = "testing"),
            Note(heading = "8", body = "testing"),
            Note(heading = "9", body = "testing"),
            Note(heading = "10", body = "testing"),
            Note(heading = "11", body = "testing")
        )
    }
}