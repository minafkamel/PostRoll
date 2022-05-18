package com.minafkamel.postroll.data

/**
Simple caching mechanism to minimise BE hitting and support other storing functionality
 */
@Suppress("UNCHECKED_CAST")
class Cache {

    private val cacheMap = HashMap<String, Any?>()

    fun <T> getItem(key: String): T? {
        val value = cacheMap[key] as T
        return if (value != null) return value else null
    }

    fun <T> put(key: String, value: T) {
        cacheMap[key] = value
    }
}
