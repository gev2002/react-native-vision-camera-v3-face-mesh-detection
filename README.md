
# 🚨 Required Modules

react-native-vision-camera => 3.9.0 <br />
react-native-worklets-core = 0.4.0

## 💻 Installation

```sh
npm install react-native-vision-camera-v3-face-mesh-detection
yarn add react-native-vision-camera-v3-face-mesh-detection
```
## 👷Features
    Easy To Use.
    Works Just Writing few lines of Code.
    Works With React Native Vision Camera.
    Works for Both Cameras.
    Works Fast.
    Works With Android 🤖
    Writen With Kotlin.

## 💡 Usage

```js
import { Camera } from 'react-native-vision-camera-v3-face-mesh-detection';

const [face,setFace] = useState(null)

console.log(face)

<Camera
  options={{
   mode: "faceMesh"
    }}
  style={StyleSheet.absoluteFill}
  device={device}
  callback={(data) => setFace(data)}
  {...props}
/>
```


---

## ⚙️ Options

| Name |  Type    |                     Values                      | Default |
|:----:| :---: |:-----------------------------------------------:|:-------:|
| mode | string | faceMesh, boundingBox |  faceMesh  |

















