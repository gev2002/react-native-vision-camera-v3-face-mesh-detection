
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNVisionCameraV3FaceMeshDetectionSpec.h"

@interface VisionCameraV3FaceMeshDetection : NSObject <NativeVisionCameraV3FaceMeshDetectionSpec>
#else
#import <React/RCTBridgeModule.h>

@interface VisionCameraV3FaceMeshDetection : NSObject <RCTBridgeModule>
#endif

@end
