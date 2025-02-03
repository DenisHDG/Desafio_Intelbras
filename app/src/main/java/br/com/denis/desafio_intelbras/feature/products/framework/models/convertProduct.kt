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

//// Converte FavoriteProduct para Product
//fun FavoriteProduct.toProduct(): Product {
//    return Product(
//        id = this.id,
//        title = this.title,
//        description = this.description,
//        price = this.price,
//        category = this.category,
//        image = this.image
//        // Adicione outros campos se necessário
//    )
//}