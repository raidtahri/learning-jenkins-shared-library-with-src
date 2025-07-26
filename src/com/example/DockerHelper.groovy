package com.example

class DockerHelper implements Serializable {

    def steps
    String dockerDir

    DockerHelper(steps, String dockerDir = '.') {
        this.steps = steps
        this.dockerDir = dockerDir
    }

    def buildDockerImage(String imageName, String imageTag) {
        steps.dir(dockerDir) {
            steps.withCredentials([steps.usernamePassword(
                credentialsId: 'dockerhub',
                usernameVariable: 'DOCKER_USER',
                passwordVariable: 'DOCKER_PASS'
            )]) {
                steps.echo "Building Docker image: ${imageName}:${imageTag}"
                steps.sh "docker build -t ${steps.env.DOCKER_USER}/${imageName}:${imageTag} ."
            }
        }
    }

    def pushToDockerHub(String imageName, String imageTag) {
        steps.withCredentials([steps.usernamePassword(
            credentialsId: 'dockerhub',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {
            steps.echo "Pushing Docker image to Docker Hub"
            steps.sh """
                echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
                docker push \${steps.env.DOCKER_USER}/${imageName}:${imageTag}
                docker logout
            """
        }
    }
}

