package app.web.pokemon.domain.products.entity

import app.web.pokemon.domain.base.RecyclerItem

class ProductsFactory {

    companion object {

        fun providesProductDetail(
            id: Int = 1,
            name: String = "Buzz",
            tagline: String = "MVVMTemplate Organic Fairtrade Bananas",
            imageUrl: String = "https://mobile.pokemon.com/webservices/catalogue/items/item/309396011/images/image/0/360x360.jpg",
            description: String = "Organic. Suitable for vegetarians",
            abv: Double = 4.5
        ) = Beer(
            id = id,
            name = name,
            tagline = tagline,
            description = description,
            imageUrl = imageUrl,
            abv = abv
        )

        fun providesBeer(): List<RecyclerItem> = listOf(providesItem())

        private fun providesItem(
            id: Int = 1,
            name: String = "Buzz",
            tagline: String = "MVVMTemplate Organic Fairtrade Bananas",
            imageUrl: String = "https://mobile.pokemon.com/webservices/catalogue/items/item/309396011/images/image/0/360x360.jpg",
            description: String = "Organic. Suitable for vegetarians",
            abv: Double = 4.5
        ) = Beer(
            id = id,
            name = name,
            tagline = tagline,
            description = description,
            imageUrl = imageUrl,
            abv = abv
        )
    }

}