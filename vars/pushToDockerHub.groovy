#!/usr/bin/env groovy
import com.example.DockerHelper

def call(String imageName, String imageTag) {
    def helper = new DockerHelper(this)
    helper.pushImage(imageName, imageTag)
}

