package tor.anonymous.notes.model

import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(),
    val heading: String,
    val body: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
