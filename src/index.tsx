import React from 'react';
import { useRunInJS } from 'react-native-worklets-core';
import {
  VisionCameraProxy,
  Camera as VisionCamera,
  useFrameProcessor,
} from 'react-native-vision-camera';
import { Platform } from 'react-native';
import type {
  FrameProcessorPlugin,
  Frame,
  FaceMeshDetectionOptions,
  FrameProcessor,
  CameraTypes,
} from './types';
const plugin: FrameProcessorPlugin | undefined =
  VisionCameraProxy.initFrameProcessorPlugin('scanFaceMesh');

const LINKING_ERROR =
  `The package 'react-native-vision-camera-v3-face-mesh-detection' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

function scanFaceMesh(frame: Frame, options: FaceMeshDetectionOptions): any {
  'worklet';
  if (plugin == null) throw new Error(LINKING_ERROR);
  // @ts-ignore
  return options ? plugin.call(frame, options) : plugin.call(frame);
}

export const Camera = (props: CameraTypes) => {
  const { callback, device, options } = props;
  // @ts-ignore
  const useWorklets = useRunInJS((data: object): void => {
    callback(data);
  }, []);
  const frameProcessor: FrameProcessor = useFrameProcessor(
    (frame: Frame): void => {
      'worklet';
      // @ts-ignore
      const data: object = scanFaceMesh(frame, options);
      // @ts-ignore
      useWorklets(data);
    },
    []
  );
  return (
    !!device && <VisionCamera frameProcessor={frameProcessor} {...props} />
  );
};
