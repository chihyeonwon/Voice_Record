package com.wonchihyeon.voicerecord

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // 음성 녹음 권한요청 코드
    val REQUEST_CODE_RECORD_AUDIO_PERMISSION = 200

    // 앱에서 필요로 하는 권한 배열
    private var permissions: Array<String> = arrayOf(android.Manifest.permission.RECORD_AUDIO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 음성 녹음 권한 Runtime에 권한 요청
        ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_RECORD_AUDIO_PERMISSION)
    }

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
}