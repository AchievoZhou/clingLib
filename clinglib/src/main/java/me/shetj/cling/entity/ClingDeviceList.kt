package me.shetj.cling.entity

import me.shetj.cling.ClingManager
import org.fourthline.cling.model.meta.Device

internal object ClingDeviceList   {

    private var mClingDeviceList: MutableList<ClingDevice> = mutableListOf()



    fun removeDevice(device: ClingDevice?) {
        mClingDeviceList?.remove(device)
    }

    fun addDevice(device: ClingDevice?) {
        device?.let {
            if (contain(device.device)) {
                return
            }
            mClingDeviceList?.add(device)
        }
    }

   fun getClingDevice( device :Device<*,*,*>?):ClingDevice?{
      return mClingDeviceList?.find {
           it.device == device
       }
   }

    fun contain(device:Device<*,*,*>):Boolean{
        return getClingDevice(device) != null
    }

    fun getClingDeviceList(): MutableList<ClingDevice> {
        if (mClingDeviceList == null) {
            mClingDeviceList = ArrayList()
        }
        return mClingDeviceList!!
    }

    fun setClingDeviceList(clingDeviceList: MutableList<ClingDevice>?) {
        clingDeviceList?.let {
            mClingDeviceList = clingDeviceList
        }
    }

    fun clear(){
        mClingDeviceList.clear()
        ClingManager.getInstant().updateCurrentDevices(mClingDeviceList)
    }

}