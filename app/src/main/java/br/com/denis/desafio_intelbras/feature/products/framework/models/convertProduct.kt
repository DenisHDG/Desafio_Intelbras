package br.com.denis.desafio_intelbras.feature.products.framework.models

import br.com.denis.desafio_intelbras.feature.products.domain.entites.FavoriteProduct

fun Product.toFavoriteProduct(): FavoriteProduct {
    return FavoriteProduct(
        id = this.id,
        title = this.title,
        description = this.description,
        price = this.price,
        category = this.category,
        image = this.image
    )
}