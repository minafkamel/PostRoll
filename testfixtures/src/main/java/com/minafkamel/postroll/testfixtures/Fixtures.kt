package com.minafkamel.postroll.testfixtures

import com.minafkamel.postroll.data.models.GetAllPostsQuery
import com.minafkamel.postroll.data.models.GetPostDetailsQuery

fun fixturePostData(
    id: String = "id",
    title: String = "title",
    body: String = "body",
) = GetAllPostsQuery.Data1(id, title, body)

fun fixtureDetails(
    title: String = "title",
    name: String = "name",
    username: String = "username",
) = GetPostDetailsQuery.Post(title, GetPostDetailsQuery.User(name, username))
