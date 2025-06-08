package com.genius.spring_boot_starter.controllers

import com.genius.spring_boot_starter.database.model.Blog
import com.genius.spring_boot_starter.database.repository.BlogsRepository
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

/**
 *
 * Author: Thulasi rajan
 * Github: (https://github.com/itsgeniuS)
 * Created on: 08/06/25
 *
 **/

@RestController
@RequestMapping("/blogs")
class BlogController(
	val blogsRepository: BlogsRepository,
) {
	
	data class BlogRequest(
//		val authorId: String,
		val authorName: String,
		
		val id: String?,
		val title: String,
		val description: String,
		val content: String,
		val tags: List<String>,
	)
	
	data class BlogResponse(
		val id: String,
		val title: String,
		val content: String,
		val description: String,
		val createdAt: Instant,
	)
	
	//POST https://localhost:8080/blogs <- saves the blogs
	//if blogId is null then it's treated as INSERT
	//and if blogId is present then UPDATE
	
	@PostMapping
	fun save(@RequestBody blogRequest: BlogRequest): BlogResponse {
		val blog = blogsRepository.save<Blog>(
			Blog(
				id = blogRequest.id?.let { ObjectId(it) } ?: ObjectId.get(),
				title = blogRequest.title,
				description = blogRequest.description,
				content = blogRequest.content,
				tags = blogRequest.tags,
//				authorId = ObjectId(blogRequest.authorId),
				authorName = blogRequest.authorName,
				createdAt = Instant.now(), //will insert the current timestamp,
				
				authorId = ObjectId(), //will create new user id
			)
		)
		
		return blog.toResponse()
	}
	
	//GET https://localhost:8080/blogs/?authorId=<AUTHOR_ID>
	//will return the list of blogs under the authorID
	
	@GetMapping()
	fun getAll(
		@RequestParam(required = true) authorId: String,
	): List<BlogResponse> {
		return blogsRepository.findOwnerById(ObjectId(authorId)).map {
			it.toResponse()
		}
	}
}

private fun Blog.toResponse(): BlogController.BlogResponse {
	return BlogController.BlogResponse(
		id = id.toHexString(),
		title = title,
		content = content,
		description = description,
		createdAt = createdAt
	)
}
