package com.visioncamerav3facemeshdetection


import android.media.Image
import com.facebook.react.bridge.WritableNativeMap
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.mlkit.vision.common.InputImage
import com.mrousavy.camera.frameprocessor.Frame
import com.mrousavy.camera.frameprocessor.FrameProcessorPlugin
import com.mrousavy.camera.frameprocessor.VisionCameraProxy



class VisionCameraV3FaceMeshDetectionModule(proxy : VisionCameraProxy, options: Map<String, Any>?): FrameProcessorPlugin() {
  override fun callback(frame: Frame, arguments: Map<String, Any>?): Any {
    val mediaImage: Image = frame.image
      try {
        val image = InputImage.fromMediaImage(mediaImage, 0)

        val detector : TextRecognizer = when (arguments?.get("mode")) {
            "faceMesh" -> FaceMeshDetection.getClient(FaceMeshDetectorOptions.DEFAULT_OPTIONS)
            "boundingBox" -> FaceMeshDetection.getClient(FaceMeshDetectorOptions.Builder().setUseCase(UseCase.BOUNDING_BOX_ONLY) .build())
            else -> FaceMeshDetection.getClient(FaceMeshDetectorOptions.DEFAULT_OPTIONS)
            }
       // val task: Task<Text> = recognizer.process(image)
        //val result: Text? = Tasks.await(task)
        val map = WritableNativeMap()


        return map.toHashMap()
      } catch (e: Exception) {
       throw  Exception("Error processing face mesh detection: $e ")
      }
  }
}



