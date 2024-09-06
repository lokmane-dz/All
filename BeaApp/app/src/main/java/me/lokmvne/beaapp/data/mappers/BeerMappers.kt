package me.lokmvne.beaapp.data.mappers

import me.lokmvne.beaapp.data.local.BeerEntity
import me.lokmvne.beaapp.data.remote.BeerDto
import me.lokmvne.beaapp.domain.Beer

fun BeerDto.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = first_brewed,
        imageUrl = image_url
    )
}

fun BeerEntity.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl
    )
}