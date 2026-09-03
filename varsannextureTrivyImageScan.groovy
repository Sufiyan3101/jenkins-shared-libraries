def call(){
  sh '''
    trivy image \
      --severity HIGH,CRITICAL \
      --exit-code 1 \
      annexturec-frontend:latest

    trivy image \
      --severity HIGH,CRITICAL \
      --exit-code 1 \
      annexturec-backend:latest
  '''
}
