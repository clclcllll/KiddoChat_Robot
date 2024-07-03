package com.example.educationalrobot1.dto;

public class SpeechRecognitionRequest {
    private byte[] audioData;

    // getters and setters
    public byte[] getAudioData() {
        return audioData;
    }

    public void setAudioData(byte[] audioData) {
        this.audioData = audioData;
    }
}
