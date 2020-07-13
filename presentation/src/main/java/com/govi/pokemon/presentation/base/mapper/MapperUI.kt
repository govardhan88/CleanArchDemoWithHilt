package com.govi.pokemon.presentation.base.mapper

interface MapperUI<DomainObject, UIObject> {

    fun mapToUI(obj: DomainObject): UIObject

}