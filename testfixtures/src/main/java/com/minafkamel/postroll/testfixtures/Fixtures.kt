package com.minafkamel.postroll.testfixtures

import com.minafkamel.postroll.data.models.GetAllPostsQuery

fun fixturePostData(
    id: String = "id",
    title: String = "title",
    body: String = "body",
    name: String = "name",
    username: String = "username",
) = GetAllPostsQuery.Data1(id, title, body, GetAllPostsQuery.User(name, username))
