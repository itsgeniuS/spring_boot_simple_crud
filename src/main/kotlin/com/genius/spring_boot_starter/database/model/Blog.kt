package com.genius.spring_boot_starter.database.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

/**
 *
 * Author: Thulasi rajan
 * Github: (https://github.com/itsgeniuS)
 * Created on: 08/06/25
 *
 **/

@Document("blogs")
data class Blog (
    @Id val id: ObjectId = ObjectId.get(),
    
    val title: String,
    val description: String,
    val content: String,
    val tags: List<String>,
    
    val authorId: ObjectId,
    val authorName: String,
    
    val createdAt: Instant,
)
