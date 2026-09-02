def call(String imageName, String imageTag) {

    echo "Pushing ${imageName}:${imageTag}..."

    withCredentials([usernamePassword(
        credentialsId: 'notes_app_docker_hub',
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockerHubUser'
    )]) {

        sh '''
            echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
        '''

        sh """
            docker image tag ${imageName}:${imageTag} \
                ${dockerHubUser}/${imageName}:${imageTag}
        """

        sh """
            docker push ${dockerHubUser}/${imageName}:${imageTag}
        """
    }

    echo "${imageName}:${imageTag} pushed successfully!"
}
