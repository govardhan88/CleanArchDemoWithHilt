package com.govi.pokemon.domain.base.usecase

interface GeneralUseCase<Type, in Params> {

    suspend operator fun invoke(params: Params): Type

}