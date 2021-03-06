package com.minafkamel.postroll.domain

import com.minafkamel.postroll.data.models.GetAllPostsQuery
import com.minafkamel.postroll.data.posts.PostsRepository
import com.minafkamel.postroll.testfixtures.fixturePostData
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetPostDetailsTest : TestCase() {

    @Test
    fun `creates Post domain object from getAllPosts results`() = runBlocking {
        val id = "1"
        val title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
        val body =
            "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae"
        val name = "Leanne Graham"
        val username = "Bret"
        val (_, useCase) = Arrangement()
            .withPostsData(
                listOf(
                    fixturePostData(
                        id = id,
                        title = title,
                        body = body,
                        name = name,
                        username = username
                    )
                )
            )
            .arrange()

        val post = useCase(GetPostDetails.Params(id)).single()

        assertEquals(title, post.title)
        assertEquals(body, post.body)
        assertEquals(name, post.name)
        assertEquals(username, post.username)
    }

    private class Arrangement {

        val repository: PostsRepository = mock(PostsRepository::class.java)

        fun withPostsData(dataList: List<GetAllPostsQuery.Data1>) = apply {
            whenever(repository.getAllPosts()).thenReturn(
                flowOf(GetAllPostsQuery.Data(GetAllPostsQuery.Posts(dataList)))
            )
        }

        fun arrange() =
            this to GetPostDetails(repository)
    }
}
