package com.ds.ciceksepeti.common.extension

import timber.log.Timber

fun Any.debug(tag: String? = null, message: String) {
    tag?.let { Timber.tag(it).d(message) } ?: run { Timber.d(message) }
}

fun Any.debug(tag: String? = null, message: String, tr: Throwable) {
    tag?.let { Timber.tag(it).d(tr, message) } ?: run { Timber.d(tr, message) }
}

fun Any.error(tag: String? = null, message: String) {
    tag?.let { Timber.tag(it).e(message) } ?: run { Timber.e(message) }
}

fun Any.error(tag: String? = null, message: String, tr: Throwable) {
    tag?.let { Timber.tag(it).e(tr, message) } ?: run { Timber.e(tr, message) }
}

fun Any.info(tag: String? = null, message: String) {
    tag?.let { Timber.tag(it).i(message) } ?: run { Timber.i(message) }
}

fun Any.info(tag: String? = null, message: String, tr: Throwable) {
    tag?.let { Timber.tag(it).i(tr, message) } ?: run { Timber.i(tr, message) }
}

fun Any.verbose(tag: String? = null, message: String) {
    tag?.let { Timber.tag(it).v(message) } ?: run { Timber.v(message) }
}

fun Any.verbose(tag: String? = null, message: String, tr: Throwable) {
    tag?.let { Timber.tag(it).v(tr, message) } ?: run { Timber.v(tr, message) }
}

fun Any.warn(tag: String? = null, message: String) {
    tag?.let { Timber.tag(it).w(message) } ?: run { Timber.w(message) }
}

fun Any.warn(tag: String? = null, message: String, tr: Throwable) {
    tag?.let { Timber.tag(it).w(tr, message) } ?: run { Timber.w(tr, message) }
}

fun Any.wtf(tag: String? = null, message: String) {
    tag?.let { Timber.tag(it).wtf(message) } ?: run { Timber.wtf(message) }
}

fun Any.wtf(tag: String? = null, message: String, tr: Throwable) {
    tag?.let { Timber.tag(it).wtf(tr, message) } ?: run { Timber.wtf(tr, message) }
}

/******************/

fun Any.debug(message: String) {
    Timber.d(message)
}

fun Any.debug(message: String, tr: Throwable) {
    Timber.d(tr, message)
}

fun Any.error(message: String) {
    Timber.e(message)
}

fun Any.error(message: String, tr: Throwable) {
    Timber.e(tr, message)
}

fun Any.info(message: String) {
    Timber.i(message)
}

fun Any.info(message: String, tr: Throwable) {
    Timber.i(tr, message)
}

fun Any.verbose(message: String) {
    Timber.v(message)
}

fun Any.verbose(message: String, tr: Throwable) {
    Timber.v(tr, message)
}

fun Any.warn(message: String) {
    Timber.w(message)
}

fun Any.warn(message: String, tr: Throwable) {
    Timber.w(tr, message)
}

fun Any.warn(tr: Throwable) {
    Timber.w(tr)
}

fun Any.wtf(message: String) {
    Timber.wtf(message)
}

fun Any.wtf(message: String, tr: Throwable) {
    Timber.wtf(tr, message)
}

fun Any.wtf(tr: Throwable) {
    Timber.wtf(tr)
}