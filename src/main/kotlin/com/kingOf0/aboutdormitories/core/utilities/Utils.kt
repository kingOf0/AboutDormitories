package com.kingOf0.aboutdormitories.core.utilities

inline fun <reified T> copyFields(from: T, to: T) {
    for (field in T::class.java.declaredFields) {
        field.isAccessible = true
        field.set(to, field.get(from))
    }
}