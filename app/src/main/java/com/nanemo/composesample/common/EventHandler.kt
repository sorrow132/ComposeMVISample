package com.nanemo.composesample.common

interface EventHandler<T> {
    fun obtainEvent(event: T)
}