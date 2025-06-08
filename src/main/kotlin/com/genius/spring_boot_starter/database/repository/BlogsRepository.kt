package com.genius.spring_boot_starter.database.repository

import com.genius.spring_boot_starter.database.model.Blog
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

/**
 *
 * Author: Thulasi rajan
 * Github: (https://github.com/itsgeniuS)
 * Created on: 08/06/25
 *
 **/


interface BlogsRepository : MongoRepository<Blog, ObjectId> {
	fun findOwnerById(authorId: ObjectId) : List<Blog>
}