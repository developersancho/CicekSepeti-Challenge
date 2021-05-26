package com.ds.ciceksepeti.common.extension

import org.jetbrains.annotations.NotNull

val Any.classTag: String get() = this.javaClass.canonicalName.orEmpty()

val Any.methodTag get() = classTag + object : Any() {}.javaClass.enclosingMethod?.name

fun Any.hashCodeAsString(): String {
    return hashCode().toString()
}

inline fun <reified T : Any> Any.cast(): T {
    return this as T
}

fun Any?.isNull(): Boolean {
    if (this == null)
        return true

    return false
}

@NotNull
fun Any?.isNotNull(): Boolean {
    if (!this.isNull())
        return true
    return false
}

fun List<*>?.isNotNullOrEmpty(): Boolean {
    return !this.isNullOrEmpty()
}