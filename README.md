# *목표*

안드로이드 앱에서 음성 및 동영상 재생/ 저장 기능은 강의, 회의, 인터뷰 등을 기록하는 데 사용될 수 있으며,
또 음악, 팟캐스트 또는 기타 오디오 프로젝트를 만들기 위해 음성 녹음을 사용할 수 있습니다.    
중요한 개인적 또는 업무적 순간을 기록하고 보관하는 데 도움이 됩니다. 이는 나중에 참조하거나 추억을 되새기는 데 유용할 수 있습니다    
학생들은 강의를 녹음하여 나중에 복습할 수 있으며, 교사들은 교육 자료를 만들기 위해 동영상을 녹화할 수 있습니다  
다양한 프로젝트에 적용될 수 있는 음성 및 동영상 재생/ 저장 기능을 만들어보고 향후 프로젝트에 적용하기 위함입니다.   

## 관련 권한 추가
```kotlin
 <!-- 음성 녹음을 위한 권한 사용 추가 -->
    <uses-permission android:name="android.permission.RECORD_AUDIO" />
    
    <!-- 카메라 기능 사용 -->
    <uses-feature
        android:name="android.hardware.camera"
        android:required="true"/>
```
```
음성 녹음에 대한 사용 권한과 카메라 기능(Feature)에 관한 권한 사용을 추가하였습니다.
```
## 레이아웃
![image](https://github.com/chihyeonwon/Voice_Record/assets/58906858/6439a6d7-ba39-454a-8562-db194952754b)
```
레이아웃은 상단에 음성을 녹음하고 재생하는 버튼 두개와 바로 밑에 동영상 녹화하는 버튼을 주고
동영상 녹화 버튼 아래에 녹화한 동영상을 재생할 수 있는 인터페이스를 줬다.
```
## 음성 녹음 권한 요청
#### 권한 요청 코드 변수
```kotlin
// 음성 녹음 권한요청 코드
    val REQUEST_CODE_RECORD_AUDIO_PERMISSION = 200

    // 앱에서 필요로 하는 권한 배열
    private var permissions: Array<String> = arrayOf(android.Manifest.permission.RECORD_AUDIO)
```
#### 런타임 권한 요청
```kotlin
// 음성 녹음 권한 Runtime에 권한 요청
        ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_RECORD_AUDIO_PERMISSION)
```
#### 권한 요청 수락/거절 로직
```kotlin
// 권한 요청이 완료된 경우 호출되는 함수
    // 권한을 거절한 경우 종료
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        val permissionToRecordAccepted = if(requestCode == REQUEST_CODE_RECORD_AUDIO_PERMISSION) {
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        } else {
            false
        }
        if (!permissionToRecordAccepted) finish()
    }
```
```
앱이 실행되면 음성 녹음에 대한 권한을 권한 코드 200으로 요청한다.
만약 권한 요청이 수락된 경우 (requestCode가 200인 경우) 결과에 권한 허가에 해당하는 값을 넣고
권한 요청이 거부된 경우 앱을 종료한다.
```
#### 음성 녹음 권한 수락 시 
![2024-06-30 17;08;36](https://github.com/chihyeonwon/Voice_Record/assets/58906858/f76d4392-c605-4004-b45b-b657ef77ce0f)

#### 음성 녹음 권한 거부 시
![2024-06-30 17;10;10](https://github.com/chihyeonwon/Voice_Record/assets/58906858/1f57f3df-7a6f-4616-9cb6-0c6ecb67e46e)






