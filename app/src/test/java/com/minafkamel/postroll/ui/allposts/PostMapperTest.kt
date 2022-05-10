package com.minafkamel.postroll.ui.allposts

import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostMapperTest : TestCase() {

    @Test
    fun `takes only first 120 chars from body then adds 3 dots`() {
        val mapper = PostMapper()
        val expectedCount = 123
        val mapped = mapper(
            "1",
            "title",
            "est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla"
        )

        assertEquals(expectedCount, mapped.body.length)
    }
}
