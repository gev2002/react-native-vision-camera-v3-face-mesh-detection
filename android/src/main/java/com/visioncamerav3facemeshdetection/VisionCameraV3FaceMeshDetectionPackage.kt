package com.visioncamerav3facemeshdetection


import com.facebook.react.ReactPackage
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import com.facebook.react.bridge.NativeModule
import com.mrousavy.camera.frameprocessor.FrameProcessorPluginRegistry

class VisionCameraV3FaceMeshDetectionPackage : ReactPackage {
   companion object {
    init {
      FrameProcessorPluginRegistry.addFrameProcessorPlugin("scanFaceMesh") {proxy,options ->
        VisionCameraV3FaceMeshDetectionModule(proxy,options)
      }
    }
  }
  override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
    return emptyList()
  }
  override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
    return emptyList()
  }
}
