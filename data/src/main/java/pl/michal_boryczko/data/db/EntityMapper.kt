package pl.michal_boryczko.data.db

import pl.michal_boryczko.data.entity.QuestionRoom
import pl.michal_boryczko.domain.models.Question

/**
 * Created by ${michal_boryczko} on 14.08.2018.
 */

fun Question.valueOf(): QuestionRoom = QuestionRoom(id, name)