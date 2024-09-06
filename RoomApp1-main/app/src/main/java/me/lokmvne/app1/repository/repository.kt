package me.lokmvne.app1.repository

import me.lokmvne.app1.data.MyPicture
import me.lokmvne.app1.data.PictureDao
import me.lokmvne.app1.utils.Resource
import javax.inject.Inject

class repository @Inject constructor(private val dao: PictureDao) {
    suspend fun getPicture(): Resource<List<MyPicture>> {
        return try {
            Resource.Success(dao.getAll())
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }

    suspend fun addPicture(myPicture: MyPicture): Resource<Long> {
        return try {
            Resource.Success(dao.AddPicture(myPicture))
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}