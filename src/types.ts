export type {
  CameraProps,
  Frame,
  FrameProcessorPlugin,
  FrameProcessor,
} from 'react-native-vision-camera';
import type { CameraProps } from 'react-native-vision-camera';
export interface FaceMeshDetectionOptions {
  mode: 'faceMesh' | 'boundingBox';
}

export type CameraTypes = {
  callback: Function;
  options: FaceMeshDetectionOptions;
} & CameraProps;
