#!/usr/bin/env groovy
import com.example.DockerHelper

def call(String imageName, String imageTag) {
    def helper = new DockerHelper(this, '07-hello-maven-shared-library-with-scr-pipeline')
    helper.buildDockerImage(imageName, imageTag)
}
