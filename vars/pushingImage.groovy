def call(String: imageName, String: imageTag, String: dockerHubUser){
  echo  "Image pushing has been started..."
  withCredentials([usernamePassword(
    'credentialsId': "notes_app_docker_hub",
    passwordVariable: "dockerHubPass",
    usernameVariable: "dockerHubUser"
  )]){
    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
    sh "docker image tag django_app:latest ${env.dockerHubUser}/django_app:latest"
    sh "docker push "${dockerHubUser}"/"${imageName}":"${imageTag}"
  }
  echo "Image pushed Successfully..."
}
