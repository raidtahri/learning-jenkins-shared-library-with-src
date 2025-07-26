#!/usr/bin/env groovy
def call() {
           dir('07-hello-maven-shared-library-with-scr-pipeline') {
                echo 'Building the app with Maven'
                sh 'mvn clean package -DskipTests'
                }
}
