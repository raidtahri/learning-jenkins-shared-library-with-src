#!/usr/bin/env groovy
def call() {

                echo 'Building the app with Maven'
                sh 'mvn clean package -DskipTests'
                }
       }
