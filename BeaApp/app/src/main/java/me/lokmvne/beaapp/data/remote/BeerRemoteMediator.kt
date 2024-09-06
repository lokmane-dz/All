package me.lokmvne.beaapp.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import me.lokmvne.beaapp.data.local.BeerDatabase
import me.lokmvne.beaapp.data.local.BeerEntity
import me.lokmvne.beaapp.data.mappers.toBeerEntity

@OptIn(ExperimentalPagingApi::class)
class BeerRemoteMediator(
    private val beerDb: BeerDatabase,
    private val beerApi: BeerApi
) : RemoteMediator<Int, BeerEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BeerEntity>
    ): MediatorResult {
        return try {
            val loadkey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }
            val beers = beerApi.getBeers(
                page = loadkey,
                pageCount = state.config.pageSize
            )

            beerDb.withTransaction {    //withTransaction is a Room extension function to run multiple queries in a single transaction to ensure data consistency
                if (loadType == LoadType.REFRESH) {
                    beerDb.dao.clearAll()
                }
                val beerEntities = beers.map { it.toBeerEntity() }
                beerDb.dao.updateAll(beerEntities)
            }
            MediatorResult.Success(endOfPaginationReached = beers.isEmpty())
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

}