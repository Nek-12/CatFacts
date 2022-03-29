package com.nek12.catfacts.data.repo

import com.nek12.androidutils.extensions.core.ApiResult
import com.nek12.androidutils.extensions.core.wrap
import com.nek12.catfacts.data.api.CatApi
import com.nek12.catfacts.data.db.dao.CatDao
import com.nek12.catfacts.data.db.entity.CatEntity

class CatRepo(
    private val dao: CatDao,
    private val api: CatApi,
) {

    fun getHistory() = dao.getAllByCreatedDate()

    suspend fun randomFact() = ApiResult.wrap { //wrap exceptions

        val fact = CatEntity(api.randomFact().fact)
        dao.add(fact) //will always create a new value to keep full history

        //! Since the api does not provide "created at" we'll always just use current time
        // (i.e. display the time quote was shown, not created on the BE)
        fact
    }

}
