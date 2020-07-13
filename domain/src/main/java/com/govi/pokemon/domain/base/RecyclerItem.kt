package com.govi.pokemon.domain.base

interface RecyclerItem {
    val id: Int?
    override fun equals(other: Any?): Boolean
}