package com.example.sihati_labo.viewmodels

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sihati_labo.Database.Test
import com.example.sihati_labo.repositories.TestRepository

class TestViewModel : ViewModel() {
    private val mRepository = TestRepository()
    var testsReady: MutableLiveData<List<Test>>? = null
    var pendingTests: MutableLiveData<List<Test>>? = null
    var testsWithId: MutableLiveData<List<Test>>? = null

    fun init() {
        testsReady = mRepository.testsReady
        pendingTests = mRepository.pendingTests
    }

    fun getTestsWithScheduleId(id:String){
        mRepository.getTestsWithScheduleId(id)
        testsWithId = mRepository.testsWithId
    }

    fun updateTest(test: Test, newTest: Test){
        mRepository.updateTest(test,newTest)
    }

    fun updateUser(uid: String, result: String){
        mRepository.updateUser(uid,result)
    }

    fun sendNotificationToUserWithID(test: Test,activity: Activity,edit:Boolean){
        mRepository.sendNotificationToUserWithID(test,activity,edit)
    }

    fun deleteTestsWithScheduleID(id: String) {
        mRepository.deleteTestsWithScheduleID(id)
    }
}